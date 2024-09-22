package APITests;

import APIS.AddDeviceAPI;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class AddDeviceTests {


    static Response addResponse;

    @Test(priority = 1)
    public void validate_status_code(){
        addResponse=AddDeviceAPI.addDevice();
        Assert.assertEquals(addResponse.statusCode(),200);
          }

    @Test(priority = 2)
    public void validate_add_schema(){
                File addSchemaFile = new File("src/test/java/Schema/addSchema.json");
        addResponse.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(addSchemaFile));
    }



}
