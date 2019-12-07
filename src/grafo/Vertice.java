package grafo;

import java.util.ArrayList;
import java.util.List;

// Nathan Reikdal Cervieri
public class Vertice {

    private String nome;

    Vertice(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public int hashCode() {
        return this.nome.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }

        return this.getNome().equals(((Vertice) obj).getNome());
    }

    @Override
    public String toString() {
        return this.getNome();
    }

}
