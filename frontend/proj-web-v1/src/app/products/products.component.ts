import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CatalogueService} from '../services/catalogue.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
   public products:any;
  constructor(private catService:CatalogueService) { }

  ngOnInit(): void {
  }

  onGetProducts() {
    this.catService.getProducts()
     .subscribe(data=>{
this.products=data;
     },error => {
       console.log(error);
     } );
  }
}
