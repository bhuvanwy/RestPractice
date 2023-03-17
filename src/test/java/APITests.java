import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.google.gson.JsonObject;
import org.json.JSONObject.*;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class APITests {
    @Test
    public static void test1() {
        Response response = get("https://reqres.in/api/users?page=2");
        System.out.println(response.getBody().asString());
        int statusCode = response.getStatusCode();
        assertEquals(statusCode, 200,"success");
    }

    @Test
    public static void test2() {
        given().get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200);
    }

    @Test
    public static void test3() {
        RequestSpecification request = RestAssured.given();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "bhuvan");
        jsonObject.put("job", "leadqa");
        jsonObject.put("id", "23132131");
        //jsonObject.put("createdAt", "2023-03-17T10:27:53.668Z");
        request.body(jsonObject.toJSONString());
        Response response = post("https://reqres.in/api/users");
        System.out.println(response.getBody().asString());
        int statusCode = response.getStatusCode();
        assertEquals(statusCode, 201,"success");
    }
}
