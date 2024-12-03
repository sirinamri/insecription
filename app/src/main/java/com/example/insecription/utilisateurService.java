package com.example.insecription;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface utilisateurService {
    @POST("inscription")
    Call<Void> inscriptionUtilisateur(@Body Utilisateur user);
}