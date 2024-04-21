package classesPackage;

public class Astronauta {
    protected String nome;
    protected String cpf;
    protected int idade;
    protected int status;
    protected int belongsTo;

    public Astronauta() {
        this.cpf = "";
        this.idade = 0;
        this.nome = "";
        this.status = 0;
        this.belongsTo = 0;
    };

    public Astronauta(String cpf, String nome, int idade) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getStatus() {
        return status;
    }

    // 0 - Disponivel
    // 1 - Alocado em voo
    // 2 - Em missão
    // 3 - Morto
    public void setStatus(int status) {
        this.status = status;
    }

    public int getBelongsTo() {
        return belongsTo;
    }

    public void setBelongsTo(int belongsTo) {
        this.belongsTo = belongsTo;
    }

}
