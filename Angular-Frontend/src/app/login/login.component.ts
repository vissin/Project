import { Component, OnInit } from '@angular/core';
import { LoginModel } from 'src/app/model/loginModel';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginModel:LoginModel ={} as LoginModel;

  constructor() { }

  ngOnInit() {
  }

  onSubmit(){
       
      debugger;
      var k = this.loginModel;
  }
}
