package grafo;

// Nathan Reikdal Cervieri
public class ArvoreGeradoraComInicial extends ArvoreGeradora {

    public ArvoreGeradoraComInicial(Grafo grafoOriginal) {
        super(grafoOriginal);

        ConjuntoAresta arestas = grafoOriginal.getArestas();
    }
}