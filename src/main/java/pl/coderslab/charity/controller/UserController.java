package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.UserRepository;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/registration")
    public String addUser(Model model) {
        model.addAttribute("user", new User());

        return "register";
    }

    @PostMapping("/registration")
    public String addUserPost(@ModelAttribute @Valid User user, BindingResult bindingResult, Model model) {

        boolean isNewUser = userRepository.existsByEmail(user.getEmail());
        if (!user.getPassword().equals(user.getPasswordConfirm())) {
            return "errorregister";
        }
        if(isNewUser){
            bindingResult.rejectValue("email", "error.user", "User with this email is already exist");
        }
        if (bindingResult.hasErrors()) {
            return "errorregister";
        }

        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        user.setPasswordConfirm(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));

        userRepository.save(user);
        return "redirect:";
    }

    @GetMapping("/login")
    public String loginUser(Model model, @RequestParam String email, @RequestParam String password){

        User user = userRepository.findUserByEmailAndPassword(email, password);
        model.addAttribute("user", user);

        return "login";
    }

    @PostMapping("/login")
    public String loginUserPost(@ModelAttribute @Valid User user, BindingResult violations){
        if (violations.hasErrors()){
            return "errorlogin";
        }

        return "index";
    }
}
