package classesPackage;
import java.util.Scanner;

public class Menus {
    public static int displayMenu(Scanner scanner) {
        int opcao;
        
        System.out.println(
            """
            0 - Sair do programa
            1 - Cadastrar um voo
            2 - Cadastrar um astronauta
            3 - Listar e gerenciar voos
            4 - Mostrar astronautas mortos
            """
        );

        opcao = scanner.nextInt();

        return opcao;
    }

    public static int displayMenuVoos(Scanner scanner) {
        int opcao;

        System.out.println(
            """
            0 - Voltar ao menu principal
            1 - Listar voos
            2 - Adicionar astronauta em um voo
            3 - Remover astronauta de um voo
            4 - Lançar um voo
            5 - Explodir um voo
            6 - Finalizar um voo
            """
        );

        opcao = scanner.nextInt();

        return opcao;
    }

    public static void displayOpcaoInvalida(String error) {
        System.out.println(String.format(
            """
            Opção inválida!
            %s
            """, error
        )

        );
    }
}
