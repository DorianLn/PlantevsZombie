package com.epf.Persistance;

import com.epf.Persistance.Interface_DAO.MapDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Repository
public class MapDAOImp implements MapDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public MapDAOImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Map create(Map map) {
        // Requête SQL pour insérer une nouvelle carte dans la base de données
        String sql = "INSERT INTO Map (ligne, colonne, chemin_image) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, map.getLigne(), map.getColonne(), map.getCheminImage());
        return map;
    }

    @Override
    public List<Map> findAll() {
        // Requête SQL pour récupérer toutes les cartes
        String sql = "SELECT * FROM Map";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Map(
                rs.getInt("id_map"),
                rs.getInt("ligne"),
                rs.getInt("colonne"),
                rs.getString("chemin_image")
        ));
    }

    @Override
    public Optional<Map> findById(int id) {
        // Requête SQL pour récupérer une carte par son ID
        String sql = "SELECT * FROM Map WHERE id_map = ?";
        Map map = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new Map(
                rs.getInt("id_map"),
                rs.getInt("ligne"),
                rs.getInt("colonne"),
                rs.getString("chemin_image")
        ), id);
        return Optional.ofNullable(map);
    }

    @Override
    public Map update(Map map) {
        // Requête SQL pour mettre à jour une carte existante
        String sql = "UPDATE Map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map = ?";
        jdbcTemplate.update(sql, map.getLigne(), map.getColonne(), map.getCheminImage(), map.getIdMap());
        return map;
    }

    @Override
    public void delete(Map map) {
        // Requête SQL pour supprimer une carte
        String sql = "DELETE FROM Map WHERE id_map = ?";
        jdbcTemplate.update(sql, map.getIdMap());
    }

    @Override
    public List<Zombie> findZombiesByMap(int mapId) {
        // Requête SQL pour récupérer les zombies associés à une carte
        String sql = "SELECT * FROM Zombie WHERE id_map = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Zombie(
                rs.getInt("id_zombie"),
                rs.getString("nom"),
                rs.getInt("point_de_vie"),
                rs.getDouble("attaque_par_seconde"),
                rs.getInt("degat_attaque"),
                rs.getDouble("vitesse_de_deplacement"),
                rs.getString("chemin_image"),
                rs.getInt("id_map")
        ), mapId);
    }
}
