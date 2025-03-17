package com.epf.Persistance;

public class Zombie {

    private int idZombie;            // id_zombie (clé primaire)
    private String nom;              // nom
    private int pointDeVie;          // point_de_vie
    private double attaqueParSeconde; // attaque_par_seconde
    private int degatAttaque;        // degat_attaque
    private double vitesseDeplacement; // vitesse_de_deplacement
    private String cheminImage;      // chemin_image
    private int idMap;               // Référence vers la table Map (clé étrangère)

    // Constructeur sans idZombie (pour insertion)
    public Zombie(String nom, int pointDeVie, double attaqueParSeconde, int degatAttaque, double vitesseDeplacement, String cheminImage, int idMap) {
        this.nom = nom;
        this.pointDeVie = pointDeVie;
        this.attaqueParSeconde = attaqueParSeconde;
        this.degatAttaque = degatAttaque;
        this.vitesseDeplacement = vitesseDeplacement;
        this.cheminImage = cheminImage;
        this.idMap = idMap;
    }

    // Constructeur avec idZombie (pour récupération)
    public Zombie(int idZombie, String nom, int pointDeVie, double attaqueParSeconde, int degatAttaque, double vitesseDeplacement, String cheminImage, int idMap) {
        this.idZombie = idZombie;
        this.nom = nom;
        this.pointDeVie = pointDeVie;
        this.attaqueParSeconde = attaqueParSeconde;
        this.degatAttaque = degatAttaque;
        this.vitesseDeplacement = vitesseDeplacement;
        this.cheminImage = cheminImage;
        this.idMap = idMap;
    }

    // Getters et Setters
    public int getIdZombie() {
        return idZombie;
    }

    public void setIdZombie(int idZombie) {
        this.idZombie = idZombie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPointDeVie() {
        return pointDeVie;
    }

    public void setPointDeVie(int pointDeVie) {
        this.pointDeVie = pointDeVie;
    }

    public double getAttaqueParSeconde() {
        return attaqueParSeconde;
    }

    public void setAttaqueParSeconde(double attaqueParSeconde) {
        this.attaqueParSeconde = attaqueParSeconde;
    }

    public int getDegatAttaque() {
        return degatAttaque;
    }

    public void setDegatAttaque(int degatAttaque) {
        this.degatAttaque = degatAttaque;
    }

    public double getVitesseDeplacement() {
        return vitesseDeplacement;
    }

    public void setVitesseDeplacement(double vitesseDeplacement) {
        this.vitesseDeplacement = vitesseDeplacement;
    }

    public String getCheminImage() {
        return cheminImage;
    }

    public void setCheminImage(String cheminImage) {
        this.cheminImage = cheminImage;
    }

    public int getIdMap() {
        return idMap;
    }

    public void setIdMap(int idMap) {
        this.idMap = idMap;
    }

    // Méthode toString pour affichage
    @Override
    public String toString() {
        return "Zombie [idZombie=" + idZombie + ", nom=" + nom + ", pointDeVie=" + pointDeVie +
                ", attaqueParSeconde=" + attaqueParSeconde + ", degatAttaque=" + degatAttaque +
                ", vitesseDeplacement=" + vitesseDeplacement + ", cheminImage=" + cheminImage +
                ", idMap=" + idMap + "]";
    }
}
