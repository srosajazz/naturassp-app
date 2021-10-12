import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DestaquesComponent } from './componentes/destaques/destaques.component';
import { DetalhesComponent } from './componentes/detalhes/detalhes.component';

// Routes
const routes: Routes = [
  { path: '', component: DestaquesComponent },
  { path: 'detalhe/:id', component: DetalhesComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
