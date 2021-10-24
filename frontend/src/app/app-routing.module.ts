import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CartshopComponent } from './componentes/cartshop/cartshop.component';
import { DestaquesComponent } from './componentes/destaques/destaques.component';
import { DetalhesComponent } from './componentes/detalhes/detalhes.component';

// Routes
const routes: Routes = [
  { path: '', component: DestaquesComponent },
  { path: 'detalhe/:id', component: DetalhesComponent },
  { path: 'cartshop', component: CartshopComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
