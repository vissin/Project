import { Component, OnInit } from '@angular/core';
import { isNullOrUndefined } from 'util';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  isLoggedIn = false;

  constructor() { }

  ngOnInit() {
    const userInfo = localStorage.getItem('token');
    if (!isNullOrUndefined(userInfo)) {
      this.isLoggedIn = true;
    }
  }

}
