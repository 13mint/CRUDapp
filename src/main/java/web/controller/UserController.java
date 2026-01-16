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

    @GetMapping("/addUser")
    public String addUser( Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    public String saveUser(@ModelAttribute User user) {
        if(!userServiceImpl.existsById(user.getId())){
            userServiceImpl.save(user);
        } else{
            userServiceImpl.update(user);
        }
        return "redirect:/users";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(User user) {
        userServiceImpl.delete(user.getId());
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUser(Model model, @PathVariable long id) {
        model.addAttribute("user", userServiceImpl.findById(id));
        return "users";
    }
}
