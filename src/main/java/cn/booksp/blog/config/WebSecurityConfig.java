package cn.booksp.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("customUserDetailService")
    @Autowired
    private UserDetailsService customUserDetailsService;

    @Autowired
    DataSource dataSource;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
        auth.eraseCredentials(false);
//        auth.jdbcAuthentication().dataSource(dataSource).withUser("username").password("password").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css/**","/js/**", "/favicon.ico","/", "/error", "/article/get/**","/admin_lte/**").permitAll()
                .antMatchers("/admin/index").hasRole("ADMIN")
                .antMatchers("/admin/register-form","/admin/register").denyAll()
                .antMatchers("/article/list").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"article/add").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"article/multiple-add").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"article/images-add").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"article/delete/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"article/modify/*").hasRole("ADMIN")
                .and().formLogin().loginPage("/admin/login").defaultSuccessUrl("/admin/index").failureUrl("/admin/login?error").permitAll()
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/admin/logout")).logoutSuccessUrl("/admin/login").deleteCookies("remember-me").permitAll()
                .and().rememberMe()
                .and().exceptionHandling().accessDeniedPage("/deny");
    }

}























