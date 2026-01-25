package ru.kaiten.api.tests.get;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.kaiten.api.ApiTestBase;
import ru.kaiten.api.Constants;
import ru.kaiten.api.models.UserRoleResponse;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.kaiten.api.specs.UserRoleSpec.*;

@Tag("api_tests")
public class GetUserRoleTests extends ApiTestBase {

    @Test
    @DisplayName("Проверка успешного получения существующей роли пользователя методом GET")
    public void successfulGetUserRoleTest() {
        UserRoleResponse response = step("Make request", ()->
                given(userRoleRequestSpec)
                        .when()
                        .get("/user-roles/"+Constants.EXISTING_ROLE_ID)
                        .then()
                        .spec(responseSpec200)
                        .extract().as(UserRoleResponse.class));

        step("Check response", ()->{
            assertEquals("24386", response.getId());
            assertEquals("359271", response.getCompanyId());
            assertEquals("testRole", response.getName());
            assertEquals("6fbd64cc-22ed-4c0b-8512-7b1c1e8cb0f3", response.getUid());
        });
    }
}
