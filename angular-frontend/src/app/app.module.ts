import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BuyAbonamentListComponent } from './buy-abonament-list/buy-abonament-list.component';

@NgModule({
  declarations: [
    AppComponent,
    BuyAbonamentListComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
