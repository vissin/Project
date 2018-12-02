import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { isNullOrUndefined } from 'util';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  isLoggedIn = false;

  constructor(private router: Router) { }

  ngOnInit() {
    const userInfo = localStorage.getItem('token');
    if (!isNullOrUndefined(userInfo)) {
      this.isLoggedIn = true;
    }
  }

  logout() {
    localStorage.removeItem('token');
    this.router.navigate(['login']);
  }

}
