package com.BookMyShow.TicketBooking.Services;

import com.BookMyShow.TicketBooking.Convertors.UserConvertor;
import com.BookMyShow.TicketBooking.Models.UserEntity;
import com.BookMyShow.TicketBooking.Repositories.UserRepository;
import com.BookMyShow.TicketBooking.RequestDtos.UserRequestDto;
import com.BookMyShow.TicketBooking.ResponseDtos.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public String addUser(UserRequestDto userRequestDto){
        UserEntity userEntity = UserConvertor.convertToUserEntity(userRequestDto);
        userRepository.save(userEntity);
        return "User added Successfully";
    }

    public UserResponseDto getUser(String name){
        UserEntity userEntity = userRepository.findByName(name);
        UserResponseDto userResponseDto = UserResponseDto.builder().id(userEntity.getId())
                .name(userEntity.getName()).mobileNo(userEntity.getMobileNo()).build();
        return userResponseDto;
    }
}
