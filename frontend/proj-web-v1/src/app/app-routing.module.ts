import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProductsComponent} from './products/products.component';
import {NewProductComponent} from './new-product/new-product.component';
import {CustomersComponent} from './customers/customers.component';


const routes: Routes = [
  {
    path:"products",component:ProductsComponent
  },
  {
    path:"costumers",component:CustomersComponent
  },
  {
  path:"new-product",component:NewProductComponent
  },{
  path:"",redirectTo:"/products",pathMatch:'full'
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
