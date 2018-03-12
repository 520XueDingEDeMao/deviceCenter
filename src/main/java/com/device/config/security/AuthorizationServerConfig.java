package com.device.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import com.device.config.prop.AliGeniceClientProperties;
/**
 * 授权服务器
 * @author ningque
 *
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	
	
	private TokenStore tokenStore = new InMemoryTokenStore();
	@Autowired
	private AliGeniceClientProperties aliGeniceProp;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailsService;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    	 clients.inMemory()
         .withClient(aliGeniceProp.getClient_id())//客户端ID
         .authorizedGrantTypes(aliGeniceProp.getAuthorizedGrantTypes(),"refresh_token")//设置验证方式
         .scopes(aliGeniceProp.getScopes())
         .secret(aliGeniceProp.getClient_secret())
         .accessTokenValiditySeconds(aliGeniceProp.getAccessTokenValiditySeconds())//token过期时间
         .refreshTokenValiditySeconds(aliGeniceProp.getRefreshTokenValiditySeconds()); //refresh过期时间
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(tokenStore)
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
    }
    
    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setSupportRefreshToken(true); // support refresh token
        tokenServices.setTokenStore(tokenStore); // use in-memory token store
        return tokenServices;
}
}
