package com.epf.Persistance.Interface_DAO;
import com.epf.Persistance.Zombie;
import java.util.List;
import java.util.Optional;

public interface ZombieDAO {

    // Créer un zombie
    Zombie create(Zombie zombie);

    // Récupérer tous les zombies
    List<Zombie> findAll();

    // Récupérer un zombie par son ID
    Optional<Zombie> findById(int id);

    // Mettre à jour un zombie
    Zombie update(Zombie zombie);

    // Supprimer un zombie
    void delete(Zombie zombie);

    // Récupérer tous les zombies associés à une carte
    List<Zombie> findByMapId(int mapId);
}

