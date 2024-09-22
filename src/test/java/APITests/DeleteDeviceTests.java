package APITests;

import APIS.AddDeviceAPI;
import APIS.DeleteDeviceAPI;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class DeleteDeviceTests {


    static String id;
    static Response deleteResponse;
    @BeforeClass
    public static void start(){
        id= AddDeviceAPI.id;
        deleteResponse= DeleteDeviceAPI.deleteDevice(id);

    }
    @Test(priority = 1)
    public void validate_delete_status_code(){
        Assert.assertEquals(deleteResponse.statusCode(),200);
    }

    @Test(priority = 2)
    public void validate_delete_schema(){

        File deleteSchemaFile = new File("src/test/java/Schema/deleteSchema.json");
        deleteResponse.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(deleteSchemaFile));


    }


}
