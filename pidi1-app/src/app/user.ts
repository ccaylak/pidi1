export class User {
  firstName: string;
  lastName: string;
  birthDate: Date;
  postCode: string;
  place: string;
  address: string;

  constructor() {
    this.firstName = '';
    this.lastName = '';
    this.birthDate = null;
    this.postCode = '';
    this.place = '';
    this.address = '';
  }
}
