import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from '../user';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private BASE_URL = 'http://localhost:8080/user';
  private ALL_USERS_URL = `${this.BASE_URL}\\all`;
  private CREATE_USER_URL = `${this.BASE_URL}\\registration`;

  constructor(private http: HttpClient) {
  }

  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.ALL_USERS_URL);
  }

  createUser(model: User): Observable<any> {
    return this.http.post(this.CREATE_USER_URL, model);
  }
}
