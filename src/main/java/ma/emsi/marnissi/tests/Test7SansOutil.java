
package ma.emsi.marnissi.tests;

import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;

public class Test7SansOutil {

    public static void main(String[] args) {

        String apiKey = System.getenv("GEMINI_KEY");

        if (apiKey == null || apiKey.isBlank()) {
            System.err.println("Erreur : GEMINI_KEY est absente.");
            return;
        }

        // Gemini sans outil météo et sans mémoire préalable.
        GoogleGenAiChatModel model = GoogleGenAiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-3.5-flash-lite")
                .temperature(0.7)
                .build();

        String question =
                "Je pars à Paris pour trois jours. Dois-je prendre un parapluie ?";

        System.out.println("=== TEST 7 : SANS OUTIL METEO ===");
        System.out.println("Question : " + question);

        try {
            String reponse = model.chat(question);
            System.out.println("Réponse : " + reponse);

        } catch (RuntimeException e) {
            System.err.println(
                    "Erreur Gemini : " + e.getMessage()
            );
        }
    }
}
