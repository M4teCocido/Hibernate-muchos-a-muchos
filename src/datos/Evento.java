package datos;

import java.util.GregorianCalendar;
import java.util.Set;

public class Evento {
	
	private long idEvento;
	private String evento;
	private GregorianCalendar fecha;
	private Set<Cliente> clientes;
	
	public Evento() {}
	
	public Evento(String evento, GregorianCalendar fecha) {
		super();
		this.evento = evento;
		this.fecha = fecha;
	}

	public long getIdEvento() {
		return idEvento;
	}

	protected void setIdEvento(long idEvento) {
		this.idEvento = idEvento;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", evento=" + evento + ", fecha=" + fecha + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idEvento ^ (idEvento >>> 32));
		return result;
	}

	public boolean equals(Evento e) {
		if (this == e)
			return true;
		if (e == null)
			return false;
		if (getClass() != e.getClass())
			return false;
		Evento other = (Evento) e;
		if (idEvento != other.idEvento)
			return false;
		return true;
	}
	
	public boolean agregar(Cliente c) throws Exception {
		if(clientes.contains(c)) throw new Exception("El cliente ya asistira a este evento.");
		return clientes.add(c);
	}
	
	public boolean eliminar(Cliente c) throws Exception {
		if(!clientes.contains(c)) throw new Exception("Ese cliente no pertenece a la lista de clientes de este evento.");
		return clientes.remove(c);
	}
	
}
