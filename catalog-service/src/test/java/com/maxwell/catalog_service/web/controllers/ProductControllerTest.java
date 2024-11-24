package com.maxwell.catalog_service.web.controllers;

import com.maxwell.catalog_service.AbstractIT;
import com.maxwell.catalog_service.domain.Product;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;

@Sql(scripts = "/test-data.sql")
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

    @Test
    void shouldGetProductByCode() {
        Product product = given().contentType(ContentType.JSON)
                .when()
                .get("/api/v1/products/P100")
                .then()
                .statusCode(200)
                .assertThat()
                .extract().body().as(Product.class);

        assertThat(product.getCode()).isEqualTo("P100");
    }

    @Test
    void shouldReturnNotFoundIfProductNotFound() {
        String productCode = "invalid_product_code";
        given().contentType(ContentType.JSON)
                .when()
                .get("/api/v1/products/{code}", productCode)
                .then()
                .statusCode(404);
    }
}