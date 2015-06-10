package kodu.data.support;

public interface CrudDao<E, K> {
    K create(E entity);
    E findById(K id);
    void update(E entity);
    void delete(K id);
}
