package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;

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

    @PostMapping()
    public String saveUser(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addUser";
        }
        userServiceImpl.save(user);
        return "redirect:/users";
    }

    @PostMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id) {
        userServiceImpl.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/editUser/{id}")
    public String editUser(@PathVariable Long id,Model model) {
        model.addAttribute("user", userServiceImpl.findById(id));
        return "editUser";
    }

    @PostMapping("/update")
    public String updateUser(@Valid @ModelAttribute("user") User user,  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editUser";
        }
        userServiceImpl.update(user);
        return "redirect:/users";
    }

}
