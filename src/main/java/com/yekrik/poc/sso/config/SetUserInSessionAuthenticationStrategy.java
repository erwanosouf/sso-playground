package com.yekrik.poc.sso.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SetUserInSessionAuthenticationStrategy implements SessionAuthenticationStrategy {

    @Override
    public void onAuthentication(Authentication authentication, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws SessionAuthenticationException {
        Object principal = authentication.getPrincipal();
        System.out.println(principal);
        httpServletRequest.getSession().setAttribute("user", principal);
    }
}
