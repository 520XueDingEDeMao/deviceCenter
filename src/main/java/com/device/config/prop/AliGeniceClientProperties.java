package com.device.config.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
/**
 * 天猫精灵的client配置
 * @author ningque
 *
 */
@Configuration
@ConfigurationProperties(prefix="auth.aligenie.client")
public @Data class AliGeniceClientProperties {
	
	@Getter@Setter
	private String client_id;
	@Getter@Setter
	private String client_secret;
	@Getter@Setter
	private String authorizedGrantTypes;
	@Getter@Setter
	private String scopes;
	@Getter@Setter
	private int accessTokenValiditySeconds;
	@Getter@Setter
	private int refreshTokenValiditySeconds;

}
