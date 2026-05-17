package Teme.Utils;

import Teme.Config.ConfigTests;
import Teme.DataAPI_tests.Data;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UtilsAPI {

    public static String AccessToken() {

        String body = """
                {
                    "username": "%s",
                    "password": "%s"
                }
                """.formatted(
                Data.LOGIN_USERNAME,
                Data.LOGIN_PASSWORD
        );

        Response response = given()
                .baseUri(ConfigTests.Dummy_Domain)
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(ConfigTests.LOGIN_ENDPOINT_dummy);

        return response.jsonPath().getString("accessToken");
    }
}
