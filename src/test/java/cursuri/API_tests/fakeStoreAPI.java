package cursuri.API_tests;

import io.restassured.specification.Argument;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;


public class fakeStoreAPI {

    @Test

    public void product1Test(){
        given()
                .when()
                .get("https://fakestoreapi.com/products/1")
                .then()
                .body("id", equalTo(1))
                .body("title", notNullValue());
    }


    }

         
