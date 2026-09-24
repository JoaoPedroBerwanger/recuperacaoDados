package br.edu.utfpr.td.tsi.mongo;

import br.edu.utfpr.td.tsi.interfaces.Extrator;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public class MongoExtrator<T> extends Extrator<T> {

    private MongoTemplate mongoTemplate;
    Class<T> clazz;

    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<T> extrair() {
        return mongoTemplate.findAll(clazz);
    }
}
