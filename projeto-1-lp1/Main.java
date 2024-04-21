import java.util.Scanner;
import classesPackage.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agencia agencia = new Agencia();
        int opcao, opcao_voo;


        do {
            opcao = Menus.displayMenu(scanner);

            switch (opcao) {
                case 0:
                    break;
                case 1:
                    agencia.cadastrarVoo(scanner);
                    break;
                case 2:
                    agencia.cadastrarAstronauta(scanner);
                    break;
                case 3:
                    opcao_voo = Menus.displayMenuVoos(scanner);

                    switch (opcao_voo) {
                        case 0:
                            break;
                        case 1:
                            agencia.listarVoos();
                            break;
                        case 2:
                            agencia.adicionarAstronautaVoo(scanner);
                            break;
                        case 3:
                            agencia.removerAstronautaVoo(scanner);
                            break;
                        case 4:
                            agencia.lancarVoo(scanner);
                            break;                            
                        case 5:
                            agencia.explodirVoo(scanner);
                            break;
                        case 6:
                            agencia.finalizarVoo(scanner);
                        default:
                            Menus.displayOpcaoInvalida("");
                            break;
                    }

                    break;
                case 4:
                    agencia.listarAstronautasMortos();
                    break;
                default:
                    Menus.displayOpcaoInvalida("");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }  
}