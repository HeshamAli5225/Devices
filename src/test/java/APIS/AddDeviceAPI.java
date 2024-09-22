package APIS;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AddDeviceAPI {
    public static String baseUrl="https://api.restful-api.dev/objects";
    public static String id;

    public static Response addDevice(){

        String requestBody="{\"name\": \"IPhone20\",\"data\": {\"year\": 2024,\"price\": 40000.00,\"CPU model\": \"alpha\",\"Hard disk size\": \"250 GB\" } }";

        Response response=RestAssured.given()
                .baseUri(baseUrl)
                .header("Content-Type","application/json").
                body(requestBody).when().post();
        System.out.println(response.prettyPrint());
        id=response.then().extract().response().jsonPath().getString("id");

        return response;
    }
}
