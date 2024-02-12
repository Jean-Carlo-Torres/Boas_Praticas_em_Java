package br.com.alura;

import br.com.alura.client.ClientHttpConfiguration;
import br.com.alura.command.*;
import br.com.alura.service.AbrigoService;
import br.com.alura.service.PetService;

import java.util.Scanner;

public class AdopetConsoleApplication {

    public static void main(String[] args) {

        CommandExecutor executor = new CommandExecutor();
        ClientHttpConfiguration client = new ClientHttpConfiguration();
        AbrigoService abrigoService = new AbrigoService(client);
        PetService  petService = new PetService(client);

        System.out.println("##### BOAS VINDAS AO SISTEMA ADOPET CONSOLE #####");
        try {
            int opcaoEscolhida = 0;
            while (opcaoEscolhida != 5) {
                System.out.println("\nDIGITE O NÚMERO DA OPERAÇÃO DESEJADA:");
                System.out.println("1 -> Listar abrigos cadastrados");
                System.out.println("2 -> Cadastrar novo abrigo");
                System.out.println("3 -> Listar pets do abrigo");
                System.out.println("4 -> Importar pets do abrigo");
                System.out.println("5 -> Sair");

                String sc = new Scanner(System.in).nextLine();
                opcaoEscolhida = Integer.parseInt(sc);

                switch (opcaoEscolhida) {
                    case 1:
                        executor.executeCommand(new ListarAbrigoCommand());
                        break;
                    case 2:
                        executor.executeCommand(new CadastrarAbrigoCommand());
                        break;
                    case 3:
                        executor.executeCommand(new ListarPetsDoAbrigoCommand());
                        break;
                    case 4:
                        executor.executeCommand(new ImportarPetsDoAbrigoCommand());
                        break;
                    case 5:
                        System.out.println("Finalizando o programa...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            }
            System.out.println("Finalizando o programa...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
