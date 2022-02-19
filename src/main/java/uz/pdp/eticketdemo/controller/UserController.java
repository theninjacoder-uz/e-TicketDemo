package uz.pdp.eticketdemo.controller;

import org.springframework.web.bind.annotation.*;
import uz.pdp.eticketdemo.model.dto.user.UserDto;
import uz.pdp.eticketdemo.response.ApiResponse;
import uz.pdp.eticketdemo.service.user.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    //Constructor injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ApiResponse addUser(@RequestBody UserDto userDto){
        return userService.add(userDto);
    }
}
