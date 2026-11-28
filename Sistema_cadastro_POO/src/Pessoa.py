
class Pessoa:
    def __init__(self, nome: str, idade: int, altura: float):
        self.__nome = nome
        self.__idade = idade
        self.__altura = altura

    def getNome(self) -> str:
        return self.__nome

    def setNome(self, nome: str) -> None:
        self.__nome = nome

    def getIdade(self) -> int:
        return self.__idade

    def setIdade(self, idade: int) -> None:
        self.__idade = idade

    def getAltura(self) -> float:
        return self.__altura

    def setAltura(self, altura: float) -> None:
        self.__altura = altura

    def SeApresentar(self) -> None:
        print(f"Nome: {self.__nome}")
        print(f"Idade: {self.__idade} anos")
        print(f"Altura: {self.__altura:.2f} m")
      
