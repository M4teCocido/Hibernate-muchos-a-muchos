package test;

import java.util.GregorianCalendar;

import datos.Evento;
import negocio.EventoABM;

public class TestAgregarEvento {

	public static void main(String[] args) throws Exception {
		EventoABM abm = new EventoABM();
		try {
			GregorianCalendar fecha = new GregorianCalendar(2018, 05, 13);
			long id = abm.agregar("Entrega tp SUBE", fecha);
			Evento e = abm.traerEvento(id);
			System.out.println(e.toString());
		}catch(Exception e) {
			throw new Exception(e);
		}
		
	}
}
