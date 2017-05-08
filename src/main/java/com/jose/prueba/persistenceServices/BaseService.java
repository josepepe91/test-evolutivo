package com.jose.prueba.persistenceServices;

import com.jose.prueba.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

/**
 * Created by optimus-desarrollo on 07/05/17.
 */
public class BaseService<T> {
    @PersistenceContext
    protected EntityManager em;

    private Class<T> tipoEntidad;
    private Class<?> tipoServicio;

    public BaseService(Class<T> tipoEntidad, Class<?> tipoServicio) {
        this.tipoEntidad = tipoEntidad;
        this.tipoServicio = tipoServicio;
    }

    public void insertar(T entidad) throws Exception {
        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(entidad);
        session.getTransaction().commit();
        session.close();
    }

    public void actualizar(T entidad) throws Exception {
        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(entidad);
        session.getTransaction().commit();
        session.close();
    }

    public void eliminar(T entidad) throws Exception {
        em.remove(em.merge(entidad));
    }

    public T buscarPorId(int id) throws Exception {
        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Object entidad = session.load(tipoEntidad, new Long(id));
        session.getTransaction().commit();
        session.close();
        return tipoEntidad.cast(entidad);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public List<T> buscarTodos() {
        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<T> all = new ArrayList<T>();
        all = session.createCriteria(tipoEntidad).list();
        session.getTransaction().commit();
        session.close();
        return all;
    }
}
