import { Component, OnInit } from '@angular/core';
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
  product:Product;
  isNoData:boolean;



  ngOnInit() {


    this.isNoData = false;
    this.route.params
      .switchMap((params:Params) =>  this.productService.getProduct(+params['id']))
      .subscribe((product:Product) => {
          if (product !== null)
            this.product = product;
          else
            this.isNoData = true;
        }
      );

  }
}
