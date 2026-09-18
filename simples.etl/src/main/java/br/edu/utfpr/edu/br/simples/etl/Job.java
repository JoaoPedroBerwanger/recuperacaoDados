package br.edu.utfpr.edu.br.simples.etl;

import java.util.List;

public class Job<T> {

    private Extrator extrator;
    private Transformador transformador;
    private Carregador carregador;

    public void setExtrator(Extrator extrator) {
        this.extrator = extrator;
    }

    public void setTransformador(Transformador transformador) {
        this.transformador = transformador;
    }

    public void setCarregador(Carregador carregador) {
        this.carregador = carregador;
    }

    public void executar() {
        List<T> dados = extrator.extrair();

        for (T item : dados) {
            transformador.transformar(dados);
        }

        carregador.carregar(dados);
    }
}
