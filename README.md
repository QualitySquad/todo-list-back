## Task Remember - Back End

Documentação do produto Task Remember desenvolvido para o trabalho da CI&T.

## Seções
  
- [Objetivo](#objetivo)  
- [Instalação e pré-requisito](#instalação-e-pré-requisitos)  
- [Execução](#execução) 
- [Endpoint API](#endpoint-de-tarefas)
- [Tecnologias](#tecnologias-utilizadas-no-projeto)
- [Equipe](#equipe)

-----
## **Objetivo**

O projeto tem como objetivo montar um produto de Todo list e para isso dividimos o ambiente em dois repositórios, um para o back-end e outro para o front-end. A aplicação terá opções de criação, edição e exclusão de tarefas.

## **Instalação e pré requisitos**

💻 Requisitos:
* IDE(Integrated Development Environment): [Spring Tools](https://spring.io/tools), ou [IntelliJ IDEA](https://www.jetbrains.com/pt-br/idea/download/);
* Banco de Dados: [MySQL](https://dev.mysql.com/downloads/);
* [JDK(Java Development Kit)](https://www.oracle.com/java/technologies/downloads/);   
* [Git](https://git-scm.com/downloads).
* Conta no [github](https://github.com/signup?ref_cta=Sign+up&ref_loc=header+logged+out&ref_page=%2F&source=header-home)

Com todos os requisitos preenchidos, vamos para a criação do ambiente local, onde ficarão os arquivos do projeto.

### Execução:

1. Clique no botão **fork**, localizado no canto superior direito. Fork nada mais é do que uma cópia atual do repositório;
2. Depois de realizar o fork, uma cópia do projeto ficará disponível em seus repositorios. Copie a URL do repositório e guarde-a pois precisaremos dela mais tarde;
3. Inicie o terminal do gitbash ou um terminal de sua preferência;
  - Navegue até a pasta que você deseja que os arquivos do projeto sejam armazenados.
4. Comandos:
 - Crie um novo repositório git, com o seguinte comando: 
```
git init
```
Usaremos esse repositório para receber um repositório remoto existente.

  - Defina e relacione um repositório remoto, digitando o seguinte comando: 
```
git remote add origin https://github.com/QualitySquad/todo-list-back.git
```
E para finalizar baixe o conteúdo disponível na url que você informou no passo anterior, com o comando:
```
git pull origin master
```
Pronto! A partir deste momento todos os arquivos estarão na pasta que você definiu anteriormente.

## Endpoint de tarefas

#### Busca por todas tarefas

* **URL**

  `/task`

* **Método**

  `GET`

* **Retorno**
  
  **Status Code:** 200
  
    ```json
    [
      {
        "id": 1,
        "task": "Aprender Java",
        "finalizado": true
      },
      {
        "id": 2,
        "task": "Apresentar trabalho",
        "finalizado": false
      }
    ]
    ``` 
    
-----

#### Busca por tarefa especifica

* **URL**

  `/task/{id}`

* **Método**

  `GET`

  - **Parâmetros via URL**

  | Atributo   | Tipo do dado   | Descrição             | Obrigatório | Valor padrão | Exemplo |
  | -----------| -------------- | ----------------------| ----------- | ------------ | ------- |
  | id         | inteiro        | código da tarefa      | sim         | -            | 1       |
  
* **Retorno**
  
  **Status Code:** 200
  
    ```json
    {
        "id": 1,
        "task": "Aprender Java",
        "finalizado": true
    }
    ``` 
    
-----

#### Adicionar nova tarefa

* **URL**

  `/task`

* **Método**

  `POST`

- **Parâmetros via body**

  | Atributo                | Tipo do dado       | Descrição                                    | Obrigatório | Valor padrão |      Exemplo      |
  | ----------------------- | ------------------ | -------------------------------------------- | ----------- | ------------ | ----------------- |
  | task                    | Texto              | Descrição da tarefa a ser feita              | sim         | -            | "Entrar pra CI&T" |

* **Exemplo de envio**

    ```json
    [
        "task": "Entrar pra CI&T"
    ]
    ```

* **Retorno**
  
  **Status Code:** 201
  
    ```json
    {
        "id": 3,
        "task": "Entrar pra CI&T",
        "finalizado": false
    }
    ``` 
    
-----

#### Altera tarefa já existente

* **URL**

  `/task/{id}`

* **Método**

  `PUT`
  
  - **Parâmetros via URL**

  | Atributo   | Tipo do dado   | Descrição             | Obrigatório | Valor padrão | Exemplo |
  | -----------| -------------- | ----------------------| ----------- | ------------ | ------- |
  | id         | inteiro        | código da tarefa      | sim         | -            | 3       |
  
  - **Parâmetros via body**

  | Atributo                | Tipo do dado       | Descrição                                    | Obrigatório | Valor padrão |      Exemplo      |
  | ----------------------- | ------------------ | -------------------------------------------- | ----------- | ------------ | ----------------- |
  | task                    | Texto              | Descrição da tarefa a ser feita              | sim         | -            | "Entrar pra CI&T" |
  | finalizado              | verdadeiro/falso   | Controle de finalização da tarefa            | sim         | -            |       true        |

* **Exemplo de envio**

    ```json
    [
        "task": "Entrar pra CI&T",
        "finalizado": true
    ]
    ```

* **Retorno**
  
  **Status Code:** 204
  
    ```json
    [
        "id": 3,
        "task": "Entrar pra CI&T",
        "finalizado": true
    ]
    ``` 
    
-----

#### Deletar uma tarefa existente

* **URL**

  `/task/{id}`

* **Método**

  `DELETE`

- **Parâmetros via URL**

  | Atributo   | Tipo do dado   | Descrição             | Obrigatório | Valor padrão | Exemplo |
  | -----------| -------------- | ----------------------| ----------- | ------------ | ------- |
  | id         | inteiro        | código da tarefa      | sim         | -            | 1       |

* **Retorno Status Code:** 204

## Tecnologias utilizadas no projeto: 
Para atender aos requisitos disponibilizados na documentação, realizamos a combinação de ferramentas e tecnologias que em seu resultado final concederam economia de tempo no desenvolvimento e confiabilidade na entrega final.

### [Spring Boot](https://spring.io/projects/spring-boot):
Spring Boot é um framework Java open source que tem como objetivo facilitar esse processo em aplicações Java. Consequentemente, ele traz mais agilidade para o processo de desenvolvimento, uma vez que devs conseguem reduzir o tempo gasto com as configurações iniciais. O framework foi escolhido para o projeto pois o nivel de segurança é muito bom, além de ser um framework que tem um custo beneficio bem alto, então muitas empresas posssuem essa tecnologia em seus softwares, além de atender a proposta do trabalho de contruir uma API.

### [MySQL](https://cucumber.io/docs/gherkin/reference/): 
MySQL é um Banco de Dados relacional (RDBMS – Relational Database Management Systems) com um modelo de cliente-servidor. RDBMS é um software de código aberto ou serviço usado na criação e gerenciamento de bancos de dados baseados no modelo relacional. [Entenda mais sobre o Gherkin aqui](https://blog.onedaytesting.com.br/bdd-introducao/). A escolha por esse banco foi feita pois o mesmo é gratuito, funciona muito bem com o Spring boot e por ser uma solução de banco relacional, que é a realidade da maioria das empresas hoje em dia. 


## Equipe: 

<table>
  <tr>
    <td align="center"><a href="https://github.com/matheusaugusto61"><img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/89614624?v=4" width="300px;" alt=""/><br /><sub><b>Matheus Augusto</b></sub></a><br />Backend Developer🚀<br /><a href="https://www.linkedin.com/in/matheus-augusto-2019/"><sub>Linkedin</sub></a></td>
    <td align="center"><a href="https://github.com/israelgms"><img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/71859464?v=4" width="300px;" alt=""/><br /><sub><b>Israel Gomes</b></sub></a><br />Frontend Developer🚀<br /><a href="https://www.linkedin.com/in/israel-gomes-04407718b/"><sub>Linkedin</sub></a></td>
  </tr>
</table>

