# Sistema de Cadastro — Programação Orientada a Objetos em Python

## 1. Sobre o projeto

Este projeto implementa um sistema simples de cadastro de pessoas em Python, seguindo a estrutura de classes representada no diagrama UML da atividade.

O sistema permite cadastrar três tipos de pessoas — **Aluno**, **Professor** e **Técnico Administrativo** —, listar os registros, buscar pessoas pelo nome ou matrícula e remover registros. A implementação utiliza os quatro pilares da Programação Orientada a Objetos (POO): abstração, encapsulamento, herança e polimorfismo.

> Os dados são armazenados em uma lista durante a execução do programa. Ao encerrar o sistema, os cadastros não ficam salvos em arquivo ou banco de dados.

## 2. Estrutura de arquivos

```text
sistema_cadastro_poo/
├── README.md
└── src/
    ├── __init__.py
    ├── pessoa.py
    ├── aluno.py
    ├── professor.py
    ├── tecnico_administrativo.py
    ├── sistema_de_cadastro.py
    └── main.py
```

## 3. Responsabilidade de cada arquivo

### `src/__init__.py`

Identifica a pasta `src` como um pacote Python. Isso permite executar o programa como módulo e utilizar imports relativos entre os arquivos, por exemplo: `from .pessoa import Pessoa`.

### `src/pessoa.py`

Define a classe **`Pessoa`**, que funciona como superclasse das demais.

- **Atributos:** `__nome`, `__idade` e `__altura`.
- **Construtor:** `__init__()` recebe e inicializa os dados comuns a todas as pessoas.
- **Getters e setters:** `getNome()`, `setNome()`, `getIdade()`, `setIdade()`, `getAltura()` e `setAltura()` permitem consultar e alterar os atributos encapsulados.
- **Apresentação:** `SeApresentar()` exibe os dados básicos da pessoa.

### `src/aluno.py`

Define a classe **`Aluno`**, que herda de `Pessoa`.

- **Atributo específico:** `__matricula`.
- **Construtor:** utiliza `super().__init__(nome, idade, altura)` para reaproveitar a inicialização dos atributos herdados.
- **Getters e setters:** `getMatricula()` e `setMatricula()`.
- **Polimorfismo:** sobrescreve `SeApresentar()` para apresentar os dados básicos e a matrícula do aluno.

### `src/professor.py`

Define a classe **`Professor`**, que herda de `Pessoa`.

- **Atributo específico:** `__disciplina`.
- **Construtor:** utiliza `super().__init__(nome, idade, altura)` para inicializar os atributos herdados.
- **Getters e setters:** `getDisciplina()` e `setDisciplina()`.
- **Polimorfismo:** sobrescreve `SeApresentar()` para apresentar os dados básicos e a disciplina do professor.

### `src/tecnico_administrativo.py`

Define a classe **`TecnicoAdministrativo`**, que herda de `Pessoa`.

- **Atributo específico:** `__setor`.
- **Construtor:** utiliza `super().__init__(nome, idade, altura)` para inicializar os atributos herdados.
- **Getters e setters:** `getSetor()` e `setSetor()`.
- **Polimorfismo:** sobrescreve `SeApresentar()` para apresentar os dados básicos e o setor de atuação do técnico administrativo.

### `src/sistema_de_cadastro.py`

Define a classe **`SistemaDeCadastro`**, responsável por gerenciar a coleção de pessoas.

- **Armazenamento:** mantém os objetos cadastrados em uma lista privada (`__pessoas`).
- **`adicionarPessoa(pessoa)`:** adiciona um objeto à lista.
- **`cadastrarPessoa(pessoa)`:** oferece o método de cadastro utilizado pelo menu e encaminha a operação para `adicionarPessoa()`.
- **`listarPessoas()` e `Listar()`:** percorrem a coleção e chamam `SeApresentar()` para exibir cada pessoa.
- **`buscarPessoaPorNome(nome)`:** procura uma pessoa pelo nome, sem diferenciar letras maiúsculas e minúsculas.
- **`buscarPorNome(nome)`:** realiza a busca pelo nome, apresenta o resultado encontrado ou informa que a pessoa não foi localizada.
- **`buscarPorMatricula(matricula)`:** procura a matrícula nos objetos que possuem o método `getMatricula()`, ou seja, nos alunos; apresenta o resultado quando encontra.
- **`removerPessoa(pessoa)`:** remove da lista o objeto informado e retorna `True` quando a remoção é realizada ou `False` quando ele não está cadastrado.

### `src/main.py`

É o ponto de entrada do programa. Reúne as classes e apresenta o menu interativo no terminal.

- **`lerDadosPessoais()`:** solicita nome, idade e altura, validando os campos numéricos e impedindo valores vazios ou inválidos.
- **`cadastrarPessoa(sistema)`:** pergunta o tipo de cadastro, solicita os dados específicos e cria um objeto `Aluno`, `Professor` ou `TecnicoAdministrativo`.
- **`buscarPessoa(sistema)`:** apresenta as opções de busca por nome ou matrícula.
- **`removerPessoa(sistema)`:** localiza a pessoa por nome ou matrícula e solicita sua remoção do sistema.
- **`main()`:** cria o objeto `SistemaDeCadastro` e mantém o menu em execução com um laço `while` até o usuário escolher sair.
- **`if __name__ == "__main__":`:** garante que a função principal seja chamada quando o módulo for executado diretamente.

## 4. Conceitos de POO utilizados

| Pilar | Como aparece no projeto |
|---|---|
| **Abstração** | A classe `Pessoa` representa as características comuns de uma pessoa no sistema. |
| **Encapsulamento** | Os atributos são declarados com dois underlines, como `__nome` e `__matricula`, e acessados por getters e setters. |
| **Herança** | `Aluno`, `Professor` e `TecnicoAdministrativo` herdam de `Pessoa`. |
| **Polimorfismo** | Cada subclasse sobrescreve `SeApresentar()` para exibir informações próprias do seu tipo. |

## 5. Como executar

### Pré-requisitos

- Python 3.8 ou superior;
- Terminal ou prompt de comando;
- Nenhuma biblioteca externa é necessária.

### Passo a passo

1. Abra ou extraia a pasta `sistema_cadastro_poo`.
2. Abra o terminal na pasta raiz do projeto, aquela que contém a pasta `src`.
3. Execute o comando:

```bash
python -m src.main
```

Em alguns ambientes, pode ser necessário utilizar:

```bash
python3 -m src.main
```

**Importante:** execute como módulo a partir da pasta raiz (`python -m src.main`). Os imports dos arquivos foram escritos como imports relativos ao pacote `src`.

## 6. Opções do menu

Ao iniciar, o programa apresenta um menu semelhante a este:

```text
========== SISTEMA DE CADASTRO ==========
1 - Cadastrar pessoa
2 - Listar pessoas
3 - Buscar pessoa
4 - Remover pessoa
5 - Sair
=========================================
```

- **Opção 1 — Cadastrar pessoa:** permite escolher entre aluno, professor e técnico administrativo e informar os respectivos dados.
- **Opção 2 — Listar pessoas:** exibe todos os objetos cadastrados.
- **Opção 3 — Buscar pessoa:** permite pesquisar pelo nome ou pela matrícula.
- **Opção 4 — Remover pessoa:** localiza uma pessoa e remove seu registro da lista.
- **Opção 5 — Sair:** encerra a execução do programa.

## 7. Exemplo de utilização

Um fluxo básico de teste é:

1. Escolher **1 — Cadastrar pessoa** e cadastrar um aluno, informando nome, idade, altura e matrícula.
2. Repetir o cadastro para um professor e um técnico administrativo.
3. Escolher **2 — Listar pessoas** e verificar se cada objeto apresenta seus dados específicos.
4. Escolher **3 — Buscar pessoa** e pesquisar pelo nome ou pela matrícula do aluno.
5. Escolher **4 — Remover pessoa** para excluir um registro.
6. Escolher **5 — Sair** para encerrar o programa.

Ao listar objetos de classes diferentes, o sistema chama o mesmo método `SeApresentar()`. Como cada subclasse possui sua própria implementação, as informações exibidas variam conforme o tipo de objeto — esse é o polimorfismo aplicado na prática.

---

**Projeto acadêmico:** atividade de Programação Orientada a Objetos — implementação de uma arquitetura UML em Python.
