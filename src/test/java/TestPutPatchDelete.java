import io.restassured.http.ContentType;
import netscape.javascript.JSObject;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class TestPutPatchDelete {
    @Test
    public void test_put_1(){
         baseURI="http://localhost:9191";
         Map<String,Object> map =new HashMap<>();
         map.put("name","Minitab");
         map.put("quantity",Integer.valueOf(1));
         System.out.println("Map:" +map);
        JSONObject jsonObject = new JSONObject(map);
        System.out.println("JSON Object :" + jsonObject);
        given().contentType(ContentType.JSON).body(jsonObject.toJSONString())
                .when().put("ProductCatalog/product/update/52")
                .then().statusCode(HttpStatus.SC_OK).log().all();
    }
    @Test
    public void test_patch_1(){
        baseURI="http://localhost:9191";
        Map<String,Object> map =new HashMap<>();
        map.put("name","Minitab");
        System.out.println("Map:" +map);
        JSONObject jsonObject = new JSONObject(map);
        System.out.println("JSON Object :" + jsonObject);
        given().contentType(ContentType.JSON).body(jsonObject.toJSONString())
                .when().patch("ProductCatalog/product/update/52")
                .then().statusCode(HttpStatus.SC_OK).log().all();
    }
    @Test
    public void test_delete_1(){
        baseURI="http://localhost:9191";
        given().when().delete("/ProductCatalog/delete/52")
                .then().statusCode(HttpStatus.SC_OK).log().all();
    }

}
