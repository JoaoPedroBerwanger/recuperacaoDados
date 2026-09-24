package br.edu.utfpr.td.tsi.mongo;

import br.edu.utfpr.td.tsi.interfaces.Carregador;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public class MongoCarregador<T> extends Carregador<T> {

    private MongoTemplate mongoTemplate;

    public void SetMongoTemplate(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void carregar(List<T> lista) {
        lista.forEach(item -> mongoTemplate.save(item));
    }
}
