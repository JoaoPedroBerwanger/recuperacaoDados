package br.edu.utfpr.td.tsi;

import java.util.ArrayList;
import java.util.List;

public class Job<T, O> {

    private Extrator<T> extrator;
    private Transformador<T, O> transformador;
    private Carregador<O> carregador;

    public void executar() {
        List<O> dadosTransformados = new ArrayList<>();
        List<T> listaDadosBrutos = extrator.extrair();

        for (T dadosBruto : listaDadosBrutos) {
            O dadoTransformado = transformador.transformar(dadosBruto);
            dadosTransformados.add(dadoTransformado);
        }

        carregador.carregar(dadosTransformados);
    }
}
