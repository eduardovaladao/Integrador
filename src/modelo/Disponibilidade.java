package modelo;

import java.util.HashMap;
import java.util.Map;

public enum Disponibilidade {
    ABERTO("ABERTO"),
    INDISPONÍVEL("INDISPONÍVEL"),
    REFORMANDO("REFORMANDO");
    
    private String valor;
    
    private static final Map<String, Disponibilidade> disponibilidadePorvalor = new HashMap<>();
    
    static {
        for (Disponibilidade dis : Disponibilidade.values()) {
            disponibilidadePorvalor.put(dis.getValor(), dis);
        }
    }
    
    Disponibilidade(String valor) {
        this.valor = valor;
    }
    
    public String getValor() {
        return valor;
    }
    
    public static Disponibilidade pegaDisponibilidadePorValor(String valor) {
        return disponibilidadePorvalor.get(valor);
    }
}
