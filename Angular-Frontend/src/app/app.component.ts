import { Component } from '@angular/core';
import { OnInit } from '@angular/core/src/metadata/lifecycle_hooks';
import { isNullOrUndefined } from 'util';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Medical-Abuse-Prevention';
  isLoggedIn = false;

  ngOnInit() {
    const userInfo = localStorage.getItem('token');
    if (!isNullOrUndefined(userInfo)) {
      this.isLoggedIn = true;
    }
  }
}
