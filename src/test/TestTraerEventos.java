package test;

import java.util.List;

import datos.Evento;
import negocio.EventoABM;

public class TestTraerEventos {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		EventoABM abm = new EventoABM();
		try {
			List<Evento> lista = abm.traerEventos();
			for(Evento e : lista) {
				System.out.println(e.toString());
			}
		}catch(Exception e) {
			throw new Exception(e);
		}
	}

}
