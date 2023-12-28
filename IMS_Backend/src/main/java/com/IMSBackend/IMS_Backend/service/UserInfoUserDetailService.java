package com.IMSBackend.IMS_Backend.service;

import com.IMSBackend.IMS_Backend.model.Users;
import com.IMSBackend.IMS_Backend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.IMSBackend.IMS_Backend.config.UserDetailsInfo;
import java.util.Optional;

@Configuration
public class UserInfoUserDetailService implements UserDetailsService {
   @Autowired
   private UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<Users> users = usersRepository.findByUserName(username);
        return users.map(UserDetailsInfo::new).orElseThrow(()->new UsernameNotFoundException("User Does not Exist"));
    }

}
