package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.BaseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    BaseEntity baseEntity = new BaseEntity()

    @GetMapping("/create")
    public String createUser(Model model){

        model.addAttribute("user", new UserDTO() );
          model.addAttribute("rolers",.....);
        return "/user/create";
    }
}
