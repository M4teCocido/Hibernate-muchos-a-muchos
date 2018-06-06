package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.ClienteDao;
import dao.EventoDao;
import datos.Cliente;
import datos.Evento;

public class ClienteABM {
	
	ClienteDao dao = new ClienteDao();
	EventoDao daoEven = new EventoDao();
	
	public int agregar(String apellido, String nombre, int dni, GregorianCalendar fecha) throws Exception {
		if(dao.traerCliente(dni) != null) throw new Exception("Ya existe un cliente con el DNI: " + dni);
		Cliente c = new Cliente(apellido, nombre, dni, fecha);
		return dao.agregar(c);
	}
	
	public void eliminar(Cliente c) throws Exception {
		if(dao.traerCliente(c.getIdCliente()) == null) throw new Exception("El cliente que desea eliminar de la base de datos no existe.");
		dao.eliminar(c);
	}
	
	public void actualizar(Cliente c) throws Exception {
		Cliente cAux = dao.traerCliente(c.getDni());
		if(cAux != null && cAux.getIdCliente() != c.getIdCliente()) throw new Exception("Ya existe un cliente con el DNI: " + c.getDni());
		dao.actualizar(c);
	}
	
	public Cliente traerCliente(long idCliente) throws Exception {
		Cliente c = dao.traerCliente(idCliente);
		if(c == null) throw new Exception("El cliente que esta buscando no existe.");
		return c;
	}
	
	public Cliente traerCliente(int dni) throws Exception {
		Cliente c = dao.traerCliente(dni);
		if(c == null) throw new Exception("El cliente que esta buscando no existe.");
		return c;
	}
	
	public Cliente traerClienteYEventos(long idCliente) throws Exception {
		Cliente c = dao.traerClienteYEventos(idCliente);
		if(c == null) throw new Exception("El cliente que desea consultar no existe.");
		return c;
	}
	
	public List<Cliente> traerClientes() throws Exception {
		return dao.traerCliente();
	}
	
	public void agregarEvento(long idEvento, long idCliente) throws Exception {
		Evento e = daoEven.traerEvento(idEvento);
		//tirar ex si es null
		Cliente c = dao.traerClienteYEventos(idCliente);
		//tirar ex si es null
		c.agregar(e);
		dao.actualizar(c);
	}
	
	public void eliminarEvento(long idEvento, long idCliente) throws Exception {
		Evento e = daoEven.traerEvento(idEvento);//tirar ex si es null
		Cliente c = dao.traerClienteYEventos(idCliente);//tirar ex si es null
		c.eliminar(e);
		dao.actualizar(c);
	}
	
}
