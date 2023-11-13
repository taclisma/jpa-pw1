package dao;

public interface GenericDAO<T> {
    public boolean insert(T obj);
    public boolean update(T obj);
    public boolean delete(T obj);
    public T findByID(int id);
}
