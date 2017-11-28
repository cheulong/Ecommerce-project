import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { ViewProductComponent } from './product/view-product/view-product.component';
import { FooterComponent } from './footer/footer.component';
import {AppRouteModule} from "./app-route.module";
import { HeroViewComponent } from './hero-view/hero-view.component';
import { AuthenticateComponent } from './authentication/authenticate/authenticate.component';
import { SignUpComponent } from './authentication/sign-up/sign-up.component';
import { SignInComponent } from './authentication/sign-in/sign-in.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    ViewProductComponent,
    FooterComponent,
    HeroViewComponent,
    AuthenticateComponent,
    SignUpComponent,
    SignInComponent,

  ],
  imports: [
    BrowserModule,
    AppRouteModule,

  ],

  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
