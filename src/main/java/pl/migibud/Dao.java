package pl.migibud;

import java.util.List;
import java.util.Optional;

public interface Dao<T,ID> {

    <S extends T> S save(S entity);
    Optional<T> findById(ID id);
    List<T> findAll();
    void delete(T entity);
}
