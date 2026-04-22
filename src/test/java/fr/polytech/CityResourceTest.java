package fr.polytech;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;

@QuarkusTest
public class CityResourceTest {

    @Test
    public void testHealthCheck() {
        given()
          .when().get("/_health")
          .then()
             .statusCode(204);
    }

    @Test
    public void testGetCities() {
        given()
          .when().get("/city")
          .then()
             .statusCode(200)
             .contentType(ContentType.JSON);
    }

    @Test
    public void testPostCity() {
        City city = new City();
        city.name = "Test City";
        city.departmentCode = "99";
        city.lat = 1.0;
        city.lon = 2.0;

        given()
          .contentType(ContentType.JSON)
          .body(city)
          .when().post("/city")
          .then()
             .statusCode(201)
             .body("name", is("Test City"))
             .body("id", greaterThan(0));
    }
}
