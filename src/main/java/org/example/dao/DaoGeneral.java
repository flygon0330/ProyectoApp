package org.example.dao;
import java.util.List;
public interface DaoGeneral<K,E> {
    public boolean agregar (E elemento);
    public List<E> consultar();
    public boolean actualizar(K id, E nuevo);
    public boolean eliminar (K id);
}
