
class SistemaDeCadastro:

    def __init__(self):
        self.__pessoas = []

    def adicionarPessoa(self, pessoa) -> None:
        self.__pessoas.append(pessoa)
        print("Pessoa cadastrada com sucesso!")

    def cadastrarPessoa(self, pessoa) -> None:
        self.adicionarPessoa(pessoa)

    def listarPessoas(self) -> None:
        if not self.__pessoas:
            print("Nenhuma pessoa cadastrada.")
            return

        for pessoa in self.__pessoas:
            print("--------------------")
            pessoa.SeApresentar()

    def Listar(self) -> None:
        self.listarPessoas()

    def buscarPessoaPorNome(self, nome: str):
        for pessoa in self.__pessoas:
            if pessoa.getNome().lower() == nome.lower():
                return pessoa

        return None

    def buscarPorNome(self, nome: str):
        pessoa = self.buscarPessoaPorNome(nome)

        if pessoa:
            pessoa.SeApresentar()
        else:
            print("Pessoa não encontrada.")

        return pessoa

    def buscarPorMatricula(self, matricula: str):
        for pessoa in self.__pessoas:
            if hasattr(pessoa, "getMatricula"):
                if pessoa.getMatricula() == matricula:
                    pessoa.SeApresentar()
                    return pessoa

        print("Matrícula não encontrada.")
        return None

    def removerPessoa(self, pessoa) -> bool:
        if pessoa in self.__pessoas:
            self.__pessoas.remove(pessoa)
            print("Pessoa removida com sucesso!")
            return True

        print("Pessoa não encontrada.")
        return False
