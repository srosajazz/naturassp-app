package sergiorosa.naturassp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sergiorosa.naturassp.dao.PedidoDAO;
import sergiorosa.naturassp.model.ItemPedido;
import sergiorosa.naturassp.model.Pedido;

@Component
public class PedidoServiceImpl implements IPedidoService {

	@Autowired
	private PedidoDAO dao;

	@Override
	public Pedido inserirPedido(Pedido novo) {
		try {
			double total = 0.0;
			/*
			 * regra de negocio
			 * 
			 */
			for (ItemPedido item : novo.getItensPedido()) {
				item.setPrecoUnitario(item.getProduto().getPreco());

//			if(item.getQtdeItem() >= 5) {
//				item.setPrecoTotal(item.getPrecoUnitario() * item.getQtdeItem() * 0.8);
//		}
//		else {
			
				item.setPrecoTotal(item.getPrecoUnitario() * item.getQtdeItem());

//			}	
				total += item.getPrecoTotal();
			}
			for (ItemPedido item : novo.getItensPedido()) {
				item.setPedido(novo);
			}

			novo.setValorTotal(total);
//			System.out.println(novo);
			dao.save(novo);
//			System.out.println("Pedido Gravado");
			return novo;
		} catch (Exception ex) {
//			ex.printStackTrace();
			return null;

		}

	}

}
