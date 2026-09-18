package br.edu.utfpr.edu.br.simples.etl;

public abstract class Transformador<I, O> {

    public abstract O transformar(I item);
}
