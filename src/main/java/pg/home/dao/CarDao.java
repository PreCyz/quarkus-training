package pg.home.dao;

import pg.home.entities.CarEntity;
import java.util.List;

public interface CarDao {
    List<CarEntity> findAll();
    CarEntity save(CarEntity carEntity);
}
