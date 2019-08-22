import {TestBed} from '@angular/core/testing';
import {HttpClientModule} from '@angular/common/http';
import {ApiService} from './api.service';
import {User} from '../user';
import {PactWeb, Matchers} from '@pact-foundation/pact-web';

describe('ApiService', () => {
  let provider;

  const name = 'Cem';

  beforeAll(done => {
    provider = new PactWeb({
      consumer: 'ui',
      provider: 'apiservice',
      port: 1234,
      host: '127.0.0.1',
    });
    setTimeout(done, 2000);
    provider.removeInteractions();
  });

  afterAll(done => {
    provider.finalize().then(() => {
      done();
    }, (err) => {
      done.fail(err);
    });
  });

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        HttpClientModule
      ],
      providers: [
        ApiService
      ],
    });
  });


  describe('create()', () => {
    const expectedUser: User = {
      firstName: 'Cem',
      lastName: 'Caylak',
      birthDate: new Date('1999-01-17'),
      address: 'Castroper Straße 102',
      place: 'Datteln',
      postCode: '45711',
    };

    beforeAll((done) => {
      provider.addInteraction({
        state: `provider accepts a new user`,
        uponReceiving: 'a request to POST an user',
        withRequest: {
          method: 'POST',
          path: '/user/registration',
          body: expectedUser,
          headers: {
            'Content-Type': 'application/json'
          }
        },
        willRespondWith: {
          status: 200,
          headers: {
            'Content-Type': 'application/json'
          },
          body: [{
            firstName: Matchers.somethingLike('Cem'),
          }]
        }
      }).then(done, error => done.fail(error));
    });


    it('should create an User', done => {
      const apiService: ApiService = TestBed.get(ApiService);
      apiService.createUser(expectedUser).subscribe(response => {
        expect(response).toEqual(expectedUser);
        done();
      }, error => {
        done.fail(error);
      });
    });
  });
});
