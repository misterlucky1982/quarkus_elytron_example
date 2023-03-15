package nby.misterlucky.quarkus.web;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testUserEndpoint() {
        given().header("Authorization", "Basic aGVyYmVydDoyMjIy")
                .when().get("/common/user")
                .then()
                .statusCode(200)
                .body(is("HELLO, Johnny HERBERT!!!"));
    }

    @Test
    public void testOpenEndpoint() {
        given()
                .when().get("/common/open")
                .then()
                .statusCode(200)
                .body(is("HELLO!!!"));
    }

    @Test
    public void testCommonEndpointAsUnauthorisedUser() {
        given()
                .when().get("/common/all")
                .then()
                .statusCode(200)
                .body(is("Hi! You are currently unauthorised."));
    }

    @Test
    public void testCommonEndpointAsAuthorisedUser() {
        given().header("Authorization", "Basic aGVyYmVydDoyMjIy")
                .when().get("/common/all")
                .then()
                .statusCode(200)
                .body(is("Hi, Johnny HERBERT!"));
    }

    @Test
    public void testCommonEndpointWrongCredentials() {
        given().header("Authorization", "Basic bGVyYmVydDoyMjIy")
                .when().get("/common/all")
                .then()
                .statusCode(401);
    }

    @Test
    public void testAdminEndpointForUser() {
        given().header("Authorization", "Basic aGVyYmVydDoyMjIy")
                .when().get("/common/admin")
                .then()
                .statusCode(403);
    }

}