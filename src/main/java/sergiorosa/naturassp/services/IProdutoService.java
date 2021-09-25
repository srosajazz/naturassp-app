package sergiorosa.naturassp.services;

import java.util.ArrayList;

import sergiorosa.naturassp.model.Categoria;
import sergiorosa.naturassp.model.Produto;

public interface IProdutoService {
	
	
	public Produto  		  inserirNovoProduto(Produto produto);
	public Produto            alterarProduto(Produto produto);
	public ArrayList<Produto> listarTodos();
	public ArrayList<Produto> listarDisponiveis();
	public ArrayList<Produto> listaIndisponiveis();
	public ArrayList<Produto> listarPorCategoria(Categoria categoria);
//	public ArrayList<Produto> listarPorPalavraChave(String palavraChave);
	public Produto            recuperarPorId(int id);
//	public ArrayList<Produto> listarDestaques(int pagina);
//	public ArrayList<Produto> listarDestaques(int pagina);

}
