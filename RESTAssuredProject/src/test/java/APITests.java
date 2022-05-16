import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITests {

    @Test(priority = 1)
    void getTest(){

        Response response = get("https://reqres.in/api/users?page=2");

        System.out.println("RESPONSE : " +response.asString());
        System.out.println("STATUS CODE : " +response.getStatusCode());
        System.out.println("BODY : " +response.getBody().asString());
        System.out.println("TIME : " +response.getTime());
        System.out.println("HEADER : " +response.getHeader("content-type"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);

        System.out.println("*****************************");
    }

    @Test(priority = 2)
    void getTest2(){

        given().
                get("https://reqres.in/api/users?page=2").
        then().
                statusCode(200).
                log().all();
    }
}
