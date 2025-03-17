package com.epf.Persistance;

import com.epf.Persistance.Interface_DAO.ZombieDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Repository
public class ZombieDAOImp implements ZombieDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ZombieDAOImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Zombie create(Zombie zombie) {
        String sql = "INSERT INTO Zombie (nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image, id_map) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, zombie.getNom(), zombie.getPointDeVie(), zombie.getAttaqueParSeconde(),
                zombie.getDegatAttaque(), zombie.getVitesseDeplacement(), zombie.getCheminImage(), zombie.getIdMap());
        return zombie;
    }

    @Override
    public List<Zombie> findAll() {
        String sql = "SELECT * FROM Zombie";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Zombie(
                rs.getInt("id_zombie"),
                rs.getString("nom"),
                rs.getInt("point_de_vie"),
                rs.getDouble("attaque_par_seconde"),
                rs.getInt("degat_attaque"),
                rs.getDouble("vitesse_de_deplacement"),
                rs.getString("chemin_image"),
                rs.getInt("id_map")
        ));
    }

    @Override
    public Optional<Zombie> findById(int id) {
        String sql = "SELECT * FROM Zombie WHERE id_zombie = ?";
        Zombie zombie = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new Zombie(
                rs.getInt("id_zombie"),
                rs.getString("nom"),
                rs.getInt("point_de_vie"),
                rs.getDouble("attaque_par_seconde"),
                rs.getInt("degat_attaque"),
                rs.getDouble("vitesse_de_deplacement"),
                rs.getString("chemin_image"),
                rs.getInt("id_map")
        ), id);
        return Optional.ofNullable(zombie);
    }

    @Override
    public Zombie update(Zombie zombie) {
        String sql = "UPDATE Zombie SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, vitesse_de_deplacement = ?, chemin_image = ?, id_map = ? WHERE id_zombie = ?";
        jdbcTemplate.update(sql, zombie.getNom(), zombie.getPointDeVie(), zombie.getAttaqueParSeconde(),
                zombie.getDegatAttaque(), zombie.getVitesseDeplacement(), zombie.getCheminImage(), zombie.getIdMap(), zombie.getIdZombie());
        return zombie;
    }

    @Override
    public void delete(Zombie zombie) {
        String sql = "DELETE FROM Zombie WHERE id_zombie = ?";
        jdbcTemplate.update(sql, zombie.getIdZombie());
    }

    @Override
    public List<Zombie> findByMapId(int mapId) {
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
