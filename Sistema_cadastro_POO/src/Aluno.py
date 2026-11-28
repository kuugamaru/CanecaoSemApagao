from .pessoa import Pessoa


class Aluno(Pessoa):

    def __init__(self, nome: str, idade: int, altura: float, matricula: str):
        super().__init__(nome, idade, altura)
        self.__matricula = matricula

    def getMatricula(self) -> str:
        return self.__matricula

    def setMatricula(self, matricula: str) -> None:
        self.__matricula = matricula

    def SeApresentar(self) -> None:
        super().SeApresentar()
        print(f"Matrícula: {self.__matricula}")
        print("Tipo: Aluno")
