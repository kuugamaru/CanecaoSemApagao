from .aluno import Aluno
from .professor import Professor
from .tecnico_administrativo import TecnicoAdministrativo
from .sistema_de_cadastro import SistemaDeCadastro


def lerDadosPessoais():
    nome = input("Nome: ").strip()

    while not nome:
        print("O nome não pode ficar vazio.")
        nome = input("Nome: ").strip()

    while True:
        try:
            idade = int(input("Idade: "))

            if idade <= 0:
                print("Digite uma idade válida.")
                continue

            break
        except ValueError:
            print("Digite uma idade numérica.")

    while True:
        try:
            altura = float(input("Altura (ex.: 1.75): ").replace(",", "."))

            if altura <= 0:
                print("Digite uma altura válida.")
                continue

            break
        except ValueError:
            print("Digite uma altura válida.")

    return nome, idade, altura


def cadastrarPessoa(sistema):

    print("\n=== TIPO DE CADASTRO ===")
    print("1 - Aluno")
    print("2 - Professor")
    print("3 - Técnico Administrativo")

    opcao = input("Escolha: ")

    if opcao not in ["1", "2", "3"]:
        print("Opção inválida!")
        return

    nome, idade, altura = lerDadosPessoais()

    if opcao == "1":
        matricula = input("Matrícula: ").strip()

        pessoa = Aluno(nome, idade, altura, matricula)

    elif opcao == "2":
        disciplina = input("Disciplina: ").strip()

        pessoa = Professor(nome, idade, altura, disciplina)

    else:
        setor = input("Setor: ").strip()

        pessoa = TecnicoAdministrativo(nome, idade, altura, setor)

    sistema.cadastrarPessoa(pessoa)


def buscarPessoa(sistema):

    print("\n=== BUSCAR PESSOA ===")
    print("1 - Buscar por nome")
    print("2 - Buscar por matrícula")

    opcao = input("Escolha: ")

    if opcao == "1":
        nome = input("Digite o nome: ").strip()
        sistema.buscarPorNome(nome)

    elif opcao == "2":
        matricula = input("Digite a matrícula: ").strip()
        sistema.buscarPorMatricula(matricula)

    else:
        print("Opção inválida!")


def removerPessoa(sistema):

    print("\n=== REMOVER PESSOA ===")
    print("1 - Remover por nome")
    print("2 - Remover por matrícula")

    opcao = input("Escolha: ")

    if opcao == "1":
        nome = input("Digite o nome: ").strip()
        pessoa = sistema.buscarPessoaPorNome(nome)

    elif opcao == "2":
        matricula = input("Digite a matrícula: ").strip()
        pessoa = sistema.buscarPorMatricula(matricula)

    else:
        print("Opção inválida!")
        return

    if pessoa:
        sistema.removerPessoa(pessoa)
    elif opcao == "1":
        print("Pessoa não encontrada.")


def main():

    sistema = SistemaDeCadastro()

    while True:

        print("\n========== SISTEMA DE CADASTRO ==========")
        print("1 - Cadastrar pessoa")
        print("2 - Listar pessoas")
        print("3 - Buscar pessoa")
        print("4 - Remover pessoa")
        print("5 - Sair")
        print("=========================================")

        opcao = input("Selecione uma opção: ")

        if opcao == "1":
            cadastrarPessoa(sistema)

        elif opcao == "2":
            sistema.listarPessoas()

        elif opcao == "3":
            buscarPessoa(sistema)

        elif opcao == "4":
            removerPessoa(sistema)

        elif opcao == "5":
            print("Encerrando o sistema...")
            break

        else:
            print("Opção inválida! Tente novamente.")


if __name__ == "__main__":
    main()
  
