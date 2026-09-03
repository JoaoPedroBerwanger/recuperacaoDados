package br.edu.utfpr.td.tsi;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }

    @PostConstruct
    public void executarExemploJsoup() throws IOException {
        new Raspador().rasparPaginaAlunos();
    }

}
