import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ItemPedido } from 'src/app/model/ItemPedido';
import { Pedido } from 'src/app/model/Pedido';
import { Produto } from 'src/app/model/Produto';
import { ProdutoService } from 'src/app/servicos/produto.service';

@Component({
  selector: 'app-detalhes',
  templateUrl: './detalhes.component.html',
  styleUrls: ['./detalhes.component.css'],
})
export class DetalhesComponent implements OnInit {
  public produtoDetalhe: Produto;
  public quantidade: number;

  // Constructor
  constructor(private route: ActivatedRoute, private service: ProdutoService) {
    this.quantidade = 1;
  }

  ngOnInit(): void {
    this.route.params.subscribe((parameter) => {
      this.recuperarProduto(parameter['id']);
    });
  }

  public recuperarProduto(id: number) {
    this.service.getProdutoById(id).subscribe(
      (prod: any) => {
        this.produtoDetalhe = prod;
      },
      (erro) => {
        alert('produto invali');
      }
    );
  }

  public addCart() {
    let pedido: Pedido;
    pedido = JSON.parse(localStorage.getItem('CartShop') || '{}');
    if (!pedido) {
      // se ele não exisitir, eu crio um novo pedido
      pedido = new Pedido();
      pedido.valorTotal = 0;
      pedido.itensPedido = [];
    }

    let item: ItemPedido;
    item = new ItemPedido();
    item.qtdeItem = this.quantidade;
    item.produto = this.produtoDetalhe;
    item.precoTotal = item.precoUnitario * item.qtdeItem;

    pedido.itensPedido.push(item);
    pedido.valorTotal = pedido.valorTotal + item.precoTotal;
    localStorage.setItem('CartShop', JSON.stringify(pedido));
  }
}
