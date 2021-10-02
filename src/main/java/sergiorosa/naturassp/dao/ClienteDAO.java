package sergiorosa.naturassp.dao;

import org.springframework.data.repository.CrudRepository;

import sergiorosa.naturassp.model.Cliente;

public interface ClienteDAO extends CrudRepository<Cliente, Integer> {

	public Cliente findByEmailOrTelefone(String email, String telefone);

}
