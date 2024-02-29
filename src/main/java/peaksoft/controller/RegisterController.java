package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.entity.Comment;
import peaksoft.entity.User;
import peaksoft.service.PostService;
import peaksoft.service.UserService;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor

public class RegisterController {

  private final UserService userService;
  private final PostService postService;

  // **************************  Login  *****************************************///
    @GetMapping("/login")
    public String createLogin(Model model){
        model.addAttribute("newUser", new User());
        return "createUserLogin";
    }
    @PostMapping("/login")
    public String Login(@ModelAttribute("newUser") User user, Model model) throws Exception {
        User currentUser = userService.login(user);
//        Comment comment = new Comment();
        model.addAttribute("userId", currentUser.getId());
        model.addAttribute("allPost",postService.getAll());
//        model.addAttribute("commentInfo",comment );
        return "/home-page";
    }
    // redirect:
    // **************************  Register  *****************************************///

    @GetMapping("/register")
    public String createRegister(Model model){
        model.addAttribute("newUser",new User());
        return "registerUser";
    }
    @PostMapping("/register")
    public String saveRegister(@ModelAttribute("newUser") User user){
        userService.saveUser(user);
        return "/createUserLogin";
    }








}
