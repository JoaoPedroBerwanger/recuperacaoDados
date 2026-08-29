package raspador.webbr.edu.utfpr.td.tsi.raspador.web;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RaspadorHtml {

	Logger logger = LoggerFactory.getLogger(RaspadorHtml.class);

	public void rasparPaginaExemplo() throws IOException {
		Document doc = Jsoup.connect("https://en.wikipedia.org/").get();
		System.out.println(doc.title());
		Elements newsHeadlines = doc.select("#mp-itn b a");
		for (Element headline : newsHeadlines) {
			System.out.println(String.format("%s\n\t%s", headline.attr("title"), headline.absUrl("href")));
		}
	}

	public void rasparPaginaProfessor() throws IOException {
		Document doc = Jsoup.connect("https://ivansalvadori.github.io/about.html").get();
		System.out.println(doc.title());
		Elements paragrafos = doc.select("p");
		String bio = paragrafos.get(1).html();
		System.out.println("Biografia: " + bio);

		Elements researchInterest = doc.select("#text-1 li");
		System.out.println("Os interesses depesquisa são: ");
		for (Element element : researchInterest) {
			System.out.println(element.html());
		}

		Elements education = doc.select("#text-2 li");
		System.out.println("Formação acadêmica: ");
		for (Element element : education) {
			System.out.println(element.html());
		}
	}

	public void rasparPaginaAlunos() throws IOException {
		Document doc = Jsoup.connect("https://ivansalvadori.github.io/students.htmls").get();
		System.out.println(doc.title());
		System.out.println();

		Elements alunos = doc.select(".outline-3");
		for (Element aluno : alunos) {
			String nome = aluno.select("h3").text().split(" ")[1].trim();
			String sobrenome = aluno.select("h3").text().split(" ")[2].trim();
			System.out.println("Nome: " + nome + " " + sobrenome);

			Elements tags = aluno.select(".tag span");
			System.out.println("Status: ");
			for (Element tag : tags) {
				System.out.println(tag.html() + " ");
			}

			Elements items = aluno.select(".outline-text-3 ul li");
			for (Element item : items) {
				System.out.println(item.html());
			}
			System.out.println();
			System.out.println("**********");
			System.out.println();
		}
	}

}
