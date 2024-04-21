package classesPackage;

public class Voo {
    protected int codigo;
    protected Astronauta[] passageiros;
    protected int status;

    public Voo(int codigo) {
        this.codigo = codigo;
        this.passageiros = new Astronauta[0];
        this.status = 0;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getStatus() {
        return status;
    }

    // 0 - Planejamento
    // 1 - Em curso
    // 2 - Finalizado com sucesso
    // 3 - Finalizado com insucesso
    public void setStatus(int status) {
        this.status = status;
    }

    public void setPassageiros(Astronauta[] passageiros) {
        this.passageiros = passageiros;
    }

    public Astronauta[] getPassageiros() {
        return passageiros;
    }
}