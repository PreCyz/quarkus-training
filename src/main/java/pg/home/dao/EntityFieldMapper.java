package pg.home.dao;

@FunctionalInterface
public interface EntityFieldMapper<EntityType> {
    EntityType map(Object[] fields);
}
