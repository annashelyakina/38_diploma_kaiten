package ru.kaiten.specs;

import ru.kaiten.api.Constants;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;

public class UserRoleSpec {

     public static RequestSpecification userRoleRequestSpec = with()
             .filter(withCustomTemplates())
             .log().all()
             .contentType("application/json")
             .accept("application/json")
             .auth().oauth2(Constants.VALID_TOKEN);

    public static RequestSpecification invalidTokenRequestSpec = with()
            .filter(withCustomTemplates())
            .log().all()
            .contentType("application/json")
            .accept("application/json")
            .auth().oauth2(Constants.INVALID_TOKEN);

    public static ResponseSpecification responseSpec200 = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.ALL)
            .build();

    public static ResponseSpecification responseSpec204 = new ResponseSpecBuilder()
            .expectStatusCode(204)
            .log(LogDetail.ALL)
            .build();

    public static ResponseSpecification responseSpec400 = new ResponseSpecBuilder()
            .expectStatusCode(400)
            .log(LogDetail.ALL)
            .build();

    public static ResponseSpecification responseSpec401 = new ResponseSpecBuilder()
            .expectStatusCode(401)
            .log(LogDetail.ALL)
            .build();

    public static ResponseSpecification responseSpec403 = new ResponseSpecBuilder()
            .expectStatusCode(403)
            .log(LogDetail.ALL)
            .build();
}
