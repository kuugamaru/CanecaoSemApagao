package models;

public class Gestor {
    private int id;
    private String nome;
    private String setorResponsavel;

    public Gestor() {}

    public Gestor(int id, String nome, String setorResponsavel) {
        this.id = id;
        this.nome = nome;
        this.setorResponsavel = setorResponsavel;
    }

    public int getId() { 
        return id;
     }
    public void setId(int id) {
         this.id = id;
         }
    public String getNome() {
         return nome;
         }
    public void setNome(String nome) {
         this.nome = nome;
         }
    public String getSetorResponsavel() { 
        return setorResponsavel; 
    }
    public void setSetorResponsavel(String setorResponsavel) { 
        this.setorResponsavel = setorResponsavel; 
    }

    void analisarOcorrencias() {
        
    }
    void atualizarStatus() {

    }

    @Override
    public String toString() {
        return "Gestor{id=" + id + ", nome='" + nome + "', setor='" + setorResponsavel + "'}";
    }
}