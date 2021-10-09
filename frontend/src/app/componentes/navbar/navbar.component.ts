import { Component, OnInit } from '@angular/core';
import { Categoria } from 'src/app/model/Categoria';
import { CategoriaService } from 'src/app/servicos/categoria.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  public lista: Categoria[] = [];

  constructor(private service: CategoriaService) {}

  // I have to do the same way as destaques.components
  // 
  ngOnInit(): void {
    this.service.getAllCategorias().subscribe(
      (res: any) => {
        this.lista = res;
        this.lista = res;
        console.log(res);
        console.log(typeof res);
      },
      (err: any) => console.log(err)
    );
  }
}
