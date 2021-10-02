package sergiorosa.naturassp.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import sergiorosa.naturassp.model.Categoria;
import sergiorosa.naturassp.model.Produto;
import sergiorosa.naturassp.services.IProdutoService;
import sergiorosa.naturassp.services.IUploadService;

@RestController
public class ProdutoController {

	@Autowired
	private IProdutoService service;

	@Autowired
	private IUploadService upload;

	@PostMapping("/produto")
	public ResponseEntity<Produto> novoProduto(@RequestBody Produto novo) {
		try {
			service.inserirNovoProduto(novo);
			return ResponseEntity.status(201).body(novo);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ResponseEntity.badRequest().build();
	}

	@PostMapping("/produto/upload")
	public ResponseEntity<String> uploadFoto(@RequestParam(name = "arquivo") MultipartFile arquivo) {
		String path = upload.uploadFile(arquivo);
		if (path != null) {
			return ResponseEntity.status(201).body(path);

		}
		return ResponseEntity.badRequest().build();
	}

	@GetMapping("/produto")
	public ResponseEntity<ArrayList<Produto>> recuperarTodos() {
		return ResponseEntity.ok(service.listarDisponiveis());
	}

	@GetMapping("/produto/categoria/{id}")
	public ResponseEntity<ArrayList<Produto>> recuperarPorCategoria(@PathVariable(name = "id") int idCateg) {
		Categoria cat = new Categoria();
		cat.setId(idCateg);
		return ResponseEntity.ok(service.listarPorCategoria(cat));
	}

	@GetMapping("/produto/{id}")
	public ResponseEntity<Produto> recuperarPorId(@PathVariable(name = "id") int idProduto) {
		Produto prod = service.recuperarPorId(idProduto);
		if (prod != null) {
			return ResponseEntity.ok(prod);
		}
		return ResponseEntity.notFound().build();
	}

}
