package pg.home.dao;

import pg.home.entities.CarEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
class CarRepository implements CarDao {

    final EntityManager entityManager;

    @Inject
    public CarRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<CarEntity> findAll() {
        return entityManager.createQuery("from CarEntity a", CarEntity.class).getResultList();
    }

    @Override
    @Transactional
    public CarEntity save(CarEntity carEntity) {
        entityManager.persist(carEntity);
        return carEntity;
    }
}
