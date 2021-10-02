package sergiorosa.naturassp.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import sergiorosa.naturassp.model.Categoria;

public interface CategoriaDAO extends CrudRepository<Categoria, Integer> {

	// custom queries

	// 1: Category by key words
	public ArrayList<Categoria> findByNomeContaining(String palavra);

}
