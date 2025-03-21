package com.epf.Persistance;

public class Map {

    private int idMap;       // id_map (clé primaire, auto-incrémentée)
    private int ligne;       // ligne
    private int colonne;     // colonne
    private String cheminImage; // chemin_image

    // Constructeur sans idMap (utilisé lors de l'insertion)
    public Map(int ligne, int colonne, String cheminImage) {
        this.ligne = ligne;
        this.colonne = colonne;
        this.cheminImage = cheminImage;
    }

    // Constructeur avec idMap (utilisé lors de la récupération d'un enregistrement)
    public Map(int idMap, int ligne, int colonne, String cheminImage) {
        this.idMap = idMap;
        this.ligne = ligne;
        this.colonne = colonne;
        this.cheminImage = cheminImage;
    }

    // Getters et Setters
    public int getIdMap() {
        return idMap;
    }

    public void setIdMap(int idMap) {
        this.idMap = idMap;
    }

    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public String getCheminImage() {
        return cheminImage;
    }

    public void setCheminImage(String cheminImage) {
        this.cheminImage = cheminImage;
    }

    // Méthode toString pour afficher les données de la map
    @Override
    public String toString() {
        return "Map [idMap=" + idMap + ", ligne=" + ligne + ", colonne=" + colonne + ", cheminImage=" + cheminImage + "]";
    }
}