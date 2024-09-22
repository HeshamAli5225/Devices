package APIS;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteDeviceAPI {
    public static String baseUrl="https://api.restful-api.dev/objects/";
    public static Response deleteDevice(String id){

        Response response=RestAssured.given().baseUri(baseUrl).when().delete(id);
        System.out.println(response.prettyPrint());
        return response;
    }
}
