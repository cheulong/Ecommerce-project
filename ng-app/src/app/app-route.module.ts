import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {ViewProductComponent} from "./product/view-product/view-product.component";
import {HeroViewComponent} from "./hero-view/hero-view.component";

const appRoutes: Routes=[
  { path: '', redirectTo: 'hero-view', pathMatch: 'full' },
  { path: 'product',component: ViewProductComponent},

  {
    path: 'hero-view',component:HeroViewComponent
  },

  {
    path: '**',component:HeroViewComponent
  }

];
@NgModule({
  imports:[
    RouterModule.forRoot(appRoutes)
  ],
  exports:[
    RouterModule
  ]
})
export class AppRouteModule{

}
