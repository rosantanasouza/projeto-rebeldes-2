package org.rodrigo.rebeldes2.controller;

import org.rodrigo.rebeldes2.model.Rebelde;

import lombok.Cleanup;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class InteligenciaController {
    LinkedList<Rebelde> listaRebeldes = new LinkedList<>();

    public void examinarRebelde(Rebelde rebeldeNovo) {
        Random exame = new Random();
        Integer resultadoExame = exame.nextInt(11);

        if(resultadoExame > 5){
            System.out.println("Resultado do exame: " + resultadoExame);
            this.listaRebeldes.add(rebeldeNovo);
            System.out.println("Mestre Yoda aprovou o novo rebelde! Bem vindo ao exército");
        }
        else {
            System.out.println("Resultado do exame: " + resultadoExame);
            System.out.println("Mestre Yoda ainda acha que você precisa de mais treino. Volte em outro momento.");
        }

    }

    public LinkedList<Rebelde> imprimirListaOrdemNome() {
        listaRebeldes.sort(Comparator.comparing(Rebelde::getNome));

        try {
            @Cleanup PrintWriter file = new PrintWriter("Lista_Rebeldes_Nome.txt", "UTF-8");
            file.println("LISTA REBELDES ORDENADA POR NOME:");
            file.println(listaRebeldes);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return listaRebeldes;
    }

    public LinkedList<Rebelde> imprimirListaOrdemIdade() {
      listaRebeldes.sort(Comparator.comparing(Rebelde::getIdade));

      try {
            @Cleanup PrintWriter file = new PrintWriter("Lista_Rebeldes_Idade.txt", "UTF-8");
            file.println("LISTA REBELDES ORDENADA POR IDADE:");
            file.println(listaRebeldes);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return listaRebeldes;
    }

    public LinkedList<Rebelde> imprimirListaOrdemRaca() {
        listaRebeldes.sort(Comparator.comparing(Rebelde::getRaca));

        try {
            @Cleanup PrintWriter file = new PrintWriter("Lista_Rebeldes_Raca.txt", "UTF-8");
            file.println("LISTA REBELDES ORDENADA POR RAÇA:");
            file.println(listaRebeldes);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return listaRebeldes;
    }
}
