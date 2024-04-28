package com.example.bookmyshow.Dto;

import com.example.bookmyshow.models.Userstatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    private Long userId;
    private Userstatus userstatus;
}
