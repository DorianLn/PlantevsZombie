import com.epf.Persistance.Map;
import com.epf.Persistance.MapDAOImp;

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

class MapDAOImpltest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private MapDAOImp mapDAO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreate() {
        Map map = new Map(1, 2, 3, "chemin/image.png");
        when(jdbcTemplate.update(anyString(), anyInt(), anyInt(), anyString())).thenReturn(1);

        mapDAO.create(map);

        verify(jdbcTemplate, times(1)).update(anyString(), anyInt(), anyInt(), anyString());
    }

    @Test
    void testFindById() {
        Map map = new Map(1, 2, 3, "chemin/image.png");
        when(jdbcTemplate.queryForObject(anyString(), any(RowMapper.class), eq(1))).thenReturn(map);

        Optional<Map> result = mapDAO.findById(1);

        assertTrue(result.isPresent());
        assertEquals(map, result.get());
    }

    @Test
    void testFindAll() {
        List<Map> maps = Arrays.asList(
                new Map(1, 2, 3, "chemin1.png"),
                new Map(2, 4, 5, "chemin2.png")
        );
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(maps);

        List<Map> result = mapDAO.findAll();

        assertEquals(2, result.size());
    }

    @Test
    void testUpdate() {
        Map map = new Map(1, 2, 3, "nouveau_chemin.png");
        when(jdbcTemplate.update(anyString(), anyInt(), anyInt(), anyString())).thenReturn(1);

        mapDAO.update(map);

        verify(jdbcTemplate, times(1)).update(anyString(), anyInt(), anyInt(), anyString(), anyInt());
    }

    @Test
    void testDelete() {
        when(jdbcTemplate.update(anyString(), anyInt(), anyInt(), anyString())).thenReturn(1);

        Map map = new Map(1, 2, 3, "nouveau_chemin.png");
        mapDAO.delete(map);

        verify(jdbcTemplate, times(1)).update(anyString(), anyInt());
    }
}
