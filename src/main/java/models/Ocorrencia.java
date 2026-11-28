package models;

public class Ocorrencia {
    private int id;
    private String descricao;
    private String categoria;
    private String endereco;
    private String status;

    // Construtor vazio para criar ANTES de salvar no banco
    public Ocorrencia() {
        this.status = "aberta";
    }

    // Construtor completo (usado pelo DAO ao ler do banco)
    public Ocorrencia(int id, String descricao, String categoria, String endereco, String status) {
        this.id = id;
        this.descricao = descricao;
        this.categoria = categoria;
        this.endereco = endereco;
        this.status = status;
    }

    public int getId() {
         return id;
         }
    public void setId(int id) { 
        this.id = id; 
    }
    public String getDescricao() { 
        return descricao;
     }
    public void setDescricao(String descricao) { 
        this.descricao = descricao; 
    }
    public String getCategoria() { 
        return categoria; 
    }
    public void setCategoria(String categoria) {
         this.categoria = categoria;
        }
    public String getEndereco() { 
        return endereco; 
    }
    public void setEndereco(String endereco) {
         this.endereco = endereco;
         }
    public String getStatus() {
         return status; 
        }
    public void setStatus(String status) { 
        this.status = status; 
    }

    @Override
    public String toString() {
        return "Ocorrencia{id=" + id + ", descricao='" + descricao + "', categoria='"
                + categoria + "', endereco='" + endereco + "', status='" + status + "'}";
    }
}