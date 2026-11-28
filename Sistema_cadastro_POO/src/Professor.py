
from .pessoa import Pessoa


class Professor(Pessoa):

    def __init__(self, nome: str, idade: int, altura: float, matricula: str, disciplina: str):
        super().__init__(nome, idade, altura)
        self.__matricula = matricula
        self.__disciplina = disciplina

    def getMatricula(self) -> str:
        return self.__matricula

    def setMatricula(self, matricula: str) -> None:
        self.__matricula = matricula

    def getDisciplina(self) -> str:
        return self.__disciplina

    def setDisciplina(self, disciplina: str) -> None:
        self.__disciplina = disciplina

    def SeApresentar(self) -> None:
        super().SeApresentar()
        print(f"Matrícula: {self.__matricula}")
        print(f"Disciplina: {self.__disciplina}")
        print("Tipo: Professor")
