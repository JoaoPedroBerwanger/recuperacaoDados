package br.edu.utfpr.edu.br;

import br.edu.utfpr.edu.br.simples.etl.Transformador;

import java.util.List;

public class meuTransformador extends Transformador<Medico, Medico> {

    @Override
    public Medico transformar(Medico o) {
        o.setNome(o.getNome() + "_Transformado");
        return o;
    }
}
