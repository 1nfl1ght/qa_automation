package org.swagger.io.test;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.asynchttpclient.util.Assertions;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class SwaggerIoTest {

    @Test(description = "POST")
    public void addNewPet() {

        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        String requestBody = """
                {
                  "id": 10,
                  "category": {
                    "id": 0,
                    "name": "name"
                  },
                  "name": "doggie",
                  "photoUrls": [
                    "string"
                  ],
                  "tags": [
                    {
                      "id": 0,
                      "name": "pet10"
                    }
                  ],
                  "status": "available"
                }""";

        Response response = null;

        try {
            response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                    .post("/pet");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Response :" + response.asString());
    }

    @Test(description = "GET")
    public void getPet() {
        given().when().get("https://petstore.swagger.io/v2/pet/10").then().log().all();
    }

    @Test(description = "DELETE")
    public void deletePet() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        Response response = given()
                .header("Content-type", "application/json")
                .when()
                .delete("/pet/10")
                .then()
                .extract().response();
    }

}
