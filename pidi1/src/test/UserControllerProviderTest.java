import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit5.HttpsTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import de.caylak.pidi1.UserRepository;
import de.caylak.pidi1.viewmodel.UserViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        properties = "server.port=8080")

@Provider("UserService")
public class UserControllerProviderTest {

    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    void setupTestTarget(PactVerificationContext context) {
        context.setTarget(new HttpsTestTarget("localhost", 8080, "/"));
    }

    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider.class)
    void pactVerificationTestTemplate(PactVerificationContext context) {
        context.verifyInteraction();
    }

    @State({"provider accepts a new user"})
    public void toCreateUserState() {
        UserViewModel userViewModel = new UserViewModel();
        userViewModel.setFirstName("Cem");
        userViewModel.setLastName("Caylak");
        userViewModel.setBirthDate(LocalDate.of(1999, 1, 17));
        userViewModel.setPlace("45711");
        userViewModel.setAddress("Castroper Straße 102");
    }
}
