//Aqui fazemoso objetopedido,porem ele funciona comonosso cart

import { ItemPedido } from './ItemPedido';

export class Pedido {
  public itensPedido: ItemPedido[];
  public valorTotal: number = 0;
}
