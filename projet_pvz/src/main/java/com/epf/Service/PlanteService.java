package com.epf.Service;


import com.epf.Persistance.PlanteDAOImp;
import com.epf.Persistance.Plante;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanteService implements Service_PlanteDAO {

    private final PlanteDAOImp planteDAO;

    public PlanteService(PlanteDAOImp planteDAO) {
        this.planteDAO = planteDAO;
    }

    @Override
    public void create(Plante plante) {
        planteDAO.create(plante);
    }

    @Override
    public void update(Plante plante) {
        planteDAO.update(plante);
    }

    @Override
    public void delete(Plante plante) {
        planteDAO.delete(plante);
    }

    @Override
    public Optional<Plante> findById(int id) {
        return planteDAO.findById(id);
    }

    @Override
    public List<Plante> findAll() {
        return planteDAO.findAll();
    }
}
