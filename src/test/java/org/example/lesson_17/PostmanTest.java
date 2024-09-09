package org.example.lesson_17;

import io.restassured.http.ContentType;
import org.example.lesson_17.Request.ArgsRequest;
import org.example.lesson_17.Request.DataRequest;
import org.example.lesson_17.Specifications.Specification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PostmanTest {

    @BeforeAll
    public static void setUp() {
        Specification.install(Specification.requestSpecification("https://postman-echo.com", 443), Specification.responseSpecification());
    }

    @Test
    @DisplayName("Тестирование get Woops запроса https://postman-echo.com")
    public void testGetReqWoops() {
        ArgsRequest argsRequest = new ArgsRequest("bar1", "bar2");
        given()
              .contentType(ContentType.URLENC)
              .pathParam("foo1", argsRequest.getFoo1())
              .pathParam("foo2", argsRequest.getFoo2())
        .when()
              .get("/get?foo1={foo1}&foo2={foo2}")
        .then()
              .statusCode(200)
              .and()
              .body("args.foo1", Matchers.equalTo("bar1"))
              .and()
              .body("args.foo2", Matchers.equalTo("bar2"))
              .and()
              .body("headers.x-forwarded-proto", Matchers.equalTo("https"))
              .and()
              .body("headers.host", Matchers.equalTo("postman-echo.com"))
              .and()
              .body("headers.accept", Matchers.equalTo("*/*"))
              .and()
              .body("headers.accept-encoding", Matchers.equalTo("gzip,deflate"))
              .and()
              .body("url", Matchers.equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    @DisplayName("Тестирование RAW post запроса https://postman-echo.com")
    public void testPostRequestRaw() {
        DataRequest dataRequest = new DataRequest("This is expected to be sent back as part of response body.");
        given()
                .contentType(ContentType.TEXT)
        .when()
                .body(dataRequest.getData())
                .post("/post")
        .then()
                .statusCode(200)
                .and()
                .body("data", Matchers.equalTo("This is expected to be sent back as part of response body."))
                .and()
                .body("headers.host", Matchers.equalTo("postman-echo.com"))
                .and()
                .body("headers.content-length", Matchers.equalTo("58"))
                .and()
                .body("headers.accept", Matchers.equalTo("*/*"))
                .and()
                .body("json", Matchers.equalTo(null))
                .and()
                .body("url", Matchers.equalTo("https://postman-echo.com/post"));
    }

    @Test
    @DisplayName("Тестирование FORM post запроса https://postman-echo.com")
    public void testPostRequestForm() {
        ArgsRequest argsRequest = new ArgsRequest("bar1", "bar2");
        given()
                .contentType(ContentType.MULTIPART)
                .multiPart("foo1", argsRequest.getFoo1())
                .multiPart("foo2", argsRequest.getFoo2())
        .when()
                .post("/post")
        .then()
                .statusCode(200)
                .and()
                .body("form.foo1", Matchers.equalTo("bar1"))
                .and()
                .body("form.foo2", Matchers.equalTo("bar2"))
                .body("headers.host", Matchers.equalTo("postman-echo.com"))
                .and()
                .body("url", Matchers.equalTo("https://postman-echo.com/post"));
    }

    @Test
    @DisplayName("Тестирование put запроса https://postman-echo.com")
    public void testPutRequest() {
        DataRequest dataRequest = new DataRequest("This is expected to be sent back as part of response body.");
        given()
                .contentType(ContentType.TEXT)
        .when()
                .body(dataRequest.getData())
                .put("/put")
        .then()
                .statusCode(200)
                .and()
                .body("data", Matchers.equalTo("This is expected to be sent back as part of response body."))
                .and()
                .body("headers.host", Matchers.equalTo("postman-echo.com"))
                .and()
                .body("headers.connection", Matchers.equalTo("close"))
                .and()
                .body("headers.accept", Matchers.equalTo("*/*"))
                .and()
                .body("headers.content-type", Matchers.equalTo("text/plain; charset=ISO-8859-1"))
                .and()
                .body("headers.accept-encoding", Matchers.equalTo("gzip,deflate"))
                .and()
                .body("json", Matchers.equalTo(null))
                .and()
                .body("url", Matchers.equalTo("https://postman-echo.com/put"));
    }

    @Test
    @DisplayName("Тестирование patch запроса https://postman-echo.com")
    public void testPatchRequest() {
        DataRequest dataRequest = new DataRequest("This is expected to be sent back as part of response body.");
        given()
                .contentType(ContentType.TEXT)
        .when()
                .body(dataRequest.getData())
                .patch("/patch")
        .then()
                .statusCode(200)
                .and()
                .body("data", Matchers.equalTo("This is expected to be sent back as part of response body."))
                .and()
                .body("headers.host", Matchers.equalTo("postman-echo.com"))
                .and()
                .body("headers.connection", Matchers.equalTo("close"))
                .and()
                .body("headers.x-forwarded-proto", Matchers.equalTo("https"))
                .and()
                .body("headers.content-type", Matchers.equalTo("text/plain; charset=ISO-8859-1"))
                .and()
                .body("headers.accept", Matchers.equalTo("*/*"))
                .and()
                .body("json", Matchers.equalTo(null))
                .and()
                .body("url", Matchers.equalTo("https://postman-echo.com/patch"));
    }

    @Test
    @DisplayName("Тестирование delete запроса https://postman-echo.com")
    public void testDeleteRequest() {
        DataRequest dataRequest = new DataRequest("This is expected to be sent back as part of response body.");
        given()
                .contentType(ContentType.TEXT)
        .when()
                .body(dataRequest.getData())
                .delete("/delete")
        .then()
                .statusCode(200)
                .body("data", Matchers.equalTo("This is expected to be sent back as part of response body."))
                .and()
                .body("headers.host", Matchers.equalTo("postman-echo.com"))
                .and()
                .body("headers.connection", Matchers.equalTo("close"))
                .and()
                .body("headers.content-length", Matchers.equalTo("58"))
                .and()
                .body("headers.x-forwarded-proto", Matchers.equalTo("https"))
                .and()
                .body("headers.x-forwarded-port", Matchers.equalTo("443"))
                .and()
                .body("headers.accept", Matchers.equalTo("*/*"))
                .and()
                .body("json", Matchers.equalTo(null))
                .and()
                .body("url", Matchers.equalTo("https://postman-echo.com/delete"));
    }
}
