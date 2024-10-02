import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MenuComponent } from './menu/menu.component';
import { ErrorPageComponent } from './error-page/error-page.component';
import { BirlikComponent } from './birlik/birlik.component';
import { GemiComponent } from './gemi/gemi.component';

const routes: Routes = [
  { path: '', redirectTo: '/menu', pathMatch: 'full' },
  { path: 'menu', component: MenuComponent },
  { path: 'birlik', component: BirlikComponent },
  { path: 'gemi', component: GemiComponent },
  { path: '**', component: ErrorPageComponent } // 404 Not Found
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
