
class SistemaDeCadastro:

    def __init__(self):
        self.__pessoas = []

    def cadastrarPessoa(self, pessoa) -> None:
        self.__pessoas.append(pessoa)
        print("Pessoa cadastrada com sucesso!")

    def Listar(self) -> None:
        if not self.__pessoas:
            print("Nenhuma pessoa cadastrada.")
            return

        for pessoa in self.__pessoas:
            print("--------------------")
            pessoa.SeApresentar()

    def buscarPorNome(self, nome: str):
        encontrados = []

        for pessoa in self.__pessoas:
            if pessoa.getNome().lower() == nome.lower():
                encontrados.append(pessoa)

        if encontrados:
            for pessoa in encontrados:
                print("--------------------")
                pessoa.SeApresentar()
            return encontrados

        print("Pessoa não encontrada.")
        return []

    def buscarPorMatricula(self, matricula: str):
        encontrados = []

        for pessoa in self.__pessoas:
            if hasattr(pessoa, "getMatricula"):
                if pessoa.getMatricula() == matricula:
                    encontrados.append(pessoa)

        if encontrados:
            for pessoa in encontrados:
                print("--------------------")
                pessoa.SeApresentar()
            return encontrados

        print("Matrícula não encontrada.")
        return []
