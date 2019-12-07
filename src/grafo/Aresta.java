package grafo;

import org.jetbrains.annotations.NotNull;

public class Aresta implements Comparable<Aresta>{

    private Vertice verticeOrigem;

    private Vertice verticeDestino;

    private Double valor;

    Aresta(Vertice verticeOrigem, Vertice verticeDestino, double valor) {
        this.verticeOrigem = verticeOrigem;
        this.verticeDestino = verticeDestino;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public Vertice getOutroVertice(Vertice nomeVertice) {
        if (this.verticeOrigem.equals(nomeVertice)) {
            return this.verticeDestino;
        }
        if (this.verticeDestino.equals(nomeVertice)) {
            return this.verticeOrigem;
        }

        return null;
    }

    public Vertice getVerticeDestino() {
        return verticeDestino;
    }

    public Vertice getVerticeOrigem() {
        return verticeOrigem;
    }

    public boolean possuiVertice(Vertice verticeProcurado) {
        return this.verticeOrigem.equals(verticeProcurado) || this.verticeDestino.equals(verticeProcurado);
    }

    @Override
    public int hashCode() {
        return this.verticeOrigem.hashCode() + this.verticeDestino.hashCode() + ((Double) (valor * 1000)).intValue();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        if (this.hashCode() != obj.hashCode()) {
            return false;
        }

        Aresta arestaComparativa = (Aresta) obj;

        return ((this.verticeOrigem.equals(arestaComparativa.verticeDestino) && this.verticeDestino.equals(arestaComparativa.verticeOrigem) && this.valor.equals(arestaComparativa.valor))
                || (this.verticeOrigem.equals(arestaComparativa.verticeOrigem) && this.verticeDestino.equals(arestaComparativa.verticeDestino) && this.valor.equals(arestaComparativa.valor)));
    }

    @Override
    public String toString() {
        if(verticeOrigem.getNome().compareTo(verticeDestino.getNome()) > 0) {
            return verticeDestino + " - " + verticeOrigem + " = " + getValor();
        } else {
            return verticeOrigem + " - " + verticeDestino + " = " + getValor();
        }
    }

    @Override
    public int compareTo(@NotNull Aresta outraAresta) {
        return Double.compare(this.getValor(), outraAresta.getValor());
    }
}
