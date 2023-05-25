import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class TestFakeApi {

    @Test
    void test_get_01() {
        baseURI = "http://localhost:3000";
        given().get("users").then().statusCode(HttpStatus.SC_OK);

    }

    @Test
    void test_post_01(){
        baseURI = "http://localhost:3000";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName","Tina");
        jsonObject.put("lastName","Saxena");
        jsonObject.put("subjectId",2);
        given().contentType(ContentType.JSON).body(jsonObject.toJSONString()).post("users").then().statusCode(HttpStatus.SC_CREATED);

    }
    @Test
    void test_put_01(){
        baseURI = "http://localhost:3000";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName","JyotiK");
        jsonObject.put("subjectId",1);
        given().contentType(ContentType.JSON).body(jsonObject.toJSONString()).patch("users/2").then().statusCode(HttpStatus.SC_OK);
    }

    @Test
    void test_patch_01(){
        baseURI = "http://localhost:3000";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName","Saurabh");
        jsonObject.put("lastName","Saxena");
        jsonObject.put("subjectId",1);
        given().contentType(ContentType.JSON).body(jsonObject.toJSONString()).patch("users/4").then().statusCode(HttpStatus.SC_OK);


    }
    @Test
    void test_delete_01(){
        baseURI = "http://localhost:3000";
        given().contentType(ContentType.JSON).delete("users/4").then().statusCode(HttpStatus.SC_OK);
    }




}