package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

  public final RoleService roleService;
  public final UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createUser(Model model){

        model.addAttribute("user", new UserDTO() );
          model.addAttribute("roles",roleService.findAll());//find All roles from DB
        model.addAttribute("users", userService.findAll());
        return "/user/create";// .html
    }
    @PostMapping("/create")
    public String insertUser(@ModelAttribute("user") UserDTO user){
        //(user object, roles, users)

        userService.save(user);

        return "redirect:/user/create";
    }

    @GetMapping("/update/{username}")
    public String editUser(@PathVariable("username") String username, Model model){

        //user object ${user}
       model.addAttribute("user",userService.findById(username));

        // roles ${roles}
        model.addAttribute("roles",roleService.findAll());

        // users ${users}
        model.addAttribute("users", userService.findAll());

        return "/user/update";
    }
    @PostMapping("/update")
    public String updateUser(){
      //update that user

        return "redirect:/user/create";
    }
}
