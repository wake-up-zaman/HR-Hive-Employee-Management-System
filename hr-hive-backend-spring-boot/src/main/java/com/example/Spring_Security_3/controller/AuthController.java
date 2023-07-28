package com.example.Spring_Security_3.controller;


import com.example.Spring_Security_3.config.AppConstant;
import com.example.Spring_Security_3.entity.Role;
import com.example.Spring_Security_3.entity.UserInfo;
import com.example.Spring_Security_3.payload.AuthRequest;
import com.example.Spring_Security_3.payload.RegistrationRequest;
import com.example.Spring_Security_3.repository.RoleRepository;
import com.example.Spring_Security_3.repository.UserInfoRepository;
import com.example.Spring_Security_3.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/user")
public class AuthController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/registration")
    public String addNewUser(@RequestBody RegistrationRequest registrationRequest){
        UserInfo userInfo=new UserInfo();
        userInfo.setName(registrationRequest.getName());
        userInfo.setEmail(registrationRequest.getEmail());
        userInfo.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        Role role = this.roleRepository.findById(AppConstant.ROLE_ADMIN).get();
        userInfo.getRoles().add(role);
        userInfoRepository.save(userInfo);
        return "You are successfully registered !";
    }

    @PostMapping("/login")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) throws UsernameNotFoundException{

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword());
        System.out.println("Line-1: "+usernamePasswordAuthenticationToken);

        Authentication authentication=authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        System.out.println("Line-2: "+authentication);

        if(authentication.isAuthenticated()){
            return jwtService.generateToken(authRequest.getUsername());
        }
        else{
            throw new UsernameNotFoundException("invalid user request !");
        }
    }
}
