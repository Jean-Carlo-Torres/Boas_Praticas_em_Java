package br.com.alura;

import br.com.alura.client.ClientHttpConfiguration;
import br.com.alura.service.AbrigoService;
import br.com.alura.service.PetService;

import java.util.Scanner;

public class AdopetConsoleApplication {

    public static void main(String[] args) {

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
                        abrigoService.listarAbrigos();
                        break;
                    case 2:
                        abrigoService.cadastrarAbrigo();
                        break;
                    case 3:
                        petService.listarPetsDoAbrigo();
                        break;
                    case 4:
                        petService.importarPetsDoAbrigo();
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
