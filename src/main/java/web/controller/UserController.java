package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userServiceImpl;

    public UserController(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }


    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userServiceImpl.findAll());
        return "users";
    }

    @GetMapping("/users/addUser")
    public String addUser( Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping
    public String saveUser(@ModelAttribute User user) {
        if(!userServiceImpl.existsById(user.getId())){
            userServiceImpl.save(user);
        } else{
            userServiceImpl.update(user);
        }
        return "redirect:/users";
    }

    @PostMapping("/users/deleteUser/{id}(id=${user.id})")
    public String deleteUser(@PathVariable long id) {
        userServiceImpl.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}(id=${user.id})")
    public String editUser(@PathVariable long id,Model model) {
        model.addAttribute("user", userServiceImpl.findById(id));
        return "users";
    }
}
