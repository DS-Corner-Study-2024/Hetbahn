package com.springboot.security.service;

import com.springboot.security.data.entity.UserDetails;

public interface UserDetailsService {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}