package br.edu.utfpr.edu.br.simples.etl;

import java.util.List;

public abstract class Extrator<T> {

    public abstract List<T> extrair();
}
