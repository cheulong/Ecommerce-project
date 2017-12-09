import {Component, OnInit, Output} from '@angular/core';
import {ActivatedRoute, Params} from "@angular/router";
import {Product} from "../product";
import {ProductService} from "../../service/product.service";

@Component({
  selector: 'app-view-product',
  templateUrl: './view-product.component.html',
  styleUrls: ['./view-product.component.css']
})
export class ViewProductComponent implements OnInit {

  constructor(private route: ActivatedRoute, private productService:ProductService) {}
  cartItems:Product[];
  product:Product;
  isNoData:boolean;
  totalPrice:number;
  qtn:number=1;
  ngOnInit() {
    this.isNoData = false;
    this.route.params
      .switchMap((params:Params) =>  this.productService.getProduct(+params['id']))
      .subscribe((product:Product) => {
          if (product !== null) {
            this.product = product;
            this.totalPrice = product.productPrice;
          }
          else
            this.isNoData = true;
        }
      );

  }
  calculateTotalPrice(){
    if(this.qtn<=0)
      this.qtn=1;
    this.totalPrice=this.qtn*this.product.productPrice;
  }

  addToCart(product:Product){
    if(this.cartItems.length>0){
      
    }
  }
}
