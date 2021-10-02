package sergiorosa.naturassp.services;

import java.util.ArrayList;

import sergiorosa.naturassp.model.Categoria;

public interface ICategoriaService {

	// This method receive one category only with full name and will insert in db.
	public Categoria inserirNovaCategoria(Categoria categoria);

	// This method will alter existent category and return a update and null if dont
	// not exist
	public Categoria alterarCategoria(Categoria categoria);

	// this method will get in backall category without filter
	public ArrayList<Categoria> recuperarTodasCategorias();

	// this method will get all category by KeyWord
	public ArrayList<Categoria> recuperarPorPalavraChave(String palavraChave);
}
