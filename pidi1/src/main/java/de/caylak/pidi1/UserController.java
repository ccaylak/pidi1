package de.caylak.pidi1;


import de.caylak.pidi1.model.User;
import de.caylak.pidi1.viewmodel.UserViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final Mapper mapper;

    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @PostMapping("/registration")
    public User registerUser(@Valid @RequestBody UserViewModel userViewModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(userViewModel.toString());
            throw new IllegalArgumentException();
        }
        System.out.println(userViewModel.toString());
        var userEntity = mapper.convertToUser(userViewModel);
        this.userService.addUser(userEntity);
        return userEntity;
    }
}





