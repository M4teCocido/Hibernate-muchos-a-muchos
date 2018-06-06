package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Evento;

public class EventoDao {
	
	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso de datos: " + he);
	}
	
	public int agregar(Evento objeto) throws HibernateException {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
		return id;
	}
	
	public void actualizar(Evento objeto) {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
	}
	
	public void eliminar(Evento objeto) {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
	}
	
	public Evento traerEvento(long idEvento) throws HibernateException {
		Evento e = null;
		try {
			iniciaOperacion();
			e = (Evento) session.get(Evento.class, idEvento);
		}finally {
			session.close();
		}
		return e;
	}
	
	@SuppressWarnings("unchecked")
	public List<Evento> traerEventos()throws HibernateException{
		List<Evento> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Evento e order by e.fecha asc").list();
		}finally {
			session.close();
		}
		return lista;
	}
	
	public Evento traerEventoYClientes(long idEvento)throws HibernateException {
		Evento objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Evento e where e.idEvento = " + idEvento;
			objeto = (Evento) session.createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getClientes());
		}finally {
			session.close();
		}
		return objeto;
	}

}
