package ru.kaiten.api.tests.patch;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.kaiten.api.ApiTestBase;
import ru.kaiten.api.Constants;
import ru.kaiten.api.models.UserRoleRequest;
import ru.kaiten.api.models.UserRoleResponse;

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
        UserRoleRequest userRole = new UserRoleRequest();
        userRole.setName(Constants.UPDATING_USER_ROLE);

        UserRoleResponse response = step("Make request", ()->
                given(userRoleRequestSpec)
                        .body(userRole)
                        .when()
                        .patch("/user-roles/"+Constants.UPDATING_ROLE_ID)
                        .then()
                        .spec(responseSpec200)
                        .extract().as(UserRoleResponse.class));

        step("Check response", ()->{
            assertEquals("24395", response.getId());
            assertEquals("359271", response.getCompanyId());
            assertEquals(Constants.UPDATING_USER_ROLE, response.getName());
            assertEquals("aa9c2831-1513-4fc1-b3a7-cf7db983b39b", response.getUid());
           });
    }
}
