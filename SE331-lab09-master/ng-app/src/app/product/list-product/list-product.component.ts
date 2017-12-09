import { Component, OnInit } from '@angular/core';
import {Product} from "../product";
import {ProductService} from "../../service/product.service";
import {Router} from "@angular/router";
import {Observable} from "rxjs/Observable";


@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.css']
})
export class ListProductComponent implements OnInit {
  errorMessage: any;
  isEdit=false;
  products: Product[];
  isAdd=false;
  pro: Product;
  constructor(private productService: ProductService,private router:Router) {
  }

  ngOnInit() {
    this.productService.getProductData()
      .subscribe(products => this.products = products);
  }

  deleteProduct(product:any){
    this.productService.deleteProduct(product.id);
  }
  updateProduct(product:any){
    this.productService.updateProduct(product);

  }
  addProduct(){
    this.isAdd=!this.isAdd;
  }
}
