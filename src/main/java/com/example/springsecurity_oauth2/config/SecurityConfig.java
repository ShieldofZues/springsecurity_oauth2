package com.example.springsecurity_oauth2.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.AuthorizedUrl;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    public SecurityConfig() {
    }

    /**
     * @return
     * @Bean 的意义是为使授权服务器的@Autowired AuthenticationManager
     */
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    /**
     * @return
     * @Bean 的意义是为使授权服务器的@Autowired UserDetailsService
     */
    @Bean
    protected UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }

    /**
     * 默认加两个角色的用户
     *
     * @param auth
     * @throws Exception
     */
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        ((InMemoryUserDetailsManagerConfigurer) auth.inMemoryAuthentication().withUser("admin").password("$2a$10$kwLIAqAupvY87OM.O25.Yu1QKEXV1imAv7jWbDaQRFUFWSnSiDEwG").roles(new String[]{"admin"}).and()).withUser("user").password("$2a$10$kwLIAqAupvY87OM.O25.Yu1QKEXV1imAv7jWbDaQRFUFWSnSiDEwG").roles(new String[]{"user"});
    }

    /**
     * oauth的拦截逻辑 如：登陆不拦截，不然没法获取token
     *
     * @param http
     * @throws Exception
     */
    protected void configure(HttpSecurity http) throws Exception {
        ((HttpSecurity) ((AuthorizedUrl) http.antMatcher("/oauth/**").authorizeRequests().antMatchers(new String[]{"/oauth/**"})).permitAll().and()).csrf().disable();
    }
}
