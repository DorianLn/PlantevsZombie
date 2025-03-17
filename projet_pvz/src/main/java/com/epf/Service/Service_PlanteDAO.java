package com.epf.Service;

import com.epf.Persistance.Plante;
import java.util.List;
import java.util.Optional;

public interface Service_PlanteDAO {
    void create(Plante plante);
    void update(Plante plante);
    void delete(Plante plante);
    Optional<Plante> findById(int id);
    List<Plante> findAll();
}
