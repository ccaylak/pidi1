package de.caylak.pidl1;

import de.caylak.pidl1.model.User;
import de.caylak.pidl1.viewmodel.UserViewModel;
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
                userViewModel.getAddress());

        return viewModel;
    }
}
