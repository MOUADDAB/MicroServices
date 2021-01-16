import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CatalogueService {

  constructor(private httpCLient:HttpClient) { }
  public getProducts(){
    return this.httpCLient.get("http://localhost:8888/PRODUCT-SERVICE/products");
  }
  public getCostumers(){
    return this.httpCLient.get("http://localhost:8888/CUSTOMER-SERVICE/customers");
  }
}
