package test;

import java.util.GregorianCalendar;

import datos.Cliente;
import negocio.ClienteABM;

public class TestAgregarCliente {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ClienteABM abm = new ClienteABM();
		GregorianCalendar fecha = new GregorianCalendar(1984, 05, 06);
		long id = abm.agregar("Oliveto", "Ignacio", 35124564, fecha);
		Cliente c = abm.traerCliente(id);
		System.out.println(c.toString());
	}

}
