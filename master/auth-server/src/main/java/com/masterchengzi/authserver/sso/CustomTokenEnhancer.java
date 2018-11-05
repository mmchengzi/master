package com.masterchengzi.authserver.sso;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang.RandomStringUtils.randomAlphabetic;
/**
*User zjc
*Created with IntelliJ IDEA
*Created on 2018-11-05 16:59
*令牌中的自定义声明
*/
public class CustomTokenEnhancer implements TokenEnhancer {
	@Override
	public OAuth2AccessToken enhance(
			OAuth2AccessToken accessToken,
			OAuth2Authentication authentication) {
		Map<String, Object> additionalInfo = new HashMap<>();
		additionalInfo.put("organization", authentication.getName() + randomAlphabetic(4));
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
		return accessToken;
	}
}
