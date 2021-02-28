package com.am.jsa.common.config;

import com.am.jsa.identity.service.AuthenticationService;
import com.am.jsa.logger.AmLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    AuthenticationService authenticationService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        String path = request.getRequestURI();
        AmLogger.printData("[Authorizaton] checking authorization for " + path);
        if(isPathAuthorized(path)){
            AmLogger.printData("[Authorizaton] skipping " + path);
        }else {
            String authorizationKey = request.getHeader(HttpHeaders.AUTHORIZATION);
            if (authorizationKey != null && authorizationKey.startsWith("Bearer ")) {
                com.am.jsa.identity.entity.User user=authenticationService.verifyToken(extractUserFromHeader(authorizationKey));
                if (user== null) {
                    AmLogger.printData("[Authorization] Request for " + path + " unauthorized");
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
                    //return;
                    SecurityContextHolder.getContext().setAuthentication(null);
                } else {
                    AmLogger.printData("[Authorization] Request for " + path + " authorized");
                    response.getHeaders(HttpHeaders.AUTHORIZATION).add(extractUserFromHeader(authorizationKey));

                    UserDetails userDetails=new User(user.getUserName(),user.getPassword(),new ArrayList<>());
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken
                            .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

                }
            } else {
                AmLogger.printData("[Authorization] Request for " + path + " unauthorized bearer not found");
            }
        }
        chain.doFilter(request, response);
    }

    private String extractUserFromHeader(String authHeader){
        return authHeader.split(" ")[1];
    }

    private boolean isPathAuthorized(String path){
        boolean authorized= false;
        if(path.contains("authenticate")){
            authorized=true;
        }
        return authorized;
    }
}
