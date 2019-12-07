package controller;

import grafo.ArvoreGeradora;
import grafo.Grafo;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// Nathan Reikdal Cervieri
public class GrafoController {

    private Grafo grafo;

    private String nomeVerticeOrigemObjetivo;
    private String nomeVerticeDestinoObjetivo;

    public void processarDadosEntrada() throws IllegalArgumentException, IOException {
        this.grafo = new Grafo();

        String conteudo = buscarConteudoEntrada().replace(',', '.');

        String[] conjuntosVerticeValor = conteudo.split("\r\n");

        if (conjuntosVerticeValor.length == 0) {
            throw new IllegalArgumentException("Existe um problema na formatação do arquivo (é necessário separar as linhas");
        }

        processarConjuntosVerticeValor(conjuntosVerticeValor);
    }

    public String gerarArvoreGeradora() {
        if(this.grafo != null) {
            ArvoreGeradora arvore = new ArvoreGeradora(grafo.clone());

            return arvore.toString();
        } else {
            return "Por favor, faça o carregamento dos dados iniciais";
        }
    }

    private void processarConjuntosVerticeValor(@NotNull String[] conjuntosVerticeValor) {
        final int posicaoValoresObjetivo = 0;

        processarVerticesObjetivo(conjuntosVerticeValor[posicaoValoresObjetivo]);

        for (int i = posicaoValoresObjetivo + 1; i < conjuntosVerticeValor.length; i++) {
            String conjunto = conjuntosVerticeValor[i];

            String[] valores = conjunto.split(" ");

            try {
                processarConjunto(valores);
            } catch (IllegalArgumentException iae) {
                throw new IllegalArgumentException("Eram esperado três valores separados por espaço, mas foram encontrados: " + valores.length + " , na linha " + (i + 1) + " do arquivo de entrada.");
            } catch (Exception e) {
                throw new RuntimeException("Foi encontrado um erro ao processar as informações da linha " + (i + 1));
            }
        }

    }

    private void processarVerticesObjetivo(@NotNull String conjuntoVertices) {
        String[] vertices = conjuntoVertices.split(" ");

        if (vertices.length != 2) {
            throw new IllegalArgumentException("Primeira linha do arquivo não está formatada corretamente, esperado valores de vértice inicial e final");
        }

        nomeVerticeOrigemObjetivo = vertices[0];
        nomeVerticeDestinoObjetivo = vertices[1];
    }

    private void processarConjunto(@NotNull String[] valores) {
        if(valores.length != 3) {
            throw new IllegalArgumentException();
        }

        String nomeVerticeOrigem = valores[0];
        String nomeVerticeDestino = valores[1];
        double valor = Double.parseDouble(valores[2]);

        grafo.adicionarAresta(nomeVerticeOrigem, nomeVerticeDestino, valor);
    }

    private String buscarConteudoEntrada() throws IOException {
        final String caminhoArquivoEntrada = "c:\\temp\\entrada.in";

        return new String(Files.readAllBytes(Paths.get(caminhoArquivoEntrada)));
    }

}
