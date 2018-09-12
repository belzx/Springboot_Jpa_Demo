//package com.lizhi.service;
//
//import com.lizhi.bean.Usersss;
//import com.lizhi.repository.UserRepository;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//
//public class CustomUserService implements UserDetailsService {
//
//@Resource
//private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        System.out.println("开始获取登录信息");
//        Usersss user = userRepository.findByUsername(s);
////        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
////        grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));
//        if(user == null){
//            throw  new UsernameNotFoundException("用户名不存在");
//        }
//        return user;
//    }
//}
