package com.megatest.service;

import com.megatest.dao.UserDetailRepository;
import com.megatest.dao.UserRepository;
import com.megatest.dto.RegisterDTO;
import com.megatest.model.UserDetail;
import com.megatest.model.Users;
import com.megatest.security.ApplicationUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDetailRepository userDetailRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var entity = userRepository.getUser(username);
        return new ApplicationUserDetails(entity);
    }

    public Boolean registerAccount(RegisterDTO dto){
        var entity = new Users(
                dto.getUsername(),
                dto.getPassword(),
                1l
        );
        userRepository.save(entity);
        var entityUserDetail = new UserDetail(
                entity.getId(),
                dto.getFirstName(),
                dto.getLastName(),
                1l
        );
        userDetailRepository.save(entityUserDetail);
        return true;
    }
}
