package com.example.insecription;


    public class Utilisateur {
        private String nom;
        private String prenom;
        private String email;
        private String motDePasse; // Note: changed from 'password' to 'motDePasse'
        private String role;
        private Boolean isValidated;

        public Utilisateur(String nom, String prenom, String email, String motDePasse, String role, Boolean isValidated) {
            this.nom = nom;
            this.prenom = prenom;
            this.email = email;
            this.motDePasse = motDePasse;
            this.role = role;
            this.isValidated = isValidated;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public String getPrenom() {
            return prenom;
        }

        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMotDePasse() {
            return motDePasse;
        }

        public void setMotDePasse(String motDePasse) {
            this.motDePasse = motDePasse;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public Boolean getValidated() {
            return isValidated;
        }

        public void setValidated(Boolean validated) {
            isValidated = validated;
        }
    }



