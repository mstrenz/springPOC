package poc.integ.Tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import poc.integ.Utilities.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

@DisplayName("The default endpoint")
public class DefaultEndpoint extends TestBase {

    @Test
    @Tag("smoke")
    @DisplayName("returns 200 on valid GET request")
    public void verifySuccess() {
        given().
                spec(requestSpec).
                when().
                get("/").
                then().
                statusCode(200);
    }

    @Test
    @DisplayName("returns the correct response")
    public void verifyShape(){
        given().
                spec(requestSpec).
                when().
                get("/").
                then().
                body(equalTo("Hello Worlds"));
    }

    @Test
    @Tag("smoke")
    @DisplayName("returns in under 1000 milliseconds")
    public void verifyTime(){
        given().
                spec(requestSpec).
                when().
                get("/").
                then().
                time(lessThan(1000L));
    }
}
