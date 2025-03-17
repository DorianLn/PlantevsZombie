
import com.epf.Persistance.ZombieDAOImp;
import com.epf.Persistance.Zombie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ZombieDAOImptest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private ZombieDAOImp zombieDAO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreate() {
        Zombie zombie = new Zombie(1, "ZombieTest", 100, 1.5, 10, 0.5, "chemin/image.png", 1);
        when(jdbcTemplate.update(anyString(), anyInt(), anyInt(), anyString())).thenReturn(1);
        zombieDAO.create(zombie);

        verify(jdbcTemplate, times(1)).update(anyString(), anyString(), anyInt(), anyDouble(), anyInt(), anyDouble(), anyString(), anyInt());
    }

    @Test
    void testFindById() {
        Zombie zombie = new Zombie(1, "ZombieTest", 100, 1.5, 10, 0.5, "chemin/image.png", 1);
        when(jdbcTemplate.queryForObject(anyString(), any(RowMapper.class), eq(1))).thenReturn(zombie);

        Optional<Zombie> result = zombieDAO.findById(1);

        assertTrue(result.isPresent());
        assertEquals(zombie, result.get());
    }

    @Test
    void testFindAll() {
        List<Zombie> zombies = Arrays.asList(
                new Zombie(1, "Zombie1", 100, 1.5, 10, 0.5, "chemin1.png", 1),
                new Zombie(2, "Zombie2", 120, 1.0, 15, 0.4, "chemin2.png", 2)
        );
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(zombies);

        List<Zombie> result = zombieDAO.findAll();

        assertEquals(2, result.size());
    }

    @Test
    void testGetByMapId() {
        List<Zombie> zombies = Arrays.asList(
                new Zombie(1, "Zombie1", 100, 1.5, 10, 0.5, "chemin1.png", 1),
                new Zombie(2, "Zombie2", 120, 1.0, 15, 0.4, "chemin2.png", 1)
        );
        when(jdbcTemplate.query(anyString(), any(RowMapper.class), eq(1))).thenReturn(zombies);

        List<Zombie> result = zombieDAO.findByMapId(1);

        assertEquals(2, result.size());
    }

    @Test
    void testUpdate() {
        Zombie zombie = new Zombie(1, "ZombieTest", 150, 2.0, 20, 0.6, "nouveau_chemin.png", 2);
        when(jdbcTemplate.update(anyString(), anyInt(), anyInt(), anyString())).thenReturn(1);
        zombieDAO.update(zombie);

        verify(jdbcTemplate, times(1)).update(anyString(), anyString(), anyInt(), anyDouble(), anyInt(), anyDouble(), anyString(), anyInt(), anyInt());
    }

    @Test
    void testDelete() {
        when(jdbcTemplate.update(anyString(), anyInt(), anyInt(), anyString())).thenReturn(1);
        Zombie zombie = new Zombie(1, "ZombieTest", 150, 2.0, 20, 0.6, "nouveau_chemin.png", 2);
        zombieDAO.delete(zombie);

        verify(jdbcTemplate, times(1)).update(anyString(), anyInt());
    }
}
