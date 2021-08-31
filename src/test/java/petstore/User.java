package petstore;

import org.testng.annotations.Test;
import utils.Data;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class User {

    String uri = "https://petstore.swagger.io/v2/user";
    Data data = new Data();


    @Test
    public void incluirUsuario() throws IOException {
        String jsonBody = data.lerJson("src/test/resources/db/user1.json");

        String userID =
        given()
                .contentType("application/json") //comum em API REST — antigas eram "text/xml"
                .log().all()
                .body(jsonBody)
        .when()
                .post(uri)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                //.body("message", is(pet.petId))
        .extract()
                .path("message")
        ;

        System.out.println("O userID eh: " + userID);

    }

}
