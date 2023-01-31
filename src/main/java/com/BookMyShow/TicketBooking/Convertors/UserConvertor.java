package com.BookMyShow.TicketBooking.Convertors;

import com.BookMyShow.TicketBooking.Models.UserEntity;
import com.BookMyShow.TicketBooking.RequestDtos.UserRequestDto;

public class UserConvertor {

    public static UserEntity convertToUserEntity(UserRequestDto userRequestDto){
        UserEntity userEntity = UserEntity.builder().name(userRequestDto.getName())
                .mobileNo(userRequestDto.getMobileNo()).build();
        return userEntity;
    }
}
