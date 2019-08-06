package de.caylak.pidl1;

import de.caylak.pidl1.model.User;
import de.caylak.pidl1.viewmodel.UserViewModel;

public class Test {
    public static void main(String[] args) {
        Mapper mapper = new Mapper();
        UserViewModel userViewModel = new UserViewModel();
        var user = mapper.convertToUser(userViewModel);
        System.out.println("User 1: " + user);
        var user1 = mapper.convertToUser(userViewModel);
        System.out.println("User 2: " + user1);
    }
}
