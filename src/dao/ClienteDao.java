package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;

public class ClienteDao {
	
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
	
	public int agregar(Cliente c)throws HibernateException {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(c).toString());
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
		return id;
	}
	
	public void actualizar(Cliente c)throws HibernateException {
		try {
			iniciaOperacion();
			session.update(c);
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
	}
	
	public void eliminar(Cliente c)throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(c);
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
	}

	public Cliente traerCliente(long idCliente)throws HibernateException {
		Cliente c = null;
		try {
			iniciaOperacion();
			c = (Cliente) session.get(Cliente.class, idCliente);
		}finally {
			session.close();
		}
		return c;
	}
	
	public Cliente traerCliente(int dni) throws HibernateException {
		Cliente c = null;
		try {
			iniciaOperacion();
			c = (Cliente) session.createQuery("from Cliente c where c.dni = " + dni).uniqueResult();
		}finally {
			session.close();
		}
		return c;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> traerCliente()throws HibernateException {
		List<Cliente> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Cliente c order by c.apellido asc, c.nombre asc").list();
		}finally {
			session.close();
		}
		return lista;
	}
	
	public Cliente traerClienteYEventos(long idCliente)throws HibernateException {
		Cliente c = null;
		try {
			iniciaOperacion();
			String hql = "from Cliente c where c.idCliente = " + idCliente;
			c = (Cliente) session.createQuery(hql).uniqueResult();
			Hibernate.initialize(c.getEventos());
		}finally {
			session.close();
		}
		return c;
	}
}
