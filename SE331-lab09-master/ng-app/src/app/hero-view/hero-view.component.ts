import { Component, OnInit } from '@angular/core';
import {Product} from "../product/product";
import {ProductService} from "../service/product.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-hero-view',
  templateUrl: './hero-view.component.html',
  styleUrls: ['./hero-view.component.css']
})
export class HeroViewComponent implements OnInit {
  products: Product[];
  search:string;
  constructor(private productService: ProductService, private router: Router ) {
  }

  ngOnInit() {
    this.productService.getProductData()
      .subscribe(products => this.products = products);

  }
  showDetail(product:Product){
    this.router.navigate(['/detail',product.id])
  }
  onSearch(){
    this.productService.findProduct(this.search)
      .subscribe(
        products=>this.products=products


      )
  }
}
