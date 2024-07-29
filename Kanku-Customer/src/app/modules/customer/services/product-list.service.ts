
import { Injectable } from '@angular/core';
import { Product } from './interfaces/product.interface';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductListService {

  private bottoles: Product[] = [
    { position: 1, name: 'Spring Water Bottle', price: 1.99, imageUrl: '../../../../assets/img/bottels/b1.jpeg' },
    { position: 2, name: 'Purity Stainless Steel Water Bottle', price: 2.99, imageUrl: '../../../../assets/img/bottels/b2.jpeg' },
    { position: 3, name: 'SLIM Water Bottle', price: 3.99, imageUrl: '../../../../assets/img/bottels/b3.jpeg' },
    { position: 4, name: 'Hydrogen Water Bottle', price: 4.99, imageUrl: '../../../../assets/img/bottels/b4.jpeg' },
    { position: 5, name: 'Splash Water Bottle', price: 4.99, imageUrl: '../../../../assets/img/bottels/b5.jpeg' },

  ];


  private tifin: Product[] = [
    { position: 1, name: 'Poppy Stainlees Steel Lunch Box', price: 1.99, imageUrl: '../../../../assets/img/tiffin/t1.jpeg' },
    { position: 2, name: 'Praco Stainlees Steel Lunch Box', price: 4.99, imageUrl: '../../../../assets/img/tiffin/t5.jpeg' },
    { position: 3, name: 'Wonder Stainlees Steel Lunch Box', price: 2.99, imageUrl: '../../../../assets/img/tiffin/t2.jpeg' },
    { position: 4, name: 'Praco Stainlees Steel Lunch Box', price: 3.99, imageUrl: '../../../../assets/img/tiffin/t3.jpeg' },
    { position: 5, name: 'Praco Stainlees Steel Lunch Box', price: 4.99, imageUrl: '../../../../assets/img/tiffin/t4.jpeg' },
    { position: 6, name: 'Feast Stainlees Steel Lunch Box', price: 4.99, imageUrl: '../../../../assets/img/tiffin/tiffin3.jpeg' },
  ];

  private uniform: Product[] = [
    { position: 1, name: 'School Uniform', price: 1.99, imageUrl: '../../../../assets/img/uniform/u1.jpg' },
    { position: 1, name: 'School Uniform', price: 1.99, imageUrl: '../../../../assets/img/uniform/u2.jpg' },
    { position: 1, name: 'School Uniform', price: 1.99, imageUrl: '../../../../assets/img/uniform/u3.png' },
    { position: 1, name: 'School Uniform', price: 1.99, imageUrl: '../../../../assets/img/uniform/u4.jpeg' },
    { position: 1, name: 'School Uniform', price: 1.99, imageUrl: '../../../../assets/img/uniform/u5.jpeg' },
    { position: 1, name: 'School Uniform', price: 1.99, imageUrl: '../../../../assets/img/uniform/u6.jpeg' },
    { position: 1, name: 'School Uniform', price: 1.99, imageUrl: '../../../../assets/img/uniform/u7.jpeg' },
  ];

  constructor() { }

  getbottol(): Observable<Product[]> {
    return of(this.bottoles);
  }
  gettiffin(): Observable<Product[]> {
    return of(this.tifin);
  }
  getuniform(): Observable<Product[]> {
    return of(this.uniform);
  }
}


