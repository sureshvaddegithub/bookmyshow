package com.BookMyShow.TicketBooking.Controllers;

import com.BookMyShow.TicketBooking.RequestDtos.UserRequestDto;
import com.BookMyShow.TicketBooking.ResponseDtos.UserResponseDto;
import com.BookMyShow.TicketBooking.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("add-user")
    public ResponseEntity<String> adduser(@RequestBody()UserRequestDto userRequestDto){
        String result = userService.addUser(userRequestDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("get-user")
    public ResponseEntity<UserResponseDto> getUser(@RequestParam String name){
        UserResponseDto userResponseDto =userService.getUser(name);
        return new ResponseEntity<>(userResponseDto,HttpStatus.CREATED);
    }
}
