package ru.kaiten.api.roles;

import ru.kaiten.api.ApiTestBase;
import ru.kaiten.api.Constants;
import ru.kaiten.api.lombok.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.kaiten.api.lombok.PostUserRoleLombokModel;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.kaiten.specs.UserRoleSpec.*;

@Tag("api_tests")
public class UserRoleTests extends ApiTestBase {

    @Test
    @DisplayName("Проверка успешного создания роли пользователя методом POST")
    public void successfulCreateUserRoleTest() {
        PostUserRoleLombokModel userRole = new PostUserRoleLombokModel();
        userRole.setName(Constants.USER_ROLE);

        PostUserRoleResponseLombokModel response = step("Make request", ()->
        given(userRoleRequestSpec)
                .body(userRole)
                .when()
                .post("/user-roles")
                .then()
                .spec(responseSpec200)
                .extract().as(PostUserRoleResponseLombokModel.class));

        step("Check response", ()->{
            assertEquals(Constants.USER_ROLE, response.getName());
            assertThat(response.getCompany_id(), is(notNullValue()));
            assertThat(response.getCreated(), is(matchesPattern("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d+Z")));
            assertThat(response.getUpdated(), is(matchesPattern("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d+Z")));
         });
    }

    @Test
    @DisplayName("Проверка статус кода и сообщения об ошибке в случае невалидного токена")
    public void invalidTokenTest() {
        PostUserRoleLombokModel userRole = new PostUserRoleLombokModel();
        userRole.setName(Constants.USER_ROLE);

        String responseBody = step("Make request", ()-> {
        return given(invalidTokenRequestSpec)
                .body(userRole)
                .when()
                .post("/user-roles")
                .then()
                .spec(responseSpec401)
                .extract().body().asString();
        });

        step("Check response message", ()-> {
            assertEquals("Unauthorized", responseBody.trim());
        });
    }

    @Test
    @DisplayName("Проверка статус кода и сообщения об ошибке в случае неуникального названия роли пользователя")
    public void createNonUniqueUserRoleTest() {
        PostUserRoleLombokModel userRole = new PostUserRoleLombokModel();
        userRole.setName(Constants.NON_UNIQUE_USER_ROLE);

        NonUniqueUserRoleResponseLombokModel response = step("Make request", ()->
                given(userRoleRequestSpec)
                        .body(userRole)
                        .when()
                        .post("/user-roles")
                        .then()
                        .spec(responseSpec400)
                        .extract().as(NonUniqueUserRoleResponseLombokModel.class));

        step("Check response", ()->
            assertEquals("Role name attribute should be uniq for company", response.getMessage()));
    }

    @Test
    @DisplayName("Проверка успешного получения существующей роли пользователя методом GET")
    public void successfulGetUserRoleTest() {
        PostUserRoleResponseLombokModel response = step("Make request", ()->
                given(userRoleRequestSpec)
                        .when()
                        .get("/user-roles/"+Constants.EXISTING_ROLE_ID)
                        .then()
                        .spec(responseSpec200)
                        .extract().as(PostUserRoleResponseLombokModel.class));

        step("Check response", ()->{
            assertEquals("24386", response.getId());
            assertEquals("359271", response.getCompany_id());
            assertEquals("testRole", response.getName());
            assertEquals("6fbd64cc-22ed-4c0b-8512-7b1c1e8cb0f3", response.getUid());
        });
    }

    @Test
    @DisplayName("Проверка успешного обновления существующей роли пользователя методом PATCH")
    public void successfulUpdateUserRoleTest() {
        PostUserRoleLombokModel userRole = new PostUserRoleLombokModel();
        userRole.setName(Constants.USER_ROLE);

        PostUserRoleResponseLombokModel response = step("Make request", ()->
                given(userRoleRequestSpec)
                        .body(userRole)
                        .when()
                        .patch("/user-roles/"+Constants.UPDATING_ROLE_ID)
                        .then()
                        .spec(responseSpec200)
                        .extract().as(PostUserRoleResponseLombokModel.class));

        step("Check response", ()->{
            assertEquals("24395", response.getId());
            assertEquals("359271", response.getCompany_id());
            assertEquals(Constants.USER_ROLE, response.getName());
            assertEquals("aa9c2831-1513-4fc1-b3a7-cf7db983b39b", response.getUid());
                });
    }

  }
