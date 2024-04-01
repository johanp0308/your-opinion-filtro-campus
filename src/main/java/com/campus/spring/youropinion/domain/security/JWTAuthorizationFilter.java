package com.campus.spring.youropinion.domain.security;

import io.jsonwebtoken.*;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {

    public boolean isJWTValid(String token) {
        if (!token.startsWith(Constans.TOKEN_BEARER_PREFIX))
            return false;

        String tokenJWT = token.substring(Constans.TOKEN_BEARER_PREFIX.length()).trim();
        try {
            Jwts.parserBuilder()
                    .setSigningKey(Constans.getSigningKey(Constans.SUPER_SECRET_KEY))
                    .build()
                    .parseClaimsJws(tokenJWT)
                    .getBody();
            return true;
        } catch (Exception e) {
            return false; // Lanzar Excepcions
        }
    }

    public Claims getClaims(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(Constans.getSigningKey(Constans.SUPER_SECRET_KEY))
                .build()
                .parseClaimsJws(token.replace("Bearer ", ""))
                .getBody();
        return claims;
    }

    private Claims setSigningKey(HttpServletRequest request) {
        String jwtToken = request.getHeader(Constans.HEADER_AUTHORIZACION_KEY).replace(Constans.TOKEN_BEARER_PREFIX,
                "");

        return Jwts.parserBuilder()
                .setSigningKey(Constans.getSigningKey(Constans.SUPER_SECRET_KEY))
                .build()
                .parseClaimsJws(jwtToken)
                .getBody();
    }

    private void setAuthentication(Claims claims) {
        @SuppressWarnings("unchecked")
        List<String> authorities = (List<String>) claims.get("authorities");
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
                authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    private boolean isJWTValid(HttpServletRequest request, HttpServletResponse response) {
        String authenticationHeader = request.getHeader(Constans.HEADER_AUTHORIZACION_KEY);
        if (authenticationHeader == null || !authenticationHeader.startsWith(Constans.TOKEN_BEARER_PREFIX))
            return false;
        return true;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            if (isJWTValid(request, response)) {
                Claims claims = setSigningKey(request);
                if (claims.get("authorities") != null) {
                    setAuthentication(claims);
                } else {
                    SecurityContextHolder.clearContext();
                }
            } else {
                SecurityContextHolder.clearContext();
            }
            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
            return;
        }
    }

}