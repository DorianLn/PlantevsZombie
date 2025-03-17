import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.epf.Persistance.Effet;
import com.epf.Persistance.PlanteDAOImp;
import com.epf.Persistance.Plante;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class PlanteDAOImptest {

    @Mock
    private JdbcTemplate jdbcTemplate; // Mock du JdbcTemplate

    private PlanteDAOImp planteDao; // DAO à tester

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialisation des mocks
        planteDao = new PlanteDAOImp(jdbcTemplate); // Création du DAO avec le JdbcTemplate mocké
    }

    @Test
    public void testFindAll() {
        // Création d'une plante fictive pour simuler le résultat
        Plante planteMock = new Plante(1, "Plante1", 100, Double.valueOf(10.5), 20, 50, Double.valueOf(0.5), Effet.NORMAL, "tournesol.png");

        // Simulation du comportement du JdbcTemplate pour la requête
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(List.of(planteMock));

        // Appel de la méthode à tester
        List<Plante> result = planteDao.findAll();

        // Vérification du résultat
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Plante1", result.get(0).getNom());
        assertEquals(100, result.get(0).getPointDeVie());
        assertEquals(Effet.NORMAL, result.get(0).getEffet());

        // Vérifier que la méthode `query` du JdbcTemplate a bien été appelée
        verify(jdbcTemplate).query(anyString(), any(RowMapper.class));
    }
}
