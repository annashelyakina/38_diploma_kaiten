package ru.kaiten.api.roles.patch;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.kaiten.api.ApiTestBase;
import ru.kaiten.api.Constants;
import ru.kaiten.api.models.PostUserRoleLombokModel;
import ru.kaiten.api.models.PostUserRoleResponseLombokModel;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.kaiten.api.specs.UserRoleSpec.responseSpec200;
import static ru.kaiten.api.specs.UserRoleSpec.userRoleRequestSpec;

@Tag("api_tests")
public class PatchUserRoleTests extends ApiTestBase {

    @Test
    @DisplayName("Проверка успешного обновления существующей роли пользователя методом PATCH")
    public void successfulUpdateUserRoleTest() {
        PostUserRoleLombokModel userRole = new PostUserRoleLombokModel();
        userRole.setName(Constants.UPDATING_USER_ROLE);

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
            assertEquals(Constants.UPDATING_USER_ROLE, response.getName());
            assertEquals("aa9c2831-1513-4fc1-b3a7-cf7db983b39b", response.getUid());
           });
    }
}
