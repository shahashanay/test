package com.example.auth0demo.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;


@Controller

public class LogoutHandler extends SecurityContextLogoutHandler {

    private final ClientRegistrationRepository registrationRepository;


    public LogoutHandler(ClientRegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        super.logout(request, response, authentication);
        String issuer = (String) registrationRepository.findByRegistrationId("auth0").getProviderDetails().getConfigurationMetadata().get("issuer");
        String clientId = registrationRepository.findByRegistrationId("auth0").getClientId();

        String returnTo = ServletUriComponentsBuilder.fromCurrentContextPath().build().toString();

        String logoutUrl = UriComponentsBuilder
        // .fromHttpUrl(issuer+"/v2/logout?client_id=JmnWabse2JrGaRKefAptV24u5GS2d05N&returnTo=http://localhost:8080")
                .fromHttpUrl(issuer+"/v2/logout?client_id=JmnWabse2JrGaRKefAptV24u5GS2d05N&returnTo=https://test-e5dy.onrender.com")
                .encode()
                .buildAndExpand(clientId, returnTo)
                .toUriString();

        try {
            response.sendRedirect(logoutUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
