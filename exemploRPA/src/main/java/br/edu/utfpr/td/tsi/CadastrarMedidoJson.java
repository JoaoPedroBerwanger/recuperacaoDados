package br.edu.utfpr.td.tsi;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.io.FileReader;

public class CadastrarMedidoJson {

    private static final String url_pagina = "http://10.50.135.17:8080/clinica.medica/cadastrarMedico";

    public static void cadastrarMedicos(String caminhoArquivo){
        try (FileReader reader = new FileReader(caminhoArquivo)) {
            // Realiza o parsing do arquivo JSON usando o Gson
            JsonObject rootNode = JsonParser.parseReader(reader).getAsJsonObject();
            JsonArray dadosArray = rootNode.getAsJsonArray("dados");

            if (dadosArray == null || dadosArray.isJsonNull()) {
                System.err.println("Estruturação do JSON inválida: nó 'dados' não encontrado.");
                return;
            }

            // Inicializa o ambiente do Playwright
            try (Playwright playwright = Playwright.create()) {
                // Lança o navegador (setHeadless(false) permite ver o navegador preenchendo o form, mude para true se quiser oculto)
                Browser browser = playwright.chromium().launch(
                        new BrowserType.LaunchOptions().setHeadless(false)
                );

                Page page = browser.newPage();

                for (JsonElement elemento : dadosArray) {
                    JsonObject medicoNode = elemento.getAsJsonObject();

                    String nomeCompleto = medicoNode.has("NM_MEDICO") && !medicoNode.get("NM_MEDICO").isJsonNull()
                            ? medicoNode.get("NM_MEDICO").getAsString() : "";
                    String crmNumero = medicoNode.has("NU_CRM") && !medicoNode.get("NU_CRM").isJsonNull()
                            ? medicoNode.get("NU_CRM").getAsString() : "";
                    String uf = medicoNode.has("SG_UF") && !medicoNode.get("SG_UF").isJsonNull()
                            ? medicoNode.get("SG_UF").getAsString() : "PR";

                    if (nomeCompleto.isEmpty() || crmNumero.isEmpty()) {
                        continue;
                    }

                    // 1. Regra para o E-mail: primeironome-crm@medicos.com (em minúsculas)
                    String primeiroNome = nomeCompleto.trim().split("\\s+")[0].toLowerCase();
                    String email = primeiroNome + "-" + crmNumero + "@medicos.com";

                    // 2. Regra para o CPF: crm-crm-crm
                    String cpf = crmNumero + "-" + crmNumero + "-" + crmNumero;

                    // 3. Regra para o CRM: crm-sigla estado (Ex: 29278-GO)
                    String crmFormatado = crmNumero + "-" + uf;

                    // Navega até a página de cadastro para cada médico preencher o form do zero
                    page.navigate(url_pagina);

                    // Preenche os campos utilizando os seletores correspondentes ao formulário HTML
                    page.fill("input[name='nome']", nomeCompleto);
                    page.fill("input[name='email']", email);
                    page.fill("input[name='cpf']", cpf);
                    page.fill("input[name='crm']", crmFormatado);

                    // Seleciona o checkbox da especialidade padrão (CLINICA_MEDICA)
                    page.check("input[name='especialidades'][value='CLINICA_MEDICA']");

                    // Clica no botão de Salvar (ou submete o formulário)
                    page.click("button[type='submit']");

                    // Opcional: aguarda um breve momento para garantir o envio e processamento
                    page.waitForLoadState();

                    System.out.println("Médico cadastrado via Playwright: " + nomeCompleto + " | CRM: " + crmFormatado);
                }

                browser.close();
            }

            System.out.println("Processo de cadastro em lote finalizado com Playwright!");

        } catch (Exception e) {
            System.err.println("Erro ao processar o arquivo JSON ou automatizar o navegador: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        String caminhoJson = "dados/medicos-ro.json";

        cadastrarMedicos(caminhoJson);
    }
}
