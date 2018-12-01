import { Component, OnInit } from '@angular/core';
import { LoginModel } from 'src/app/model/loginModel';
import { CommonService } from 'src/app/service/common.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginModel: LoginModel = {} as LoginModel;

  constructor(private commonService: CommonService) { }

  ngOnInit() {
  }

  onSubmit() {
    this.commonService.userLogin(this.loginModel).subscribe(
      (data) => {
        debugger;
      }
    );
  }
}
