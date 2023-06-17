package com.example.demo.security;

import com.example.demo.model.dto.UserDTO;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
public class UserRegistrationDetails implements UserDetails {

  private String username;
  private String password;
  private boolean isVerified;
  private List<GrantedAuthority> authorities;

  public UserRegistrationDetails(UserDTO user) {
    this.username = user.getLogin();
    this.password = user.getPassword();
    this.isVerified = user.isVerified();
    this.authorities =
        Arrays.stream(user.getRole().getName().split(","))
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return isVerified;
  }
}
