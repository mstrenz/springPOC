package poc.integ.Tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import poc.integ.Utilities.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

@DisplayName("The testing endpoint")
public class TestingEndpoint extends TestBase {

    @Test
    @Tag("smoke")
    @DisplayName("returns 200 on valid GET request")
    public void verifySuccess() {
        given().
                spec(requestSpec).
                when().
                get("/testing").
                then().
                statusCode(200);
    }

    @Test
    @DisplayName("returns the correct response")
    public void verifyShape(){
        given().
                spec(requestSpec).
                when().
                get("/testing").
                then().
                body(equalTo("Hello Testing"));
    }

    @Test
    @Tag("smoke")
    @DisplayName("returns in under 1000 milliseconds")
    public void verifyTime(){
        given().
                spec(requestSpec).
                when().
                get("/testing").
                then().
                time(lessThan(1000L));
    }
}
