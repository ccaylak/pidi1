import {Component, OnInit} from '@angular/core';
import {User} from '../user';
import {ApiService} from '../shared/api.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  model: User = new User();


  constructor(private apiService: ApiService) {
  }

  ngOnInit() {
  }

  sendForm(): void {
    this.apiService.createUser(this.model).subscribe(
      res => {
        location.reload();
      },
      err => {
        alert('Es ist etwas fehlgeschlagen');
      }
    );
  }
}
