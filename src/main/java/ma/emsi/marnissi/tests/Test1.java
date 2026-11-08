
package ma.emsi.marnissi.tests;

import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;

public class Test1 {

    public static void main(String[] args) {

        // Récupération de la clé API Gemini.
        String apiKey = System.getenv("GEMINI_KEY");

        if (apiKey == null || apiKey.isBlank()) {
            System.err.println("Erreur : la variable GEMINI_KEY est absente.");
            return;
        }

        // Création du modèle Gemini avec LangChain4j.
        GoogleGenAiChatModel model = GoogleGenAiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-3.5-flash")
                .temperature(0.7)
                .build();

        // Test sans RAG : Gemini ne possède pas les informations privées.
        String question = "Comment s'appelle le chat de Pierre ?";

        String reponse = model.chat(question);

        System.out.println("=== TEST 5 : SANS RAG ===");
        System.out.println("Question : " + question);
        System.out.println("Réponse : " + reponse);
    }
}
