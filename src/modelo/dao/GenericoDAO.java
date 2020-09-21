package modelo.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class GenericoDAO<T> implements InterfaceDAO<T>, Serializable {

    private static final long serialVersionUID = 1L;
    private Class<T> classe;
    private Session session;

    public GenericoDAO(Class<T> classe, Session session) {
        super();
        this.classe = classe;
        this.session = session;
    }

    @Override
    public void save(T entity) {
        session.save(entity);
    }

    @Override
    public void update(T entity) {
        Transaction t = session.beginTransaction();
        session.merge(entity);
        session.flush();
        t.commit();
    }

    @Override
    public void remove(T entity) {
        session.delete(entity);
    }

    @Override
    public void merge(T entity) {
        session.merge(entity);
    }

    @Override
    public T getEntity(Serializable id) {
        T entity = (T) session.get(classe, id);
        return entity;
    }

    @Override
    public T getEntityByCriteria(Criteria criteria) {
        T entity = (T) criteria.uniqueResult();
        return entity;
    }

    @Override
    public List<T> getEntities() {
        System.out.println(classe.toString());
        System.out.println(session.toString());
        List<T> entities = (List<T>) session.createCriteria(classe).list();
        return entities;
    }

    @Override
    public List<T> getListByCriteria(Criteria criteria) {
        return criteria.list();
    }

    @Override
    public T getEntityBySQL(String sql, String[] parametros, String[] valores) {
        Query query = session.createSQLQuery(sql).addEntity(classe);
        for (int i = 0; i < parametros.length; i++) {
            query.setParameter(parametros[i], valores[i]);
        }
        return (T) query.uniqueResult();
    }

    @Override
    public List<T> getListBySQL(String sql, String[] parametros, String[] valores) {
        Query query = session.createSQLQuery(sql).addEntity(classe);
        if (parametros != null) {
            for (int i = 0; i < parametros.length; i++) {
                query.setString(i, valores[i]);
            }
        }
        return query.list();
    }

    @Override
    public void getDeleteBySQL(String sql, String[] parametros, String[] valores) {
        Query query = session.createSQLQuery(sql).addEntity(classe);
        if (parametros != null) {
            for (int i = 0; i < parametros.length; i++) {
                query.setString(i, valores[i]);
            }
        }
        query.executeUpdate();
    }
}
