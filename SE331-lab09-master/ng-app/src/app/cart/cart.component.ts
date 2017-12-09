import {Component, Input, OnInit} from '@angular/core';
import {Product} from "../product/product";

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  @Input() cartItem: any[];

  constructor() { }

  ngOnInit() {

  }

  //Inputs:['addToCartData']

}
