package de.seven.fate.service;

import de.seven.fate.endpoint.properties.cors.EndpointCorsProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "prototype")
public class CorsEndpointService implements EndpointService {

    private final EndpointCorsProperties endpointCorsProperties;

    @Autowired
    public CorsEndpointService(EndpointCorsProperties endpointCorsProperties) {
        this.endpointCorsProperties = endpointCorsProperties;
    }

    @Override
    public EndpointCorsProperties getEndpointCorsProperties() {
        return endpointCorsProperties;
    }
}
