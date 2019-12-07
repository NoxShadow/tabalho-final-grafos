package grafo;

// Nathan Reikdal Cervieri
public class VerticeDjikstra extends Vertice {
    private double distancia;
    private Vertice pai;

    private VerticeDjikstra(String nome) {
        super(nome);
    }

    public VerticeDjikstra(String nome, Vertice pai, double distancia) {
        this(nome);

        this.pai = pai;
        this.distancia = distancia;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public Vertice getPai() {
        return pai;
    }

    public void setPai(Vertice pai) {
        this.pai = pai;
    }
}