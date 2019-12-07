package grafo;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

// Nathan Reikdal Cervieri
public class ArvoreGeradora extends Grafo {

    private HashSet<Vertice> verticesJaInseridos;
    private ConjuntoAresta conjuntoPrim;

    private ArrayList<Aresta> arestasOrdenadas;

    public ArvoreGeradora(Grafo grafoOriginal) {
        this.arestas = grafoOriginal.getArestas();
        this.vertices = grafoOriginal.getVertices();

        verticesJaInseridos = new HashSet<>();
        conjuntoPrim = new ConjuntoAresta();
        arestasOrdenadas = new ArrayList<>();

        gerarArvoreGeradora();

        this.arestas = conjuntoPrim;
        this.vertices = new ArrayList<>(verticesJaInseridos);
    }

    private void gerarArvoreGeradora() {
        List<Aresta> arestasNaoOrdenadas = super.arestas.getArestas();

        Iterable<Aresta> arestasOrdenadas = Utils.ordenarArestas(arestasNaoOrdenadas);

        ArrayList<Aresta> arestas = new ArrayList<>(arestasNaoOrdenadas);

        if (arestas.size() > 0) {
            Aresta menorAresta = arestas.get(0);
            adicionarAresta(menorAresta);
            arestas.remove(menorAresta);

            encontrarMenoresAresta(arestas);
        }

    }

    private void encontrarMenoresAresta(ArrayList<Aresta> arrayArestas) {
        do {
            Aresta menorArestaConexa = encontrarMenorArestaConexaValida(arrayArestas);

            adicionarAresta(menorArestaConexa);
            arrayArestas.remove(menorArestaConexa);
        } while (verticesJaInseridos.size() < super.vertices.size());
    }

    private Aresta encontrarMenorArestaConexaValida(ArrayList<Aresta> arrayArestas) {
        TreeSet<Aresta> arestasConexas = new TreeSet<>();

        for (Aresta aresta : arrayArestas) {
            boolean deveAdicionarAresta = false;

            for (Vertice vertice : verticesJaInseridos) {
                if (aresta.possuiVertice(vertice)) {
                    deveAdicionarAresta = true;
                    for (Vertice vertice1 : verticesJaInseridos) {
                        if (vertice != vertice1) {
                            if (aresta.possuiVertice(vertice) && aresta.possuiVertice(vertice1)) {
                                deveAdicionarAresta = false;
                                break;
                            }
                        }
                    }
                }
            }

            if (deveAdicionarAresta)
                arestasConexas.add(aresta);
        }

        if (arestasConexas.size() > 0) {
            return arestasConexas.first();
        }

        throw new RuntimeException("O grafo não gera uma única árvore geradora");
    }

    private void adicionarAresta(Aresta aresta) {
        this.conjuntoPrim.adicionarAresta(aresta);
        arestasOrdenadas.add(aresta);

        verticesJaInseridos.add(aresta.getVerticeOrigem());
        verticesJaInseridos.add(aresta.getVerticeDestino());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        double valorTotalArestas = 0;

        builder.append("Vértices: [ ").append("\n");

        for (Aresta aresta : arestasOrdenadas) {
            builder.append(aresta).append("\n");
            valorTotalArestas += aresta.getValor();
        }

        builder.append("\n").append("]").append("\n");

        builder.append("Custo Total: ").append(valorTotalArestas);

        return builder.toString();
    }
}
