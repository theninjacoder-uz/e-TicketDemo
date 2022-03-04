package uz.pdp.eticketdemo.controller.user;

import org.springframework.http.ResponseEntity;
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

    @PostMapping("/login")
    public ResponseEntity<?> adminLogin(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.adminLogin(userDto));
    }

    @GetMapping("{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable("username") String phoneNumber){
        return ResponseEntity.ok(userService.getUserByPhoneNumber(phoneNumber));
    }

}
