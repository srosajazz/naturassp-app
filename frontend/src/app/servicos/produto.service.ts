import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class ProdutoService {
  constructor(private http: HttpClient) {}
  public getAllProdutos() {
    console.log('PRODUTOSERVICES - CONNECT WITH BACKEND!');

    return this.http.get('http://localhost:8080/produto');
  }
}
