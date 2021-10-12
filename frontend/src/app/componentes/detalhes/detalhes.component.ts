import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Produto } from 'src/app/model/Produto';
import { ProdutoService } from 'src/app/servicos/produto.service';

@Component({
  selector: 'app-detalhes',
  templateUrl: './detalhes.component.html',
  styleUrls: ['./detalhes.component.css'],
})
export class DetalhesComponent implements OnInit {
  public produtoDetalhe: Produto;

  constructor(private route: ActivatedRoute, private service: ProdutoService) {}

  ngOnInit(): void {
    this.route.params.subscribe((parameter) => {
      this.recuperarProduto(parameter['id']);
    });
  }

  public recuperarProduto(id: number) {
    this.service.getProdutoById(id).subscribe((prod: any) => {
      this.produtoDetalhe = prod;

      (erro: any) => {
        alert('Produto ivalid! ');
      };
    });
  }
}
