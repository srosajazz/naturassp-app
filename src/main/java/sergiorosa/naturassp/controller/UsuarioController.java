package sergiorosa.naturassp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sergiorosa.naturassp.model.Usuario;
import sergiorosa.naturassp.security.JWTToken;
import sergiorosa.naturassp.security.JWTTokenUtil;
import sergiorosa.naturassp.services.IUsuarioService;



	@RestController
	public class UsuarioController {

		@Autowired
		private IUsuarioService service;

		@PostMapping("/login")
		public ResponseEntity<JWTToken> Login(@RequestBody Usuario dadosLogin) {
			Usuario user = service.recuperarUsuario(dadosLogin);
			if (user != null) { // user exist, check for password now!
				if(user.getSenha().equals(dadosLogin.getSenha())) {
					//create Token
					JWTToken jwttoken = new JWTToken();
					
					jwttoken.setToken(JWTTokenUtil.generateToken(user));
					
					
					return ResponseEntity.ok(jwttoken);
					
					
				}
				return ResponseEntity.status(403).build(); // User does not have login authorization
			}
			return ResponseEntity.notFound().build();
		}
	}


