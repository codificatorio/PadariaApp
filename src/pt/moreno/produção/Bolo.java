package pt.moreno.produção;

import contabilidade.Preço;
import java.time.*;

public class Bolo implements Comparable<Bolo> {

    String nome; // campo ("field") do tipo referência (tudo o que não é primitivo)
    int peso; // gramas, possivelmente a substituir por uma classe Peso (que p.ex. tem um campo "unidade", sendo gramas, kilos, ...)
    Farinha farinha; // uma enumeração ("enum"), permitir-nós-á ser mais especifico sobre a farinha utilizada
    Preço preço; // classe próprio com extra funcionalidade (que BigDecimal não possui)
    LocalDateTime produzido; // 2021-12-12 com validade de 3 meses e 2 semanas
    Period validade;
    Tipo tipo;

    public Bolo(String nome, int gramas, LocalDateTime dataDeProdução, Period validade, double preço, Tipo tipo) {
        this.nome = nome;
        peso = gramas;
        produzido = dataDeProdução;
        this.validade = validade;
        this.preço = Preço.de(preço); // factory pattern
        this.tipo = tipo;
    }

    @Override
    public int compareTo(Bolo outro) {
        return this.nome.compareTo(outro.nome);
    }

    public LocalDate consumirAté() {
        return produzido.plus(validade).toLocalDate();
    }

    @Override
    public String toString() {
        return nome + ' ' + preço + " (validade " + consumirAté() + ")";
    }
    
    public Tipo getTipo() {
        return tipo;
    }
    
    public Preço getPreço() {
        return preço;
    }

}

// em versões anteriores:
// double preço; // em euros (p.ex. 12.459)
// BigDecimal preço; // melhor alternativa por ter algorimos de arrondamento
// char farinha; // T(rigo), E(spelta), ....
// Date dataDeProdução; // classe depreciada, a substituir por Instant, ZoneDateTime ou LocalDateTime
