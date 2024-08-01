import { Component, OnInit } from '@angular/core';
import { ProductListService } from '../../services/product-list.service';
import { StorageService } from '../../../../auth/services/storage.service';

@Component({
  selector: 'app-customer-home',
  templateUrl: './customer-home.component.html',
  styleUrl: './customer-home.component.css'
})
export class CustomerHomeComponent implements OnInit {
  constructor(private service: ProductListService, private storage: StorageService){}
  products = [
    {
      "productId" : "",
      "productName" : "",
      "productDescription" : "",
      "productImage" : "",
      "productDate" : "",
      "productCategory" : "",
      "sizes" : ""
    }
  ]

  ngOnInit(): void {

    this.storage.isTokenExpired();

    this.service.getAllProducts().subscribe(res=>{
      this.products = res;
    },err=>{
      console.log(err);
    })
  }

}
