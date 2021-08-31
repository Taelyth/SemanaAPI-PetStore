package datadriven;

//import org.testng.annotations.BeforeMethod;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import utils.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class UserDD {

    String uri = "https://petstore.swagger.io/v2/user";
    //Data data; //objeto que representa a classe utils.Data

    @DataProvider //provedor de dados para os testes
    public Iterator<Object[]> provider() throws IOException {
        //List<String[]> testCases = new ArrayList<>();
        List<Object[]> testCases = new ArrayList<>();
        String[] testCase;
        String linha;

        //testCases = data.lerCsv("src/test/resources/db/users.csv"); //será usado para o opencsv (próxima aula)

        //Abaixo é um exemplo usando o java e não o opencsv, será alterado na próxima aula
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/test/resources/db/users.csv"));

        while((linha = bufferedReader.readLine()) != null)
        {
            testCase = linha.split(",");
            testCases.add(testCase);
        }

        return testCases.iterator();
    }

    /*
    @BeforeMethod
    public void setup()
    {
        data = new Data();
    }
    */

    @Test(dataProvider = "provider")
    public void incluirUsuario(String id,
                               String username,
                               String firstName,
                               String lastName,
                               String email,
                               String password,
                               String phone,
                               String userStatus)
    {
        String jsonBody = new JSONObject()
                .put("id", id)
                .put("username", username)
                .put("firstName", firstName)
                .put("lastName", lastName)
                .put("email", email)
                .put("password", password)
                .put("phone", phone)
                .put("userStatus", userStatus)
                .toString();

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
                        .path("message");

        System.out.println("O userID eh: " + userID);
    }

    /*
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
                        .path("message");

        System.out.println("O userID eh: " + userID);
    }
    */
}