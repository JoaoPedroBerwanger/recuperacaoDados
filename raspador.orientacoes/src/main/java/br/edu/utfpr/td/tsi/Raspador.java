package br.edu.utfpr.td.tsi;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Element;

public class Raspador {

    public void rasparPagina() throws IOException {
        Document doc = Jsoup.connect("https://ivansalvadori.github.io/students.html").get();
        Elements divs = doc.select(".outline-3");
        divs.forEach(Element div -> {
            Sting nomeAluno = div.select

        });
    }
}
