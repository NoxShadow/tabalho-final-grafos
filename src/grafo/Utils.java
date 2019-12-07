package grafo;

import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.TreeSet;

public final class Utils {

    private Utils() {
    }

    static boolean arestaGeraCiclo(List<Vertice> vertices, Aresta aresta) {
        return vertices.contains(aresta.getVerticeOrigem()) && vertices.contains(aresta.getVerticeOrigem());
    }

    static Iterable<Aresta> ordenarArestas(Collection<Aresta> arestasNaoOrdenadas) {
        return new TreeSet<>(arestasNaoOrdenadas);
    }

}
