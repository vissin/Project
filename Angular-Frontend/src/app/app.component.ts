import { isNullOrUndefined } from 'util';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Medical-Abuse-Prevention';
  isLoggedIn = false;
  constructor(private router: Router) {
  }

  ngOnInit(): void {
    const userInfo = localStorage.getItem('token');
    if (!isNullOrUndefined(userInfo)) {
      this.isLoggedIn = true;
    } else {
    this.isLoggedIn = false;
      this.router.navigate(['login']);
    }
  }

}
