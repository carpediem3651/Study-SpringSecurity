package com.example.TestSecurity.dto;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.TestSecurity.entity.UserEntity;

public class CustomUserDetails implements UserDetails {

    @Autowired
    private UserEntity userEntity;
    
    public CustomUserDetails(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        Collection<GrantedAuthority> collection = new ArrayList();

        collection.add(new GrantedAuthority() {
            
            @Override
            public String getAuthority() {

                return userEntity.getRole();
            }
        });

        return collection;
        
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return userEntity.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
    
}
