import { Component, OnInit } from '@angular/core';
import {CatalogueService} from '../services/catalogue.service';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit {

  public customers:any;
  constructor(private catService:CatalogueService) { }

  ngOnInit(): void {
  }
  onGetProducts() {
    this.catService.getCostumers()
      .subscribe(data=>{
        this.customers=data;
      },error => {
        console.log(error);
      } );
  }

}
