package grafo;

import java.util.ArrayList;

// Nathan Reikdal Cervieri
public class Grafo {

    protected ArrayList<Vertice> vertices;
    protected ConjuntoAresta arestas;

    public Grafo() {
        this.vertices = new ArrayList<>();
        this.arestas = new ConjuntoAresta();
    }

    public void adicionarAresta(String nomeVerticeOrigem, String nomeVerticeDestino, double valorAresta) {
        Vertice verticeOrigem = possuiVertice(nomeVerticeOrigem) ? vertices.get(vertices.indexOf(new Vertice(nomeVerticeOrigem))) : adicionarVertice(nomeVerticeOrigem);
        Vertice verticeDestino = possuiVertice(nomeVerticeDestino) ? vertices.get(vertices.indexOf(new Vertice(nomeVerticeDestino))) : adicionarVertice(nomeVerticeDestino);

        arestas.adicionarAresta(verticeOrigem, verticeDestino, valorAresta);
    }

    private Vertice adicionarVertice(String nomeVertice) {
        Vertice verticeNovo = new Vertice(nomeVertice);

        vertices.add(verticeNovo);

        return verticeNovo;
    }

    private boolean possuiVertice(String nomeVertice) {
        return vertices.contains(new Vertice(nomeVertice));
    }

    @SuppressWarnings({"MethodDoesntCallSuperMethod"})
    @Override
    public Grafo clone() {
        Grafo clone = new Grafo();

        for (Aresta aresta : arestas.getArestas()) {
            clone.adicionarAresta(aresta.getVerticeOrigem().getNome(), aresta.getVerticeDestino().getNome(), aresta.getValor());
        }

        return clone;
    }

    @Override
    public String toString() {
        return arestas.toString();
    }

    public double getTotalArestas() {
        return arestas.getTotalArestas();
    }

    ConjuntoAresta getArestas() {
        return arestas;
    }

    ArrayList<Vertice> getVertices() {
        return vertices;
    }
}
