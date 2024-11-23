package com.maxwell.catalog_service.web.controllers;

import com.maxwell.catalog_service.AbstractIT;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@Sql(scripts = "/test-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class ProductControllerTest extends AbstractIT {

    @Test
    void shouldReturnProducts() {
        given().contentType(ContentType.JSON)
                .when()
                .get("/api/v1/products")
                .then()
                .statusCode(200)
                .body("totalElements", is(15));
    }
}