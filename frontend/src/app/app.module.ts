import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CarrosselComponent } from './componentes/carrossel/carrossel.component';
import { DestaquesComponent } from './componentes/destaques/destaques.component';
import { DetalhesComponent } from './componentes/detalhes/detalhes.component';
import { NavbarComponent } from './componentes/navbar/navbar.component';
import { RodapeComponent } from './componentes/rodape/rodape.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    RodapeComponent,
    DestaquesComponent,
    CarrosselComponent,
    DetalhesComponent,
    FormsModule,
  ],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
