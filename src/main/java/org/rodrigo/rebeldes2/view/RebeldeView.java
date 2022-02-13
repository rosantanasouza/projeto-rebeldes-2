package org.rodrigo.rebeldes2.view;

import org.rodrigo.rebeldes2.enums.Raca;
import org.rodrigo.rebeldes2.model.Rebelde;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RebeldeView {
    private String nome;
    private Integer idade;
    private Raca raca;
    private Rebelde rebelde;

    public Rebelde cadastrarRebelde() {
        this.rebelde = new Rebelde(nome, idade, raca);
        this.rebelde.setNome(cadastrarNome());
        this.rebelde.setIdade(cadastrarIdade());
        this.rebelde.setRaca(cadastrarRaca());
        return this.rebelde;
    }

    private String cadastrarNome() {
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o nome do candidato a Rebelde:");
        this.nome = input.nextLine();
        if(nome.isBlank()){
            System.out.println("Nome não pode ser vazio, por favor insira um nome válido!");
            cadastrarNome();
        }
        return nome;
    }

    private Integer cadastrarIdade() {
        System.out.println("Informe a  idade do candidato:");
        Scanner input = new Scanner(System.in);
        try {
            idade = input.nextInt();
        }
        catch (InputMismatchException exception) {
            System.out.println("Idade inválida. Digite um valor númerico.");
            cadastrarIdade();
        }
        return idade;
    }

    private Raca cadastrarRaca() {
        System.out.println("Selecione a raça que o candidato pertence:");
        for (Raca raca : Raca.values()){
            System.out.printf("[%d] - %s %n", raca.ordinal(), raca.name());
        }
        Scanner input = new Scanner(System.in);

        try{
            Integer racaIndex = input.nextInt();
            raca = Raca.values()[racaIndex];
        }
        catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Opção inválida. Você só pode escolher o que está na sua tela.");
            cadastrarRaca();
        }
        catch (InputMismatchException exeption) {
            System.out.println("Opção inválida. Você só pode escolher o que está na sua tela.");
            cadastrarRaca();
        }
        return raca;
    }
}



