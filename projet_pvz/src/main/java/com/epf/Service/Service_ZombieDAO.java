package com.epf.Service;

import com.epf.Persistance.Zombie;
import java.util.List;
import java.util.Optional;

public interface Service_ZombieDAO {
    void create(Zombie zombie);
    void update(Zombie zombie);
    void delete(Zombie zombie);
    Optional<Zombie> findById(int id);
    List<Zombie> findAll();
    List<Zombie> findByMapId(int mapId); // Méthode spécifique liée aux cartes
}
