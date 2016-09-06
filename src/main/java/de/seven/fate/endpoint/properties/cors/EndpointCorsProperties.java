package de.seven.fate.endpoint.properties.cors;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static de.seven.fate.endpoint.properties.cors.EndpointCorsProperties.CORS_PREFIX;


/**
 * Configuration properties for MVC endpoints' CORS support.
 */
@Component
@ConfigurationProperties(prefix = CORS_PREFIX, ignoreUnknownFields = true)
@Profile("dev")
public class EndpointCorsProperties {

    static final String CORS_PREFIX = "endpoints.cors";

    private long maxAge;
    private boolean allowCredentials;

    @NotNull
    @Valid
    private Host host;

    public long getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(long maxAge) {
        this.maxAge = maxAge;
    }

    public boolean isAllowCredentials() {
        return allowCredentials;
    }

    public void setAllowCredentials(boolean allowCredentials) {
        this.allowCredentials = allowCredentials;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }
}
