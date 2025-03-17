package com.epf.Persistance;

public class Plante {

    private int idPlante;
    private String nom;
    private int pointDeVie;
    private double attaqueParSeconde;
    private int degatAttaque;
    private int cout;
    private double soleilParSeconde;
    private Effet effet; // Utilisation de l'enum
    private String cheminImage;

    // Constructeur sans idPlante (pour insertions)
    public Plante(String nom, int pointDeVie, double attaqueParSeconde, int degatAttaque, int cout, double soleilParSeconde, Effet effet, String cheminImage) {
        this.nom = nom;
        this.pointDeVie = pointDeVie;
        this.attaqueParSeconde = attaqueParSeconde;
        this.degatAttaque = degatAttaque;
        this.cout = cout;
        this.soleilParSeconde = soleilParSeconde;
        this.effet = effet;
        this.cheminImage = cheminImage;
    }

    // Constructeur avec idPlante (pour récupération depuis la base)
    public Plante(int idPlante, String nom, int pointDeVie, double attaqueParSeconde, int degatAttaque, int cout, double soleilParSeconde, Effet effet, String cheminImage) {
        this.idPlante = idPlante;
        this.nom = nom;
        this.pointDeVie = pointDeVie;
        this.attaqueParSeconde = attaqueParSeconde;
        this.degatAttaque = degatAttaque;
        this.cout = cout;
        this.soleilParSeconde = soleilParSeconde;
        this.effet = effet;
        this.cheminImage = cheminImage;
    }

    // Getters et Setters
    public Effet getEffet() {
        return effet;
    }

    public void setEffet(Effet effet) {
        this.effet = effet;
    }

    // Conversion effet -> String (pour interaction avec la base)
    public String getEffetAsString() {
        return effet.getValue();
    }

    public int getIdPlante() {
        return idPlante;
    }

    public String getNom() {
        return nom;
    }

    public int getPointDeVie() {
        return pointDeVie;
    }

    public double getAttaqueParSeconde() {
        return attaqueParSeconde;
    }

    public int getDegatAttaque() {
        return degatAttaque;
    }

    public int getCout() {
        return cout;
    }

    public double getSoleilParSeconde() {
        return soleilParSeconde;
    }

    public String getCheminImage() {
        return cheminImage;
    }

    public void setIdPlante(int idPlante) {
        this.idPlante = idPlante;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPointDeVie(int pointDeVie) {
        this.pointDeVie = pointDeVie;
    }

    public void setAttaqueParSeconde(double attaqueParSeconde) {
        this.attaqueParSeconde = attaqueParSeconde;
    }

    public void setDegatAttaque(int degatAttaque) {
        this.degatAttaque = degatAttaque;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public void setSoleilParSeconde(double soleilParSeconde) {
        this.soleilParSeconde = soleilParSeconde;
    }

    public void setCheminImage(String cheminImage) {
        this.cheminImage = cheminImage;
    }

    // toString pour affichage
    @Override
    public String toString() {
        return "Plante [idPlante=" + idPlante + ", nom=" + nom + ", pointDeVie=" + pointDeVie +
                ", attaqueParSeconde=" + attaqueParSeconde + ", degatAttaque=" + degatAttaque +
                ", cout=" + cout + ", soleilParSeconde=" + soleilParSeconde +
                ", effet=" + effet + ", cheminImage=" + cheminImage + "]";
    }
}
