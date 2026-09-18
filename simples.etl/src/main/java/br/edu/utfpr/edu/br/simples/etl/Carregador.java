package br.edu.utfpr.edu.br.simples.etl;

import java.util.List;

public abstract class Carregador<T> {

    public abstract void carregar(List<T> items);
}
