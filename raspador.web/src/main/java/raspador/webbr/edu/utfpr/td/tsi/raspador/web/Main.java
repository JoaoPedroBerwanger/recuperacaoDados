package raspador.webbr.edu.utfpr.td.tsi.raspador.web;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class Main {

	private Gson gson = new GsonBuilder().setPrettyPrinting().create();

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

	}

	@PostConstruct
	public void executarExemploJsoup() throws IOException {
		new RaspadorHtml().rasparPaginaProfessor();
	}

}