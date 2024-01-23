package com.jeju.main.domain.user.controller;


import com.jeju.main.domain.user.dto.request.SignInRequestDto;
import com.jeju.main.domain.user.dto.request.SignUpRequestDto;
import com.jeju.main.domain.user.dto.response.SignInResponseDto;
import com.jeju.main.domain.user.dto.response.SignUpResponseDto;
import com.jeju.main.domain.user.service.UserService;
import com.jeju.main.global.common.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/signIn")
    public ResponseEntity<SuccessResponse<?>> signIn(@RequestBody final SignInRequestDto signInRequestDto){
        final SignInResponseDto signInResponseDto = userService.signIn(signInRequestDto.getUserId());
        return SuccessResponse.ok(signInResponseDto);
    }
    @PostMapping("/signUp")
    public ResponseEntity<SuccessResponse<?>> signUp(@RequestBody SignUpRequestDto signUpRequestDto){
        final SignUpResponseDto signUpResponseDto = userService.signUp(signUpRequestDto);
        return SuccessResponse.ok(signUpResponseDto);
    }
}
