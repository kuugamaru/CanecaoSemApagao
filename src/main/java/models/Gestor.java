package models;

public class Gestor {
    int id;
    String nome;
    String setorResponsavel;

    public Gestor(int id, String nome, String setorResponsavel) {
        this.id = id;
        this.nome = nome;
        this.setorResponsavel = setorResponsavel;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSetorResponsavel() {
        return this.setorResponsavel;
    }

    public void setSetorResponsavel(String setorResponsavel) {
        this.setorResponsavel = setorResponsavel;
    }

    void analisarOcorrencias () {
    
    }

    void analisarStatus () {

    }
}