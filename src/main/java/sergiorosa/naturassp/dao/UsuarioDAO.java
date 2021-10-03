package sergiorosa.naturassp.dao;

import org.springframework.data.repository.CrudRepository;

import sergiorosa.naturassp.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {
		public Usuario findByUsernameOrEmail(String username, String email);
}
