package de.caylak.pidl1;


import de.caylak.pidl1.model.User;
import de.caylak.pidl1.viewmodel.UserViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final Mapper mapper;

    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAllUsers();
    }

    @PostMapping("/registration")
    public User registerUser(@RequestBody UserViewModel userViewModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("Hallo");
        }

        var userEntity = mapper.convertToUser(userViewModel);
        this.userService.addUser(userEntity);
        return userEntity;
    }
}





