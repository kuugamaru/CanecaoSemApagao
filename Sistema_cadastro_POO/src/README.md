Classe Pessoa — Sistema de Cadastro

1. Descrição

O arquivo "pessoa.py" implementa a classe "Pessoa", responsável por representar uma pessoa no Sistema de Cadastro.

Essa classe funciona como superclasse para as demais classes do projeto, permitindo o reaproveitamento de atributos e métodos por meio da herança.

2. Atributos

Os atributos são privados, utilizando dois underlines ("__") para aplicar o encapsulamento.

Atributo| Tipo| Descrição
"__nome"| String| Nome da pessoa.
"__idade"| int| Idade da pessoa.
"__altura"| float| Altura da pessoa.

3. Métodos

Método| Retorno| Descrição
"__init__()"| None| Inicializa os atributos da pessoa.
"getNome()"| String| Retorna o nome.
"setNome()"| None| Modifica o nome.
"getIdade()"| int| Retorna a idade.
"setIdade()"| None| Modifica a idade.
"getAltura()"| float| Retorna a altura.
"setAltura()"| None| Modifica a altura.
"SeApresentar()"| None| Exibe as informações da pessoa.

4. Conceitos de POO aplicados

- Abstração: representação das características essenciais de uma pessoa.
- Encapsulamento: utilização de atributos privados e métodos públicos de acesso e modificação.
- Herança: a classe serve como base para as subclasses "Aluno", "Professor" e "TecnicoAdministrativo".
- Polimorfismo: o método "SeApresentar()" poderá ser sobrescrito pelas subclasses para apresentar informações específicas.

5. Exemplo de utilização

from pessoa import Pessoa

pessoa = Pessoa("Carlos", 17, 1.70)

pessoa.SeApresentar()

Saída esperada:

Nome: Carlos
Idade: 17 anos
Altura: 1.70 m

6. Observações

A classe "Pessoa" constitui a estrutura fundamental do Sistema de Cadastro. Suas subclasses poderão reutilizar o construtor por meio de "super().__init__()", evitando duplicação de código.
