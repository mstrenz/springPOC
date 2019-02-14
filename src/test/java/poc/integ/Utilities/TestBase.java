package poc.integ.Utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    public static RequestSpecBuilder builder;
    public static RequestSpecification requestSpec;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080";

        builder = new RequestSpecBuilder();
        requestSpec = builder.build();

        //Setting default headers for use in child classes
        requestSpec.accept("application/json");
        requestSpec.contentType("application/json");
    }
}
