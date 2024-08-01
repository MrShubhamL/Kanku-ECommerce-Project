import { Component, OnInit } from '@angular/core';
import { ProductListService } from '../../services/product-list.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-customer-product-details',
  templateUrl: './customer-product-details.component.html',
  styleUrl: './customer-product-details.component.css'
})
export class CustomerProductDetailsComponent implements OnInit {
  productId: string | null = null;
  constructor(private service: ProductListService, private router: ActivatedRoute){}

  product = {
    "productId" : '',
    "productName" : '',
    "productDescription" : '',
    "productImage" : '',
    "productDate" : '',
    "productCategory" : '',
    "sizes" : [
      {
        "sizeType" : '',
        "productDropPrice" : '',
        "productPrice" : '',
        "totalProductQuantity" : '',
        "totalAmount" : ''
      }
    ]
  }

  size = {
    "product" : {
      "productId" : '',
    }
  }

  ngOnInit(): void {
    this.router.paramMap.subscribe(paramMap => {
      this.productId = paramMap.get('id');
    })

    this.service.getProductById(this.productId).subscribe(res=>{
      this.product = res;
      this.service.getSizeByProductId(this.productId).subscribe(res=>{
        console.log(res);

      })

    },err=>{
      console.log(err);
    })

  }

}
