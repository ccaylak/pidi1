package de.caylak.pidi1;

import de.caylak.pidi1.model.User;
import de.caylak.pidi1.viewmodel.UserViewModel;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public User convertToUser(UserViewModel userViewModel) {
        var viewModel = new User(
                userViewModel.getFirstName(),
                userViewModel.getLastName(),
                userViewModel.getBirthDate(),
                userViewModel.getPostCode(),
                userViewModel.getPlace(),
                userViewModel.getAddress()
                );

        return viewModel;
    }
}
