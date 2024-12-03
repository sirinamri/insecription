package com.example.insecription;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class apis {

    private static final String BASE_URL = "http://192.168.25.229:8084/api/utilisateurs/";  // Note the added "/utilisateurs/"  // URL de votre backend Spring Boot

    private static Retrofit retrofit;

    // Méthode pour obtenir une instance du service utilisateur
    public static utilisateurService getService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)  // Point de base de l'API
                    .addConverterFactory(GsonConverterFactory.create())  // Utilisation de Gson pour convertir les objets JSON
                    .build();
        }
        return retrofit.create(utilisateurService.class);  // Crée l'interface utilisateurService
    }
}
