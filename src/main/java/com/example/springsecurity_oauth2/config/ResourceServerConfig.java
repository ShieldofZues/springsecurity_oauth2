package com.example.springsecurity_oauth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.AuthorizedUrl;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * 资源服务器
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    public ResourceServerConfig() {
    }
    /**
     * 配置了资源ID
     */
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("resourceid").stateless(true);
    }
    /**
     * 通过授权服务器获取到访问令牌access_token，使用access_token来资源服务器获取资源
     * 以下逻辑大概就是 匹配以下该access_token对应的用户角色想要获取的资源是否可用
     */
    public void configure(HttpSecurity http) throws Exception {
        ((AuthorizedUrl) ((AuthorizedUrl) ((AuthorizedUrl) http.authorizeRequests().antMatchers(new String[]{"/api/admin/**"})).hasRole("admin").antMatchers(new String[]{"/api/user/**"})).hasRole("user").anyRequest()).authenticated();
    }
}
