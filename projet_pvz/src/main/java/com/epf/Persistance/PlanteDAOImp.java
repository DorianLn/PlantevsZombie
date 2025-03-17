package com.epf.Persistance;

import com.epf.Persistance.Interface_DAO.PlanteDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Repository
public class PlanteDAOImp implements PlanteDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PlanteDAOImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Plante create(Plante plante) {
        String sql = "INSERT INTO Plante (nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, plante.getNom(), plante.getPointDeVie(), plante.getAttaqueParSeconde(), plante.getDegatAttaque(),
                plante.getCout(), plante.getSoleilParSeconde(), plante.getEffet().toString(), plante.getCheminImage());
        return plante;
    }

    @Override
    public List<Plante> findAll() {
        String sql = "SELECT * FROM Plante";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            // Récupère la valeur de "effet" en tant que String
            String effetString = rs.getString("effet");
            // Convertir ce String en valeur de l'enum Effet
            Effet effet = Effet.fromString(effetString);

        return new Plante(
                rs.getInt("id_plante"),
                rs.getString("nom"),
                rs.getInt("point_de_vie"),
                rs.getDouble("attaque_par_seconde"),
                rs.getInt("degat_attaque"),
                rs.getInt("cout"),
                rs.getDouble("soleil_par_seconde"),
                effet,
                rs.getString("chemin_image")
        );
        });
    }

    @Override
    public Optional<Plante> findById(int id) {
        String sql = "SELECT * FROM Plante WHERE id_plante = ?";
        Plante plante = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            // Récupère la valeur de "effet" en tant que String
            String effetString = rs.getString("effet");
            // Convertir ce String en valeur de l'enum Effet
            Effet effet = Effet.fromString(effetString);
            return new Plante(
                    rs.getInt("id_plante"),
                    rs.getString("nom"),
                    rs.getInt("point_de_vie"),
                    rs.getDouble("attaque_par_seconde"),
                    rs.getInt("degat_attaque"),
                    rs.getInt("cout"),
                    rs.getDouble("soleil_par_seconde"),
                    effet,
                    rs.getString("chemin_image")
            );
        }, id);
        return Optional.ofNullable(plante);

    }

    @Override
    public Plante update(Plante plante) {
        String sql = "UPDATE Plante SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, cout = ?, soleil_par_seconde = ?, effet = ?, chemin_image = ? WHERE id_plante = ?";
        jdbcTemplate.update(sql, plante.getNom(), plante.getPointDeVie(), plante.getAttaqueParSeconde(), plante.getDegatAttaque(),
                plante.getCout(), plante.getSoleilParSeconde(), plante.getEffet().toString(), plante.getCheminImage(), plante.getIdPlante());
        return plante;
    }

    @Override
    public void delete(Plante plante) {
        String sql = "DELETE FROM Plante WHERE id_plante = ?";
        jdbcTemplate.update(sql, plante.getIdPlante());
    }
}