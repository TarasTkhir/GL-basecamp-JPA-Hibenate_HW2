package dao;

import java.io.Serializable;
import java.util.List;

public interface DAO <T, ID extends Serializable> {

    T createOrUpdate(T entity);

    void delete(ID id);

    T findById(ID id);

    List<T> findAll();
}
