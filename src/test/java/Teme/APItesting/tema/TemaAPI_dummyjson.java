package Teme.APItesting.tema;

import io.restassured.http.ContentType;
import Teme.Utils.UtilsAPI;
import Teme.Config.ConfigTests;
import Teme.DataAPI_tests.Data;

import org.testng.annotations.Test;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;




public class TemaAPI_dummyjson{

    @Test
    public void getFiveProductsTest() {

        Response response = given()
                .baseUri(ConfigTests.Dummy_Domain)
                .queryParam("limit", 5)
                .when()
                .get(ConfigTests.PRODUCTS_ENDPOINT_dummy);

        response.then()
                .statusCode(200)
                .body("limit", equalTo(5))
                .body("products", hasSize(5));

        List<Integer> ids = response.jsonPath().getList("products.id");

        System.out.println("Lista ID-uri:");

        for (Integer id : ids) {
            System.out.println(id);
        }
    }

    @Test
    public void SearchPhoneTest() {
        Response response = given()
                .baseUri(ConfigTests.Dummy_Domain)
                .queryParam("q", Data.SEARCH_PRODUCT)

                .when()
                .get("/products/search");

        response.then()
                .statusCode(200)
                .body("products",not(empty()))
                .body("products[0].title", notNullValue())
                .body("products[0].title",not(equalTo("")))
                .body("products[0].price", greaterThan(0F));

        System.out.println("Primul produs:");
        System.out.println("Title: " + response.jsonPath().getString("products[0].title"));
        System.out.println("Price: " + response.jsonPath().getFloat("products[0].price"));
    }

    @Test
    public void loginTest() {

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
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(ConfigTests.LOGIN_ENDPOINT_dummy);

        response.prettyPrint();

        response.then()
                .statusCode(200);

        String token = response.jsonPath().getString("accessToken");

        System.out.println("TOKEN:");
        System.out.println(token);
    }
    @Test
    public void getAuthenticatedUserTest() {

        String token = UtilsAPI.getAccessToken();

        Response response = given()
                .baseUri(ConfigTests.Dummy_Domain)
                .header("Authorization", "Bearer " + token)
                .when()
                .get(ConfigTests.AUTH_ME_ENDPOINT_dummy);

        response.prettyPrint();

        response.then()
                .statusCode(200)
                .body("username", equalTo(Data.LOGIN_USERNAME))
                .body("firstName", notNullValue())
                .body("email", notNullValue());
    }
}


