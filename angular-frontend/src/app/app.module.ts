import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';


import { AppComponent } from './app.component';
import { BuyAbonamentListComponent } from './buy-abonament-list/buy-abonament-list.component';
import { AddCodeUserComponent } from './discount-code-user/add-code-user/add-code-user.component';
import { InvalidCodeUserComponent } from './discount-code-user/invalid-code-user/invalid-code-user.component';
import { CancelAddCodeComponent } from './discount-code-user/cancel-add-code/cancel-add-code.component';
import { SuccessCodeComponent } from './discount-code-user/success-code/success-code.component';
import {RouterModule, Routes} from "@angular/router";
import { MenuComponent } from './menu/menu.component';

const routes: Routes = [
  { path: '', component: MenuComponent},
  { path: 'addCode', component: AddCodeUserComponent},
  { path: 'successCode', component: SuccessCodeComponent},
  { path: 'cancelCode', component: CancelAddCodeComponent},
  { path: 'invalidCode', component: InvalidCodeUserComponent}
];

@NgModule({
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA
  ],
  declarations: [
    AppComponent,
    BuyAbonamentListComponent,
    AddCodeUserComponent,
    InvalidCodeUserComponent,
    CancelAddCodeComponent,
    SuccessCodeComponent,
    MenuComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  exports:
    [RouterModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
