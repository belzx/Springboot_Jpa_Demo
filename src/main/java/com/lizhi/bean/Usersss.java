package com.lizhi.bean;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity(name="s_user")
public class Usersss implements UserDetails {

    private static final long serialVersionUID = 2128346393707857300L;

    @Id
//    @GeneratedValue //插入自增
    @Column(name = "u_id")
    private String id;

    private String username;

    private String password;

//    @ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER) 不太熟悉  以后再说
//    private List<SysRole> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
//        List<SysRole> roles = this.roles;
//
//        for(SysRole sr : roles){
//            auths.add(new SimpleGrantedAuthority(sr.getName()));
//        }
        auths.add(new SimpleGrantedAuthority("user"));
        auths.add(new SimpleGrantedAuthority("admin"));
        return auths;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
