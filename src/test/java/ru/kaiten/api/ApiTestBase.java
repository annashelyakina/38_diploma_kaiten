package ru.kaiten.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class ApiTestBase {
    @BeforeAll
    public static void beforeAll() {
        RestAssured.baseURI = "https://annashelyakina82.kaiten.ru";
        RestAssured.basePath = "/api/latest/";
    }
}
