package com.epf.Persistance;

public enum Effet {
    NORMAL("normal"),
    SLOW_LOW("slow low"),
    SLOW_MEDIUM("slow medium"),
    SLOW_STOP("slow stop");

    private final String value;

    Effet(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    // Permet de retrouver l'ENUM depuis une chaîne de caractères (ex: depuis la base de données)
    public static Effet fromString(String text) {
        for (Effet effet : Effet.values()) {
            if (effet.value.equalsIgnoreCase(text)) {
                return effet;
            }
        }
        throw new IllegalArgumentException("Aucun effet correspondant à : " + text);
    }

    @Override
    public String toString() {
        return value;
    }
}
