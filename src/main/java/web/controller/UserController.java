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
    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userServiceImpl.findAll());
        return "users";
    }

    public UserController(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/users/addUser")
    public String addUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("/users/saveUser")
    public String saveUser(@ModelAttribute User user) {
        if(!userServiceImpl.existsById(user.getId())){
            userServiceImpl.save(user);
        } else{
            userServiceImpl.update(user);
        }
        return "redirect:/users";
    }

    @GetMapping("/users/deleteUser")
    public String deleteUser(User user) {
        userServiceImpl.delete(user.getId());
        return "redirect:/users";
    }

    @GetMapping("/users/editUser")
    public String editUser(User user) {
        userServiceImpl.update(user);
        return "redirect:/users";
    }
}
