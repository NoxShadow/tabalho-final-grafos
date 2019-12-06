package grafo;

import java.util.ArrayList;
import java.util.List;

// Nathan Reikdal Cervieri
public class Vertice {

    private String nome;

    private ArrayList<Aresta> arestas;

    Vertice(String nome) {
        this.nome = nome;
        this.arestas = new ArrayList<>();
    }

    public void adicionarLigacao(Vertice destino, double valor) {
        Aresta arestaLigacao = new Aresta(this, destino, valor);
        arestas.add(arestaLigacao);
        destino.adicionarAresta(arestaLigacao);
    }

    public List<Aresta> getArestas() {
        return arestas;
    }

    private void adicionarAresta(Aresta aresta) {
        arestas.add(aresta);
    }

    private void removerAresta(Aresta aresta) {
        arestas.remove(aresta);
    }

    public Aresta buscarMenorAresta() {
        if (arestas.isEmpty()) {
            return null;
        }

        Aresta menorAresta = arestas.get(0);
        double valorMenorAresta = menorAresta.getValor();

        for (Aresta aresta : arestas) {
            if (aresta.getValor() < valorMenorAresta) {
                menorAresta = aresta;
                valorMenorAresta = aresta.getValor();
            }
        }

        return menorAresta;
    }

    public Aresta retirarMenorAresta() {
        Aresta menorAresta = buscarMenorAresta();
        removerAresta(menorAresta);

        return menorAresta;
    }

    public String getNome() {
        return nome;
    }

}
