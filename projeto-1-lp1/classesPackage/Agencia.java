package classesPackage;
import java.util.Scanner;

public class Agencia {
    protected Astronauta[] lista_astronautas;
    protected Voo[] lista_voos;

    public Agencia() {
        this.lista_astronautas = new Astronauta[0];
        this.lista_voos = new Voo[0];
    }

    public void cadastrarAstronauta(Scanner scanner) {
        System.out.println("Cadastro de astronauta:");

        System.out.println("CPF do astronauta:");
        String cpf = scanner.next();
        if (this.findAstronauta(cpf) != -1) {
            Menus.displayOpcaoInvalida("Já existe um astronauta com esse CPF!");  
            return; 
        }

        System.out.println("Nome do astronauta:");
        String nome = scanner.next();
        System.out.println("Idade do astronauta:");
        int idade = scanner.nextInt();

        int length = this.lista_astronautas.length;

        Astronauta[] new_array = new Astronauta[length + 1];

        for (int i = 0; i < length; i++) {
            new_array[i] = this.lista_astronautas[i];
        }

        new_array[length] = new Astronauta(cpf, nome, idade);

        this.lista_astronautas = new_array;
    }


    public void cadastrarVoo(Scanner scanner) {
        System.out.println("Cadastro de voo");
        System.out.println("Código do voo:");
        int codigo = scanner.nextInt();
        if (this.findVoo(codigo) != -1) {
            Menus.displayOpcaoInvalida("Já existe um voo com esse código!");   
        }

        int length = this.lista_voos.length;


        Voo[] new_array = new Voo[length + 1];

        for (int i = 0; i < length; i++) {
            new_array[i] = this.lista_voos[i];
        }

        new_array[length] = new Voo(codigo);

        this.lista_voos = new_array;
    }

    public void listarVoos() {
        if (this.lista_voos.length == 0) {
            System.out.println("Nenhum voo cadastrado.");
            return;
        }

        for (int i = 0; i < this.lista_voos.length; i++) {
            System.out.println(String.format("%d - Código: %d", i + 1, this.lista_voos[i].getCodigo()));
            for (int j = 0; j < this.lista_voos[i].passageiros.length; j++) {
                System.out.println(String.format("\t\\_%d - CPF: %s; Nome: %s;", 
                j + 1, 
                this.lista_voos[i].passageiros[j].getCpf(),
                this.lista_voos[i].passageiros[j].getNome()));
            }
        }
    }

    public void adicionarAstronautaVoo(Scanner scanner) {
        System.out.println("Escolha um voo.");
        this.listarVoos();
        int index_voo = this.findVoo(scanner.nextInt());

        int length = lista_voos[index_voo].passageiros.length;
        scanner.nextLine();

        System.out.println("Escolha um astronauta.");
        this.listarAstronautas();
        int index_astronauta = this.findAstronauta(scanner.next());

        Astronauta[] new_passageiros = new Astronauta[length + 1];

        for (int i = 0; i < length; i++) {
            new_passageiros[i] = lista_voos[index_voo].passageiros[i];
        }

        this.lista_astronautas[index_astronauta].setStatus(1);
        new_passageiros[length] = this.lista_astronautas[index_astronauta];

        this.lista_voos[index_voo].passageiros = new_passageiros;

    }

    public void removerAstronautaVoo(Scanner scanner) {
        System.out.println("Escolha um voo.");
        this.listarVoos();
        int index_voo = this.findVoo(scanner.nextInt());

        int length = lista_voos[index_voo].passageiros.length;
        scanner.nextLine();

        System.out.println("Escolha um astronauta.");
        this.listarAstronautas();
        int index_astronauta = this.findAstronauta(scanner.next());

        Astronauta[] new_passageiros = new Astronauta[length - 1];

        for (int i = 0; i < index_astronauta; i++) {
            new_passageiros[i] = lista_voos[index_voo].passageiros[i];
        }

        for (int i = index_astronauta; i < length - 1; i++) {
            new_passageiros[i] = lista_voos[index_voo].passageiros[i + 1];
        }

        this.lista_astronautas[index_astronauta].setStatus(0);

        this.lista_voos[index_voo].passageiros = new_passageiros;
    }

    public void lancarVoo(Scanner scanner) {
        System.out.println("Escolha um voo.");
        this.listarVoos();

        int index_voo = this.findVoo(scanner.nextInt());

        lista_voos[index_voo].setStatus(1);

        for (int i = 0; i < lista_voos[index_voo].passageiros.length; i++) {
            lista_voos[index_voo].passageiros[i].setStatus(2);
        }

    }

    public void explodirVoo(Scanner scanner) {
        System.out.println("Escolha um voo.");
        this.listarVoos();

        int index_voo = this.findVoo(scanner.nextInt());

        lista_voos[index_voo].setStatus(3);

        for (int i = 0; i < lista_voos[index_voo].passageiros.length; i++) {
            lista_voos[index_voo].passageiros[i].setStatus(3);
        }
    }

    public void finalizarVoo(Scanner scanner) {
        System.out.println("Escolha um voo.");
        this.listarVoos();
        
        int index_voo = this.findVoo(scanner.nextInt());

        lista_voos[index_voo].setStatus(2);

        for (int i = 0; i < lista_voos[index_voo].passageiros.length; i++) {
            lista_voos[index_voo].passageiros[i].setStatus(0);
        }
    }

    public void listarAstronautasMortos() {
        if (this.lista_astronautas.length == 0) {
            System.out.println("Nenhum astronauta morto.");
            return;
        }

        for (int i = 0; i < this.lista_astronautas.length; i++) {
            if (this.lista_astronautas[i].getStatus() == 3) {
                System.out.println(String.format("%d - CPF: %s; Nome: %s; Idade: %d", 
                i + 1, 
                this.lista_astronautas[i].getCpf(),
                this.lista_astronautas[i].getNome(),
                this.lista_astronautas[i].getIdade()));
            }
        }
    }

    /*
     * Utils
     */

    public int findAstronauta(String cpf) {
        for (int i = 0; i < this.lista_astronautas.length; i++) {
            if (this.lista_astronautas[i].cpf.equals(cpf)) {
                return i;
            }
        }
        return -1;
    } 

    public int findVoo(int codigo) {
        for (int i = 0; i < this.lista_voos.length; i++) {
            if (this.lista_voos[i].codigo == codigo) {
                return i;
            }
        }
        return -1;
    } 

    public void listarAstronautas() {
        if (this.lista_astronautas.length == 0) {
            System.out.println("Nenhum astronauta.");
            return;
        }

        for (int i = 0; i < this.lista_astronautas.length; i++) {
            System.out.println(String.format("%d - CPF: %s; Nome: %s; Idade: %d", 
                i + 1, 
            this.lista_astronautas[i].getCpf(),
            this.lista_astronautas[i].getNome(),
            this.lista_astronautas[i].getIdade()));
        }
    }
}