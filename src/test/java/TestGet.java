import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class TestGet {

  @Test
  void test_get_01(){
      Response  response = RestAssured.get("http://localhost:9191/ProductCatalog/products");
      System.out.println(response.getBody().asString());
      System.out.println(response.getStatusCode());
      System.out.println(response.getHeaders());

       int actualStatusCode = response.getStatusCode();
       assertEquals(HttpStatus.SC_OK,actualStatusCode);
  }

  @Test
   void test_get_02(){
      given().get("http://localhost:9191/ProductCatalog/products").then().statusCode(HttpStatus.SC_OK);
  }
}
