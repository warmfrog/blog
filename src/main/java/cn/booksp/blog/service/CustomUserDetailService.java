package cn.booksp.blog.service;

import cn.booksp.blog.common.pojo.User;
import cn.booksp.blog.mapper.RoleMapper;
import cn.booksp.blog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CustomUserDetailService implements UserDetailsService, UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findUserByUsername(username);
        if(user != null){
            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getPassword(),
                    getAuthorities(user)
            );
        }
        else {
            throw new UsernameNotFoundException("user name not found");
        }

    }

    private Collection<? extends GrantedAuthority> getAuthorities(User user){
        String [] userRoles = userMapper.getRoles(user.getId())
                .stream()
                .map((role) -> role.getName())
                .toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }

    @Override
    public void addUser(User user) {
        int id = userMapper.insert(user);
        userMapper.setRoleUser(id);
    }

    @Override
    public void addAdmin(User user) {
        int id = userMapper.insert(user);
        userMapper.setRoleAdmin(id);
    }
}
