import { Component, OnInit } from '@angular/core';
import { Produto } from 'src/app/model/Produto';
import { ProdutoService } from 'src/app/servicos/produto.service';

@Component({
  selector: 'app-destaques',
  templateUrl: './destaques.component.html',
  styleUrls: ['./destaques.component.css'],
})
export class DestaquesComponent implements OnInit {
  public list: Produto[] = [];

  // Service Injection and find Produtos
  constructor(private service: ProdutoService) {}

  ngOnInit(): void {
    this.service.getAllProdutos().subscribe(
      (res: Produto[]) => {
        this.list = res;
        console.log(res);
        console.log(typeof res);
      },
      (err: any) => console.log(err)
    );
  }
}
