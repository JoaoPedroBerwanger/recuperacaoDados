package br.edu.utfpr.td.tsi;

public abstract class Transformador<I, O> {

    public abstract O transformar(I item);
}
