package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.ClienteDao;
import dao.EventoDao;
import datos.Cliente;
import datos.Evento;

public class EventoABM {
	
	EventoDao dao = new EventoDao();
	ClienteDao daoCli = new ClienteDao();
	
	public int agregar(String evento, GregorianCalendar fecha) {
		Evento e = new Evento(evento, fecha);
		return dao.agregar(e);
	}
	
	public void eliminar(Evento e) throws Exception {
		if(dao.traerEvento(e.getIdEvento()) == null) throw new Exception("El evento que desea eliminar no existe");
		dao.eliminar(e);
	}
	
	public void actualizar(Evento e) {
		dao.actualizar(e);
	}
	
	public Evento traerEvento(long idEvento) throws Exception {
		Evento e = dao.traerEvento(idEvento);
		if(e == null) throw new Exception("El evento que desea consultar no existe.");
		return e;
	}
	
	public List<Evento> traerEventos(){
		return dao.traerEventos();
	}
	
	public Evento traerEventoYClientes(long idEvento) throws Exception {
		Evento e = dao.traerEvento(idEvento);
		if(e == null) throw new Exception("El evento que desea consultar no existe.");
		return dao.traerEventoYClientes(idEvento);
	}
	
	public void agregarCliente(long idCliente, long idEvento) throws Exception {
		Cliente c = daoCli.traerCliente(idCliente);
		Evento e = dao.traerEventoYClientes(idEvento);
		e.agregar(c);
		dao.actualizar(e);
	}
}
