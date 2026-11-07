
package ma.emsi.marnissi.tests;

import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;

public class Test1 {

    public static void main(String[] args) {

        // Récupérer la clé API Gemini.
        String apiKey = System.getenv("GEMINI_KEY");

        if (apiKey == null || apiKey.isBlank()) {
            System.err.println("Erreur : la variable GEMINI_KEY est absente.");
            return;
        }

        // Créer le modèle Gemini avec LangChain4j.
        GoogleGenAiChatModel model = GoogleGenAiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-3.5-flash")
                .temperature(0.7)
                .build();

        // Première question : présentation.
        String question1 = "Bonjour, je m'appelle Nada.";
        String reponse1 = model.chat(question1);

        // Deuxième question : vérifier si Gemini se souvient du nom.
        String question2 = "Comment je m'appelle ?";
        String reponse2 = model.chat(question2);

        // Afficher les deux échanges.
        System.out.println("Question 1 : " + question1);
        System.out.println("Réponse 1 : " + reponse1);

        System.out.println();

        System.out.println("Question 2 : " + question2);
        System.out.println("Réponse 2 : " + reponse2);
    }
}
