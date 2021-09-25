package sergiorosa.naturassp.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sergiorosa.naturassp.dao.ProdutoDAO;
import sergiorosa.naturassp.model.Categoria;
import sergiorosa.naturassp.model.Produto;


@Component
public class ProductoServiceImpl implements IProdutoService{

	@Autowired
	private ProdutoDAO dao;

	@Override
	public Produto inserirNovoProduto(Produto produto) {
		
		try {
			dao.save(produto);
			return produto;
			
		} catch (Exception ex) {
			System.out.println("---- ProdutoService.inseirirNovoProduto ---");
			ex.printStackTrace();
			System.out.println("-------------------------------------------");
		}
		
		return null;
	}

	@Override
	public Produto alterarProduto(Produto produto) {
		try {
			dao.save(produto);
			return produto;
		} catch (Exception ex) {
			System.out.println("---- ProdutoService.alterarProduto ---");
			ex.printStackTrace();
			System.out.println("--------------------------------------");
		}
		
		
		return null;
	}

	@Override
	public ArrayList<Produto> listarTodos() {
		// TODO Auto-generated method stub
		return (ArrayList<Produto>) dao.findAll();
		
	}

	@Override
	public ArrayList<Produto> listarDisponiveis() {
		// TODO Auto-generated method stub
		return dao.findAllByDisponivel(1);
	}

	@Override
	public ArrayList<Produto> listarPorCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return dao.findAllByDisponivelAndCategoria(1,  categoria);
	}

	@Override
	public ArrayList<Produto> listaIndisponiveis() {
		// TODO Auto-generated method stub
		return dao.findAllByDisponivel(0);
	}

	@Override
	public Produto recuperarPorId(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}


}
