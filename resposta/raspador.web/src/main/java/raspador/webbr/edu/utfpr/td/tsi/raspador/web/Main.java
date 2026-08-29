package raspador.webbr.edu.utfpr.td.tsi.raspador.web;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

	}

	@PostConstruct
	public void executarExemploJsoup() throws IOException {
		new RaspadorHtml().rasparPaginaAlunos();
	}

}