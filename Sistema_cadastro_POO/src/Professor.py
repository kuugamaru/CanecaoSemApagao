
from .pessoa import Pessoa


class Professor(Pessoa):

    def __init__(self, nome: str, idade: int, altura: float, disciplina: str):
        super().__init__(nome, idade, altura)
        self.__disciplina = disciplina

    def getDisciplina(self) -> str:
        return self.__disciplina

    def setDisciplina(self, disciplina: str) -> None:
        self.__disciplina = disciplina

    def SeApresentar(self) -> None:
        super().SeApresentar()
        print(f"Disciplina: {self.__disciplina}")
        print("Tipo: Professor")
