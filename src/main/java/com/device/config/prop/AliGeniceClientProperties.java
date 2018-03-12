package com.device.config.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
/**
 * 天猫精灵的client配置
 * @author ningque
 *
 */
@Configuration
@ConfigurationProperties(prefix="oauth.aligenie.client")
public @Data class AliGeniceClientProperties {
	
	private String client_id;
	private String client_secret;
	private String authorizedGrantTypes;
	private String scopes;
	private int accessTokenValiditySeconds;
	private int refreshTokenValiditySeconds;

}
