package com.epf.Persistance.Interface_DAO;

import com.epf.Persistance.Plante;
import java.util.List;
import java.util.Optional;

public interface PlanteDAO {

    // Créer une plante
    Plante create(Plante plante);

    // Récupérer toutes les plantes
    List<Plante> findAll();

    // Récupérer une plante par son ID
    Optional<Plante> findById(int id);

    // Mettre à jour une plante
    Plante update(Plante plante);

    // Supprimer une plante
    void delete(Plante plante);
}

