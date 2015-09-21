package com.qurdao.qdsns.app.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qurdao.qdsns.utils.StringUtils;

/**
 * Created by xiex on 2015/9/17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenVo {

    @JsonProperty("error")
    private String error;
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private long expiresIn;
    @JsonProperty("scope")
    private String scope;
    @JsonProperty("refresh_token")
    private String refreshToken;

    public boolean loginFailure() {
        return StringUtils.hasText(error) && StringUtils.isEmpty(accessToken);
    }


    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
