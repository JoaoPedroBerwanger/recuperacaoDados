package raspador.webbr.edu.utfpr.td.tsi.raspador.web;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class RaspadorHtml {

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

}
