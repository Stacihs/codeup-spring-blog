//package com.codeup.codeupspringblog.services;
//
//import com.codeup.codeupspringblog.dao.UserRepository;
//import com.codeup.codeupspringblog.models.AdUserDetails;
//import com.codeup.codeupspringblog.models.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AdUserDetailsService implements UserDetailsService {
//    public UserRepository userDao;
//    public AdUserDetailsService(UserRepository userDao) {
//        this.userDao = userDao;
//    }
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userDao.findUserByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User details not found for username " + username);
//        } else {
//            return new AdUserDetails(user.getId(), user.getUsername(), user.getEmail(), user.getPassword());
//        }
//    }
//}
