package grafo;

public class Aresta {

    private Vertice verticeOrigem;

    private Vertice verticeDestino;

    private double valor;

    Aresta(Vertice verticeOrigem, Vertice verticeDestino, double valor) {
        this.verticeOrigem = verticeOrigem;
        this.verticeDestino = verticeDestino;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public Vertice getVerticeDestino() {
        return verticeDestino;
    }

    public Vertice getVerticeOrigem() {
        return verticeOrigem;
    }
}
