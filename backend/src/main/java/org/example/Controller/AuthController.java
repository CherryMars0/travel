package org.example.Controller;

import lombok.RequiredArgsConstructor;
import org.example.DAO.UserMapper;
import org.example.AuthorizationConfig.JwtUtils;
import org.example.entity.AuthRequest;
import org.example.Response.ResponseResult;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/User")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;
    private final JwtUtils jwtUtils;

    @PostMapping("auth")
    public ResponseResult authenticate (@RequestBody AuthRequest authRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUserName(),
                        authRequest.getPassword()
                )
        );
        final UserDetails user = userMapper.authUserByName(authRequest.getUserName());
        if(user != null){
            return ResponseResult.SUCCESS().setData(jwtUtils.generateToken(user));
        }else {
            return ResponseResult.FAILED().setData("some errors has occurred.");
        }
    }
}
