package com.example.insecription;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InscriptionActivity extends AppCompatActivity {

    private EditText etNom, etPrenom, etEmail, etPassword, etRole;
    private CheckBox cbValidated;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        etNom = findViewById(R.id.nom_input);
        etPrenom = findViewById(R.id.prenom_input);
        etEmail = findViewById(R.id.email_input);
        etPassword = findViewById(R.id.password_input);
        etRole = findViewById(R.id.role_input);
        cbValidated = findViewById(R.id.validated_checkbox);
        btnSubmit = findViewById(R.id.submit_button);

        btnSubmit.setOnClickListener(v -> inscrireUtilisateur());
    }

    private void inscrireUtilisateur() {
        String nom = etNom.getText().toString();
        String prenom = etPrenom.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        String role = etRole.getText().toString();
        boolean isValidated = cbValidated.isChecked();

        // Construire un utilisateur avec les données saisies
        Utilisateur user = new Utilisateur(nom, prenom, email, password, role, isValidated);

        // Appeler le backend via Retrofit
        utilisateurService service = apis.getService();
        Call<Void> call = service.inscriptionUtilisateur(user);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    // Afficher un AlertDialog de succès
                    showSuccessAlert();
                } else {
                    // Gérer les erreurs
                    try {
                        String errorBody = response.errorBody() != null ? response.errorBody().string() : "Erreur inconnue";
                        showErrorAlert(errorBody);
                    } catch (IOException e) {
                        e.printStackTrace();
                        showErrorAlert("Erreur de traitement");
                    }
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                showErrorAlert("Erreur de connexion: " + t.getMessage());
            }
        });
    }

    private void showSuccessAlert() {
        new AlertDialog.Builder(this)
                .setTitle("Inscription Réussie")
                .setMessage("Votre compte a été créé avec succès!")
                .setPositiveButton("OK", (dialog, which) -> {
                    // Fermer l'activité après avoir cliqué sur OK
                    finish();
                })
                .setCancelable(false)
                .show();
    }

    private void showErrorAlert(String message) {
        new AlertDialog.Builder(this)
                .setTitle("Erreur d'Inscription")
                .setMessage(message)
                .setPositiveButton("Réessayer", null)
                .show();
    }
}