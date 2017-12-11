import { Component, OnInit } from '@angular/core';
import {Http, Response,} from "@angular/http";
import { Location } from '@angular/common';

@Component({
  selector: 'app-paypal-payment',
  templateUrl: './paypal-payment.component.html',
  styleUrls: ['./paypal-payment.component.css']
})
export class PaypalPaymentComponent implements OnInit {



  constructor(private http: Http) { }

  ngOnInit() {

  }

}
