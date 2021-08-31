package utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Data {

    //Função para ler um arquivo JSON
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    //Função para ler um arquivo CSV
    public List<String[]> lerCsv(String caminhoCsv) throws IOException, CsvException {
        Reader reader = Files.newBufferedReader(Paths.get(caminhoCsv)); // Lê um texto
        CSVReader csvReader = new CSVReaderBuilder(reader)
                .withSkipLines(1)
                .build(); // Abre como um csv

        List<String[]> users;
        users = csvReader.readAll(); // Lê todos os dados do CSV

        return users;
    }

}
