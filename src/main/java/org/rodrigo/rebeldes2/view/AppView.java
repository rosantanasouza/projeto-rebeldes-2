package org.rodrigo.rebeldes2.view;

import org.rodrigo.rebeldes2.controller.InteligenciaController;
import org.rodrigo.rebeldes2.model.Rebelde;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppView {

    InteligenciaController yoda = new InteligenciaController();

    public void app() {
        System.out.println("#######---BEM-VINDO A INGRESSÃO AO EXÉRCITO REBELDE---######");
        System.out.println("#######---NOSSA INTELIGENCIA ARTIFICIAL IRÁ AUXILIAR" +
                " SE VOCÊ É CAPACITADO PARA INGESSAR EM NOSSO EXÉRCITO---######");
        System.out.println("ESCOLHA UMA OPÇÃO ABAIXO PARA COMEÇAR:");
        menuInicial();
    }

    private void menuInicial() {
        System.out.println("[1] - INICIAR SELEÇÃO;");
        System.out.println("[2] - AINDA NÃO ME SINTO PRONTO.");

        Scanner input = new Scanner(System.in);
        try {
            Integer option = input.nextInt();
            switch (option) {
                case 1:
                    RebeldeView rebeldeView = new RebeldeView();
                    Rebelde rebelde = rebeldeView.cadastrarRebelde();

                    this.yoda.examinarRebelde(rebelde);

                    menuAux();
                    break;

                case 2:
                    System.out.println("TUDO BEM, VOLTE QUANDO ESTIVER PRONTO.");
                    break;

                default:
                    System.out.println("OPÇÃO INÁLIDA. POR FAVOR, SELECIONE UMA OPÇÃO VÁLIDA DO MENU.");
                    menuInicial();
            }
        }
        catch (InputMismatchException exception) {
            System.out.println("OPÇÃO INÁLIDA. POR FAVOR, SELECIONE UMA OPÇÃO VÁLIDA DO MENU.");
            menuInicial();
        }
    }

    private void menuAux() {
        System.out.println();
        System.out.println("SELECIONE UMA OPÇÃO ABAIXO:");
        System.out.println("[1] - CADASTRAR NOVO REBELDE");
        System.out.println("[2] - VISUALIZAR LISTA EM TELA E IMPRIMIR O ARQUIVO DA LISTA EM FORMATO TXT.");
        System.out.println("[3] - SAIR DA APLICAÇÃO.");

        Scanner input = new Scanner(System.in);
        try {
            Integer option = input.nextInt();
            switch (option) {
                case 1:
                    menuInicial();
                    break;

                case 2:
                    menuImpressaoArquivo();
                    break;

                case 3:
                    System.exit(0);

                default:
                    System.out.println("Opção inválida. Por favor, selecione uma opção válida.");
                    menuAux();
            }
        }
        catch (InputMismatchException exception) {
            System.out.println("Opção inválida. Por favor, selecione uma opção válida.");
            menuAux();
        }
    }

    private void menuImpressaoArquivo() {
        System.out.println();
        System.out.println("SELECIONE A OPÇÃO QUE DESEJA OBTER A LISTA DE REBELDES:");
        System.out.println("[1] - ORDENAÇÃO POR NOME.");
        System.out.println("[2] - ORDENAÇÃO POR IDADE.");
        System.out.println("[3] - ORDENAÇÃO POR RAÇA.");

        Scanner input = new Scanner(System.in);
       try {
           Integer option = input.nextInt();
           switch (option) {
               case 1:
                   System.out.println(this.yoda.imprimirListaOrdemNome());
                   break;

               case 2:
                   System.out.println(this.yoda.imprimirListaOrdemIdade());
                   break;

               case 3:
                   System.out.println(this.yoda.imprimirListaOrdemRaca());
                   break;

               default:
                   System.out.println("Opção inválida. Por favor, selecione uma opção válida.");
                   menuImpressaoArquivo();
           }
       }
       catch (InputMismatchException exception) {
           System.out.println("Opção inválida. Por favor, selecione uma opção válida.");
           menuImpressaoArquivo();
       }
    }
}
