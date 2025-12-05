package dao;

import java.sql.SQLException;
import java.util.List;

public interface ISimpleDAO<T, ID> {
    void create(T t) throws SQLException;
    T readOne(ID id) throws SQLException; // read
    List<T> readAll() throws SQLException;
    List<T> readBy(String filtro) throws SQLException;
    void update(T t) throws SQLException;
    void delete(ID id) throws SQLException;
}
