package grafo;

import java.util.ArrayList;
import java.util.HashSet;

// Nathan Reikdal Cervieri
public class CalculoDeUmParaOutro extends Grafo {

    private Vertice origem;
    private Vertice destino;

    private ArrayList<VerticeDjikstra> verticesMenorCaminho;

    public CalculoDeUmParaOutro(Grafo grafoOriginal, Vertice origem, Vertice destino) {
        this.arestas = grafoOriginal.getArestas();

        this.origem = origem;
        this.destino = destino;

        verticesMenorCaminho = new ArrayList<>();

        inicializarVertices();

        //gerarCaminho();
    }

    //private void relaxar(VerticeDjikstra origem, VerticeDjikstra, )

    private void inicializarVertices() {
        Vertice verticeOrigem;
        for (Vertice vertice : vertices) {
            VerticeDjikstra verticeNovo = new VerticeDjikstra(vertice.getNome(), null, 9999999);

            if (vertice.getNome().equals(this.origem.getNome())) {
                verticeNovo.setDistancia(0);
            }

            verticesMenorCaminho.add(verticeNovo);
        }
    }

    @Override
    public String toString() {
        return "nao implementado a tempo, desculpe";
    }
}