import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Produto } from '../model/Produto';

@Injectable({
  providedIn: 'root',
})
export class ProdutoService {
  constructor(private http: HttpClient) {}
  public getAllProdutos(): Observable<Produto[]> {
    return this.http.get<Produto[]>('http://localhost:8080/produto');
  }

  // GetProductByID
  public getProdutoById(id: number) {
    return this.http.get('http://localhost:8080/produto/' + id);
  }
}
