
from .pessoa import Pessoa


class TecnicoAdministrativo(Pessoa):

    def __init__(self, nome: str, idade: int, altura: float, matricula: str, setor: str):
        super().__init__(nome, idade, altura)
        self.__matricula = matricula
        self.__setor = setor

    def getMatricula(self) -> str:
        return self.__matricula

    def setMatricula(self, matricula: str) -> None:
        self.__matricula = matricula

    def getSetor(self) -> str:
        return self.__setor

    def setSetor(self, setor: str) -> None:
        self.__setor = setor

    def SeApresentar(self) -> None:
        super().SeApresentar()
        print(f"Matrícula: {self.__matricula}")
        print(f"Setor: {self.__setor}")
        print("Tipo: Técnico Administrativo")
