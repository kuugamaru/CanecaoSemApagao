public class Ocorrencia {
    private int id;
    private String descricao;
    private String categoria;
    private String endereco;
    private String status;

    public Ocorrencia(int id, String descricao,
            String categoria, String endereco, String status) {
        this.id = id;
        this.descricao = descricao;
        this.categoria = categoria;
        this.endereco = endereco;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getStatus() {
        return status;
    }
}
