package com.epf.Persistance.Interface_DAO;


import com.epf.Persistance.Map;
import java.util.List;
import java.util.Optional;
import com.epf.Persistance.Zombie;

public interface MapDAO {

    // Créer une carte
    Map create(Map map);

    // Récupérer toutes les cartes
    List<Map> findAll();

    // Récupérer une carte par son ID
    Optional<Map> findById(int id);

    // Mettre à jour une carte
    Map update(Map map);

    // Supprimer une carte
    void delete(Map map);

    // Récupérer tous les zombies d'une carte
    List<Zombie> findZombiesByMap(int mapId);
}

