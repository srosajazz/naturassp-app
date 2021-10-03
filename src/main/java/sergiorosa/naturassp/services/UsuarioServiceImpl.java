package sergiorosa.naturassp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sergiorosa.naturassp.dao.UsuarioDAO;
import sergiorosa.naturassp.model.Usuario;


@Component
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private UsuarioDAO dao;

	@Override
	public Usuario recuperarUsuario(Usuario original) {
		return dao.findByUsernameOrEmail(original.getUsername(), original.getEmail());
	}

}
