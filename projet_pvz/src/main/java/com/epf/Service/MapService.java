package com.epf.Service;

import com.epf.Persistance.MapDAOImp;
import com.epf.Persistance.Map;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MapService implements Service_MapDAO {

    private final MapDAOImp mapDAO;

    public MapService(MapDAOImp mapDAO) {
        this.mapDAO = mapDAO;
    }


    @Override
    public void create(Map map) {
        mapDAO.create(map);
    }

    @Override
    public void update(Map map) {
        mapDAO.update(map);
    }

    @Override
    public void delete(Map map) {
        mapDAO.delete(map);
    }

    @Override
    public Optional<Map> findById(int id) {
        return mapDAO.findById(id);
    }

    @Override
    public List<Map> findAll() {
        return mapDAO.findAll();
    }
}
