package petstore;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;

public class Pet {
    //documentação do swagger utilizado: https://petstore.swagger.io/
    String uri = "https://petstore.swagger.io/v2/pet";

    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    // Incluir - Create - Post
    @Test(priority = 1) //Identifica a função/método como um teste para o TestNG
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
                .statusCode(200)
                .body("name", is("Snoopy"))
                .body("status", is("available"))
                .body("category.name", is("dog"))
                .body("tags.name", contains("SemanaAPI"))
        ;
    }

    String petId = "458712";

    @Test(priority = 2)
    public void consultarPet()
    {
        String token =
        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get(uri + "/" + petId)
        .then()
                .log().all()
                .statusCode(200)
                .body("name", is("Snoopy"))
                .body("status", is("available"))
                .body("category.name", is("dog"))
                .body("tags.name", contains("SemanaAPI"))
        .extract()
                .path("status")
        ;
        System.out.println("o token eh: " + token);
    }

    @Test
    public void alterarPet() throws IOException {
        String jsonBody = lerJson("src/test/resources/db/pet2.json");

        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
        .when()
                .put(uri)
        .then()
                .log().all()
                .statusCode(200)
                .body("name", is("Snoopy"))
                .body("status", is("sold"))
        ;
    }

    @Test
    public void excluirPet()
    {
        given()
                .contentType("application/json")
                .log().all()
        .when()
                .delete(uri + "/" + petId)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("message", is(petId))
                ;
    }



}
