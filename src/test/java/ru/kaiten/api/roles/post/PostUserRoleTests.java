package ru.kaiten.api.roles.post;

import ru.kaiten.api.ApiTestBase;
import ru.kaiten.api.Constants;
import ru.kaiten.api.models.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.kaiten.api.models.PostUserRoleModel;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.kaiten.api.specs.UserRoleSpec.*;

@Tag("api_tests")
public class PostUserRoleTests extends ApiTestBase {

    @Test
    @DisplayName("Проверка успешного создания роли пользователя методом POST")
    public void successfulCreateUserRoleTest() {
        PostUserRoleModel userRole = new PostUserRoleModel();
        userRole.setName(Constants.USER_ROLE);

        PostUserRoleResponseModel response = step("Make request", ()->
        given(userRoleRequestSpec)
                .body(userRole)
                .when()
                .post("/user-roles")
                .then()
                .spec(responseSpec200)
                .extract().as(PostUserRoleResponseModel.class));

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
        PostUserRoleModel userRole = new PostUserRoleModel();
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
        PostUserRoleModel userRole = new PostUserRoleModel();
        userRole.setName(Constants.NON_UNIQUE_USER_ROLE);

        NonUniqueUserRoleResponseModel response = step("Make request", ()->
                given(userRoleRequestSpec)
                        .body(userRole)
                        .when()
                        .post("/user-roles")
                        .then()
                        .spec(responseSpec400)
                        .extract().as(NonUniqueUserRoleResponseModel.class));

        step("Check response", ()->
            assertEquals("Role name attribute should be uniq for company", response.getMessage()));
    }
}
