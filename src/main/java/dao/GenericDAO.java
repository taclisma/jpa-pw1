package dao;

public interface GenericDAO<T> {
    public boolean insert(T obj);
    public boolean update(T obj);
    public boolean delete(T obj);
    public T findByID(Long id);
    public java.util.List<T> listAll();
    public java.util.List<T> findByAttribute(String s);
}

  // TODO cadastrar, atualizar, excluir e listar todos