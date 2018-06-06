package test;

import datos.Cliente;
import datos.Evento;
import negocio.ClienteABM;

public class TestAgregarEventoACliente {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ClienteABM abm = new ClienteABM();
		try {
			long idCliente = 1;
			long idEvento = 1;
			abm.agregarEvento(idEvento, idCliente);
			Cliente c = abm.traerClienteYEventos(idCliente);
			System.out.println(c.toString());
			for(Evento e : c.getEventos()) System.out.println("\n--->" + e.toString()); 
		}catch(Exception e) {
			throw new Exception(e);
		}
	}
}
