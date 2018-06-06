package test;

import java.util.List;

import datos.Cliente;
import negocio.ClienteABM;

public class TestTraerClientes {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ClienteABM abm = new ClienteABM();
		try {
			List<Cliente> lista = abm.traerClientes();
			for(Cliente c : lista) {
				System.out.println(c.toString());
			}
		}catch(Exception e) {
			throw new Exception(e);
		}
		
	}

}
