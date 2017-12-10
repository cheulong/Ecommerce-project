import {Cart} from "./cart";
import {Product} from "../product/product";
import {Item} from "./item";

export class CartService{
  getVoucherPrice:number;
  selectedItems: Item[] = [];
  addItem(product: Product, productQuantity: number,totalPrice:number): void {

    this.selectedItems.push(new Item(product,productQuantity,totalPrice));
    }
  getSelectedItems():Item[]{
    return this.selectedItems;
  }
  setVoucher(voucher:number):any{
    if(voucher!==0)
    this.getVoucherPrice=voucher;
    else
      this.getVoucherPrice=1;
    console.log(this.getVoucherPrice)
  }
  getVoucher():number{
    return this.getVoucherPrice;
  }
}
