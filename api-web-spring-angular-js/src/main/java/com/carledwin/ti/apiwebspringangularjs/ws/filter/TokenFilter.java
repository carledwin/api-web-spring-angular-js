package com.carledwin.ti.apiwebspringangularjs.ws.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class TokenFilter extends GenericFilterBean{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		String header = req.getHeader("Authorization");
		
		if(header == null || !header.startsWith("Bearer ")){
			throw new ServletException("Token inexistente ou inválido.");
		}
		
		String token = header.substring(7); //extraindo somente o token
		
		//verificar validade do token
		try{
			Jwts.parser().setSigningKey("banana").parseClaimsJws(token).getBody();
		}catch(SignatureException e){
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token inválido.");
			//throw new ServletException("Token inválido");
		}catch(ExpiredJwtException e){
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token expirado.");
			//throw new ServletException("Token expirado.");
		}
		chain.doFilter(request, response);
	}
}
