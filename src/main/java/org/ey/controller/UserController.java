package org.ey.controller;

import org.ey.dto.UserDto;
import org.ey.repository.*;
import org.ey.service.PhoneService;
import org.ey.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    final UserService userService;
    final PhoneService phoneService;

    public UserController(UserService userService,
                          PhoneService phoneService) {
        this.userService = userService;
        this.phoneService = phoneService;
    }

    @GetMapping("/users")
    public ResponseEntity findUsers()
    {
        try {
            return ResponseEntity.ok(userService.findAllUsers());
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }

    }

    @RequestMapping(value = "/createUser",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createUser(@RequestBody UserDto userDto) {
        try {
            return userService.createUser(userDto);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }

    }

}
