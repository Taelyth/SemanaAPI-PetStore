package petstore;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class Pet {
    //documentação do swagger utilizado: https://petstore.swagger.io/
    String uri = "https://petstore.swagger.io/v2/pet";

    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    // Incluir - Create - Post
    @Test //Identifica a função/método como um teste para o TestNG
    public void incluirPet() throws IOException {
        String jsonBody = lerJson("src/test/resources/db/pet1.json");

        //Gherkin
        //Dado - Quando - Então
        //Given - When - Then

        given()
                .contentType("application/json") //comum em API REST - antigas eram "text/xml"
                .log().all()
                .body(jsonBody)
        .when()
                .post(uri)
        .then()
                .log().all()
                .statusCode(200);
    }

}
