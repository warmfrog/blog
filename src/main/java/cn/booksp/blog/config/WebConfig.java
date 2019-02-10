package cn.booksp.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/login?error").setViewName("login?error");
        registry.addViewController("/register-form").setViewName("register");
        registry.addViewController("/admin/login").setViewName("admin/pages/login");
        registry.addViewController("/admin/logout").setViewName("/admin/pages/login");
        registry.addViewController("/admin/register-form").setViewName("admin/pages/register");
        registry.addViewController("/deny").setViewName("admin/pages/403");
        registry.addViewController("/error").setViewName("admin/pages/error");
    }
}
