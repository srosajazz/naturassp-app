import { Component, OnInit } from '@angular/core';
import { Pedido } from 'src/app/model/Pedido';

@Component({
  selector: 'app-cartshop',
  templateUrl: './cartshop.component.html',
  styleUrls: ['./cartshop.component.css'],
})
export class CartshopComponent implements OnInit {
  public pedido: Pedido;
  public vazio: boolean;

  constructor() {}

  ngOnInit(): void {
    this.pedido = JSON.parse(localStorage.getItem('CartShop')!);
    if (!this.pedido) {
      this.vazio = true;
    } else {
      this.vazio = false;
    }
  }

  // Delete item from bin
  public deleteItem(idProduto: number) {
    let i: number = idProduto;
    for (i = 0; i < this.pedido.itensPedido.length; i++) {
      if (this.pedido.itensPedido[i].produto.id == idProduto) {
        alert('delete product = ' + this.pedido.itensPedido[i].produto.nome);
        this.pedido.valorTotal -= this.pedido.itensPedido[i].precoTotal;
        this.pedido.itensPedido.splice(i, 1);
      }
    }
    localStorage.setItem('CartShop', JSON.stringify(this.pedido));
  }
}
