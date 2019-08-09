import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../user';
import {ApiService} from '../shared/api.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  constructor(private apiService: ApiService) {
  }

  user: User[] = [];

  ngOnInit() {
    this.getAllUsers();
  }

  public getAllUsers() {
    this.apiService.getAllUsers().subscribe(
      res => {
        this.user = res;
      },
      error1 => {
        alert('An Error has occured');
      }
    );
  }
}
