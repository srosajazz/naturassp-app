package sergiorosa.naturassp.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_pedido")
public class Pedido {
//	
//	public static final int NOVO_PEDIDO   = 1;
//	public static final int PAGO          = 2;
//	public static final int EM_TRANSPORTE = 3;
//	public static final int ENTREGUE      = 4;
//	public static final int POS_VENDA     = 5;
//	public static final int FINALIZADO    = 6;
//    public static final int CANCELADO     = 7;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private int idPedido;

	@Column(name = "data_pedido")
	private LocalDate dataPedido;

	@Column(name = "valor_total")
	private double valorTotal;

//	@Column(name = "valor_frete")
//	private double valorFrete;

//	@Column(name = "retirar")
//	private int    retirar;

	@Column(name = "observacoes", length = 500)
	private String observacoes;

	@Column(name = "status")
	private int status;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("pedido")
	private List<ItemPedido> itensPedido;

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	
	
//	public double getValorFrete() {
//		return valorFrete;
//	}

//	public void setValorFrete(double valorFrete) {
//		this.valorFrete = valorFrete;
//	}

//	public int getRetirar() {
//		return retirar;
//	}

//	public void setRetirar(int retirar) {
//		this.retirar = retirar;
//	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", dataPedido=" + dataPedido + ", valorTotal=" + valorTotal
				+ ", observacoes=" + observacoes + ", status=" + status + ", cliente=" + cliente + ", itensPedido="
				+ itensPedido + "]";
	}
	
	
}
