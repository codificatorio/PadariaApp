package contabilidade;

import static contabilidade.Moeda.€;
import java.math.BigDecimal;

public class Preço {

    BigDecimal valor;
    Moeda moeda = €; // default moeda

    private Preço(double valor) {
        this.valor = BigDecimal.valueOf(valor);
    }

    public static Preço de(double valor) {
        return new Preço(valor);
    }

    @Override
    public String toString() {
        return moeda.name() + valor;
    }
    
    public double getValor() {
        return valor.doubleValue();
    }

}
