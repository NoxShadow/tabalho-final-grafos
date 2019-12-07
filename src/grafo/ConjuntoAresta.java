package grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// Nathan Reikdal Cervieri
class ConjuntoAresta {

    private HashSet<Aresta> arestas;

    ConjuntoAresta() {
        this.arestas = new HashSet<>();
    }

    void adicionarAresta(Vertice nomeVerticeOrigem, Vertice nomeVerticeDestino, double valor) {
        arestas.add(new Aresta(nomeVerticeOrigem, nomeVerticeDestino, valor));
    }

    void adicionarAresta(Aresta aresta) {
        arestas.add(aresta);
    }

    HashMap<Vertice, Double> buscarArestasComVertice(Vertice vertice) {
        HashMap<Vertice, Double> arestasEncontradas = new HashMap<>();

        for (Aresta aresta : arestas) {
            if (aresta.possuiVertice(vertice)) {
                arestasEncontradas.put(aresta.getOutroVertice(vertice), aresta.getValor());
            }
        }

        return arestasEncontradas;
    }

    List<Aresta> getArestas() {
        return new ArrayList<>(this.arestas);
    }

    public double getTotalArestas() {
        double total = 0;

        for(Aresta aresta : arestas) {
            total += aresta.getValor();
        }

        return total;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        double valorTotalArestas = 0;

        builder.append("Vértices: [ ").append("\n");



        for (Aresta aresta : arestas) {
            builder.append(aresta).append("\n");
            valorTotalArestas += aresta.getValor();
        }

        builder.append("\n").append("]").append("\n");

        builder.append("Custo Total: ").append(valorTotalArestas);

        return builder.toString();
    }

    public void juntarConjuntos(ConjuntoAresta outroConjunto) {
        this.arestas.addAll(outroConjunto.getArestas());
    }

    public boolean contemVertice(Vertice vertice) {
        for (Aresta aresta : arestas) {
            if(aresta.possuiVertice(vertice)) {
                return true;
            }
        }

        return false;
    }

}
