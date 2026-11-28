
from .pessoa import Pessoa


class TecnicoAdministrativo(Pessoa):

    def __init__(self, nome: str, idade: int, altura: float, setor: str):
        super().__init__(nome, idade, altura)
        self.__setor = setor

    def getSetor(self) -> str:
        return self.__setor

    def setSetor(self, setor: str) -> None:
        self.__setor = setor

    def SeApresentar(self) -> None:
        super().SeApresentar()
        print(f"Setor: {self.__setor}")
        print("Tipo: Técnico Administrativo")
