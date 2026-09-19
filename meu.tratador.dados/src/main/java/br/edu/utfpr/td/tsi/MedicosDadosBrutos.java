package br.edu.utfpr.td.tsi;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dados-brutos")
public class MedicosDadosBrutos {

    @Id
    private String id;

}
