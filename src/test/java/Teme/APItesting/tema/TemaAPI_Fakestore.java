package Teme.APItesting.tema;

import Teme.Config.ConfigTests;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TemaAPI_Fakestore {

    @Test
    public void getProductByIdTest() {

        given()
                .when()
                .get(ConfigTests.Fake_store_api_domain + ConfigTests.PRODUCT_BY_ID_ENDPOINT)
                .then()
                //.log().body()
                    .statusCode(200)
                    .body("id", equalTo(1))
                    .body("title", notNullValue())
                    .body("title", not(equalTo("")))
                    .body("price", greaterThan(0F));

    }
    @Test
    public void getAllProductsList() {

        given()
                .when()
                .get(ConfigTests.Fake_store_api_domain + ConfigTests.PRODUCTS_ENDPOINT)
                .then()
                //.log().body()
                .statusCode(200)
                .body("size()", greaterThan(0))
                .body("[0].title", notNullValue())
                .body("[0].title", not(equalTo("")))
                .body("[0].category", notNullValue())
                .body("[0].category", not(equalTo("")))
                .body("[0].image", notNullValue())
                .body("[0].image", not(equalTo("")));
    }
    @Test
    public void customBodyTest() {

        String payload = "{ \"title\": \"Mens Casual\", \"category\": \"men's clothing\" }";

        given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(ConfigTests.Fake_store_api_domain + ConfigTests.PRODUCTS_ENDPOINT)
                .then()
                .log().body()
                // Requirement says 200, but FakeStore API returns 201 Created for POST /products.
                .statusCode(201)
                .body("title", containsString("Mens Casual"))
                .body("category", equalTo("men's clothing"));
    }
}