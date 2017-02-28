/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import entities.UnidadNegocio;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ian Franco
 */
public class UnidadNegocioDaoImpl {

    public List<UnidadNegocio> findAll() {
        List<UnidadNegocio> list = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String sql = "FROM UnidadNegocio ORDER BY numeroUnidadNegocio ASC";
        try {

            list = session.createQuery(sql).list();

            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
        }
        return list;
    }

    public UnidadNegocio findById(int id) {
        UnidadNegocio unidad = null;

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        String sql = "FROM UnidadNegocio WHERE idUnidadNegocio=" + id;
        try {

            unidad = (UnidadNegocio) session.createQuery(sql).uniqueResult();

            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
        }
        return unidad;
    }

}
