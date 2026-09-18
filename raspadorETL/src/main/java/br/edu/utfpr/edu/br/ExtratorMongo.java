package br.edu.utfpr.edu.br;

import br.edu.utfpr.edu.br.simples.etl.Extrator;

import java.util.ArrayList;
import java.util.List;

public class ExtratorMongo extends Extrator {

    @Override
    public List extrair() {
        List<Medico> medicos = new ArrayList<>();
        medicos.add(new Medico("Joao", "092458444919"));
        medicos.add(new Medico("Maria", "02772318923"));

        return medicos;
    }
}
