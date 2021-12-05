package pt.moreno;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;
import pt.moreno.produção.Bolo;
import pt.moreno.produção.Tipo;

public class PadariaApp {
    static final double BARATO = 1.0;
    static List<Bolo> bolos;

    public static void main(String[] args) {
        System.out.println("Por ordem de produção\n········· ········· ········· ········· ········· ········· ········· ");
        bolos = Arrays.asList(new Bolo[]{
            new Bolo("Almendroada", 12, LocalDateTime.of(2021, 11, 1, 17, 0), Period.ofDays(5), .2, Tipo.Doce),
            new Bolo("Pastél de Feijão", 75, LocalDateTime.of(2021, 11, 29, 7, 45), Period.ofDays(2), 1.25, Tipo.Doce),
            new Bolo("Pastél de Natas", 95, LocalDateTime.of(2021, 12, 5, 10, 0), Period.ofDays(5), 1.5, Tipo.Doce),
            new Bolo("Areias", 15, LocalDateTime.of(2021, 11, 29, 7, 0), Period.ofDays(30), .05, Tipo.Doce),
            new Bolo("Língua da sogra", 50, LocalDateTime.of(2021, 12, 1, 7, 30), Period.ofDays(10), .1, Tipo.Doce),
            new Bolo("Língua de gato", 5, LocalDateTime.of(2021, 10, 15, 8, 20), Period.ofDays(30), .05, Tipo.Doce),
            new Bolo("Croissant", 66, LocalDateTime.of(2021, 12, 2, 8, 15), Period.ofDays(1), 2, Tipo.Doce),
            new Bolo("Quiche", 125, LocalDateTime.of(2021, 12, 3, 13, 15), Period.ofDays(3), 3.5, Tipo.Salgado),
            new Bolo("Pastel de Bacalhau", 75, LocalDateTime.of(2021, 12, 3, 6, 00), Period.ofDays(2), 1.6, Tipo.Salgado),
            new Bolo("Rissol", 59, LocalDateTime.of(2021, 12, 2, 18, 00), Period.ofDays(2), .99, Tipo.Salgado)
        });
        for (Bolo bolo : bolos)
            imprimir(bolo);
        // ········· ········· ········· ········· ·········  
        System.out.println("\nPor ordem alfabética\n········· ········· ········· ········· ········· ········· ········· ");
        Collections.sort(bolos); // somente possível porque Bolo tem o método compareTo()
        for (Bolo bolo : bolos)
            imprimir(bolo);
        // ········· ········· ········· ········· ·········  
        System.out.println("\nPor ordem de validade\n········· ········· ········· ········· ········· ········· ········· ");
        System.out.println("Como implementar??");
        /*
        // sintaxe das classes anónimas internas
        ordenador = new Comparator<Bolo>() {
            @Override
            public int compare(Bolo um, Bolo outro) {
                return um.consumirAté().compareTo(outro.consumirAté());
            }
        };
        // sintaxe lambda, com atribuição a uma variável 
        Comparator<Bolo> ordenador = (um, outro) -> um.consumirAté().compareTo(outro.consumirAté());
        Collections.sort(bolos, ordenador);
         */
        // definição "in situ" de uma nova "classe local" com sintaxe lambda que implementa Comparator
        Collections.sort(bolos, (um, outro) -> um.consumirAté().compareTo(outro.consumirAté()));
        for (Bolo bolo : bolos)
            imprimir(bolo);
        //
        // DESAFIO
        System.out.println("\nBaratos por tipo\n········· ········· ········· ········· ········· ········· ········· ");
        Map<Tipo, List<Bolo>> baratosPorTipo = bolos.stream().filter(b -> éBarato(b)).sorted().collect(Collectors.groupingBy(Bolo::getTipo));
        imprimir(baratosPorTipo);
    }

    static void imprimir(Object objeto) {
        System.out.println(objeto);
    }
    
    public static boolean éBarato(Bolo bolo) {
        return bolo.getPreço().getValor().compareTo(BigDecimal.valueOf(BARATO)) == -1;
    }
}
