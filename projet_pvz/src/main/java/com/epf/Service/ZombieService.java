package com.epf.Service;



import com.epf.Persistance.ZombieDAOImp;
import com.epf.Persistance.Zombie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZombieService implements Service_ZombieDAO {

    private final ZombieDAOImp zombieDAO;

    public ZombieService(ZombieDAOImp zombieDAO) {
        this.zombieDAO = zombieDAO;
    }

    @Override
    public void create(Zombie zombie) {
        zombieDAO.create(zombie);
    }

    @Override
    public void update(Zombie zombie) {
        zombieDAO.update(zombie);
    }

    @Override
    public void delete(Zombie zombie) {
        zombieDAO.delete(zombie);
    }

    @Override
    public Optional<Zombie> findById(int id) {
        return zombieDAO.findById(id);
    }

    @Override
    public List<Zombie> findAll() {
        return zombieDAO.findAll();
    }

    @Override
    public List<Zombie> findByMapId(int mapId) {
        return zombieDAO.findByMapId(mapId);
    }
}

