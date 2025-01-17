package com.springboot.security.data.entity;

import java.io.Serializable;
import java.util.Collection;

public interface UserDetails extends Serializable {
    Collection<? extends GrantedAuthority> getAuthorities();

    public String getUsername();
    public String getPassword();
    public boolean isAccountNonExpired();
    public boolean isAccountNonLocked();
    public boolean isCredentialsNonExpired();
    public boolean isEnabled();
}