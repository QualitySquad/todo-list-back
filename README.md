## Task Remember - Back End

Documentação do produto Task Remember desenvolvido para o trabalho da CI&T.

## Seções

- [Endpoint API](#tarefas)
- [Políticas de uso](#políticas-de-uso)


-----

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
