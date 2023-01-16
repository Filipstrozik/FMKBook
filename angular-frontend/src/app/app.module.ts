import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';


import { AppComponent } from './app.component';
import { BuyAbonamentListComponent } from './buy-abonament/buy-abonament-list/buy-abonament-list.component';
import { AddCodeUserComponent } from './discount-code-user/add-code-user/add-code-user.component';
import { CancelAddCodeComponent } from './discount-code-user/cancel-add-code/cancel-add-code.component';
import { SuccessCodeComponent } from './discount-code-user/success-code/success-code.component';
import {RouterModule, Routes} from "@angular/router";
import { MenuComponent } from './menu/menu.component';
import { InviteUserComponent } from './invite-friend/invite-user/invite-user.component';
import { SuccessSentComponent } from './invite-friend/success-sent/success-sent.component';
import { InviteInformComponent } from './invite-friend/invite-inform/invite-inform.component';
import { BuyAbonamentDetailsComponent } from './buy-abonament/buy-abonament-details/buy-abonament-details.component';
import { BuyAbonamentConfirmedComponent } from './buy-abonament/buy-abonament-confirmed/buy-abonament-confirmed.component';
import { BuyAbonamentCancelledComponent } from './buy-abonament/buy-abonament-cancelled/buy-abonament-cancelled.component';
import { HttpClientModule} from "@angular/common/http";
import {UserIdService} from "./services/userId/user-id.service";
import {NotificationService} from "./services/notification/notification.service";
import {TypAbonamentu} from "./typ-abonamentu.model";
import {TypAbonamentuService} from "./services/typ-abonamentu/typ-abonamentu.service";

const routes: Routes = [
  { path: '', component: MenuComponent},
  { path: 'addCode', component: AddCodeUserComponent},
  { path: 'successCode/:rabat', component: SuccessCodeComponent},
  { path: 'cancelCode', component: CancelAddCodeComponent},
  { path: 'inviteUser', component: InviteUserComponent},
  { path: 'successSent', component: SuccessSentComponent},
  { path: 'info', component: InviteInformComponent},
  { path: 'abonamentList', component: BuyAbonamentListComponent},
  { path: 'abonamentDetails/:id' , component: BuyAbonamentDetailsComponent},
  { path: 'buyAbonamentConfirmed' , component: BuyAbonamentConfirmedComponent},
  { path: 'buyAbonamentCancelled' , component: BuyAbonamentCancelledComponent},
];

@NgModule({
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA
  ],
  declarations: [
    AppComponent,
    BuyAbonamentListComponent,
    AddCodeUserComponent,
    CancelAddCodeComponent,
    SuccessCodeComponent,
    MenuComponent,
    InviteUserComponent,
    SuccessSentComponent,
    InviteInformComponent,
    BuyAbonamentDetailsComponent,
    BuyAbonamentConfirmedComponent,
    BuyAbonamentCancelledComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
  ],
  exports:
    [RouterModule],
  providers: [TypAbonamentuService, UserIdService, NotificationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
