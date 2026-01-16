package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @GetMapping("/saveUser")
    public String saveUser(User user) {
        if(!userService.existsById(user.getId())){
            userService.save(user);
        } else{
            userService.update(user);
        }
        return "redirect:/users";
    }

    public String deleteUser(User user) {
        userService.delete(user.getId());
        return "redirect:/users";
    }

    @GetMapping("/editUser")
    public String editUser(User user) {
        userService.update(user);
        return "redirect:/users";
    }
}
