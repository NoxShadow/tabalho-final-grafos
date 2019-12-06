package grafo;

import java.util.HashMap;

// Nathan Reikdal Cervieri
public class Grafo {

    private HashMap<String, Vertice> vertices;

    public Grafo() {
        this.vertices = new HashMap<>();
    }

    public void adicionarAresta(String nomeVerticeOrigem, String nomeVerticeDestino, double valorAresta) {
        if (!possuiVertice(nomeVerticeOrigem)) {
            adicionarVertice(nomeVerticeOrigem);
        }

        if (!possuiVertice(nomeVerticeDestino)) {
            adicionarVertice(nomeVerticeDestino);
        }

        Vertice verticeOrigem = vertices.get(nomeVerticeOrigem);
        Vertice verticeDestino = vertices.get(nomeVerticeDestino);

        verticeOrigem.adicionarLigacao(verticeDestino, valorAresta);
    }

    private void adicionarVertice(String nomeVertice) {
        vertices.put(nomeVertice, new Vertice(nomeVertice));
    }

    private boolean possuiVertice(String nomeVertice) {
        return vertices.containsKey(nomeVertice);
    }

}
