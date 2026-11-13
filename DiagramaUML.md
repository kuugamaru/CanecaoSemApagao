# Diagrama UML - CanecaoSemApagao

````mermaid
classDiagram

    class Usuario {
        -int id
        -String nome
        -String email
        +getId()
        +getNome()
        +getEmail()
    }

    class Ocorrencia {
        -int id
        -String descricao
        -String categoria
        -String endereco
        -String status
        +getId()
        +getDescricao()
        +getCategoria()
        +getEndereco()
        +getStatus()
    }

    class Gestor {
        -int id
        -String nome
        -String setorResponsavel
        +analisarOcorrencia()
        +atualizarStatus()
    }

    class OcorrenciaDAO {
        +cadastrar()
        +consultar()
        +atualizar()
    }

    Usuario "1" --> "0..*" Ocorrencia : registra
    Gestor "1" --> "0..*" Ocorrencia : gerencia
    OcorrenciaDAO ..> Ocorrencia : acessa dados


**Importante:** mantenha as três crases antes de `mermaid` e depois do diagrama. Elas são necessárias para o GitHub reconhecer o desenho.
