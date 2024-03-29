# Semana da API - PetStore
Projeto criado para acompanhar as aulas da Semana de API feitas no [Canal de Youtube da Iterasys][Iterasys-Youtube] em **Java** utilizando **TestNG e Rest Assured**.

Neste projeto é realizado o Teste de API com Leitura em CSV e Json.


---

### Pré-Requisitos
- Nesse projeto utilizamos o **Gradle** com as seguintes bibliotecas:

```java
testImplementation group: 'org.testng', name: 'testng', version: '7.4.0'
testImplementation group: 'io.rest-assured', name: 'rest-assured', version: '4.4.0'
implementation group: 'com.opencsv', name: 'opencsv', version: '5.5.2'
implementation group: 'org.json', name: 'json', version: '20210307'
```

- A documentação usada para as aulas: **PetStore** pode ser encontrada [aqui][Petstore].

---

### Glossário

`UserDD.java` Classe usada para treinamento da leitura de um CSV `users.csv` e testes em API usando **Rest-Assured**

`petstore` Pacote onde foi codificado os testes da API Petstore.

`Data.java` Classe de exemplo do código de leitura em CSV e Json.

`Log.java` (Incompleto) Classe criada para escrita em CSV, escrevendo apenas o cabeçalho por enquanto.

---

### Créditos
[<img src="assets\Iterasys-Logo.png" width="20%"/>][Iterasys]


<!-- links -->
[Iterasys]: https://iterasys.com.br/
[Petstore]: https://petstore.swagger.io/
[Iterasys-Youtube]: https://www.youtube.com/c/IterasysBrasil

<!-- imagens -->
[Iterasys-Logo]: assets/Iterasys-Logo.png (Iterasys-logo)