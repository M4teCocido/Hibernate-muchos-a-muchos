package test;

import datos.Cliente;
import datos.Evento;
import negocio.EventoABM;

public class TestAgregarClienteAEvento {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		EventoABM abm = new EventoABM();
		try {
			long idCliente = 2;
			long idEvento = 3;
			abm.agregarCliente(idCliente, idEvento);
			Evento e = abm.traerEvento(idEvento);
			System.out.println(e.toString());
			for(Cliente c : e.getClientes()) System.out.println("\n--->" + c.toString());
		}catch(Exception e) {
			throw new Exception(e);
		}
	}

}
