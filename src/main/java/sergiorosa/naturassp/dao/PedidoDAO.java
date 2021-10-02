package sergiorosa.naturassp.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import sergiorosa.naturassp.model.Cliente;
import sergiorosa.naturassp.model.Pedido;

public interface PedidoDAO extends CrudRepository<Pedido, Integer> {
	public ArrayList<Pedido> findAllByCliente(Cliente cliente);

}
