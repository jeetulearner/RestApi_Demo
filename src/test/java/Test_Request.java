import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;


import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Test_Request {
    @Test
    public void test_get(){
    given().get("https://reqres.in/api/users?page=2").then()
            .body("data.id[1]",equalTo(8))
            .body("data.last_name",hasItems("Lawson","Ferguson","Funke")).statusCode(200).log().all();
    }
   @Test
    public void test_get_2(){
        baseURI = "https://reqres.in";
        given().param("page",2).get("api/users").then()
                .body("data.id[1]",equalTo(8))
                .body("data.last_name",hasItems("Lawson","Ferguson","Funke")).statusCode(200).log().all();
   }
   @Test
   public void test_get_3(){
        given()
                .header("till-type","refund")
                .get("https://reqres.in/api/users?page=2").then()
                .body("data.id[1]",equalTo(8))
                .body("data.last_name",hasItems("Lawson","Ferguson","Funke")).statusCode(200).log().all();

   }
   @Test
    public void test_post_1(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","tablet");
        map.put("quantity",Integer.valueOf(1));
        map.put("price",Integer.valueOf(200));
        System.out.println("Map:" + map);
        JSONObject jsonObject = new JSONObject(map);
        System.out.println("JSON Object :" +jsonObject);
        given().contentType(ContentType.JSON).body(jsonObject.toJSONString())
                .when().post("http://localhost:9191/ProductCatalog/products").then().statusCode(HttpStatus.SC_OK).log().all();

   }
}
