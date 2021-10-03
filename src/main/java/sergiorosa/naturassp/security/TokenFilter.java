package sergiorosa.naturassp.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class TokenFilter extends OncePerRequestFilter {
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	
		
		
		System.out.println("************* Requesition pass through the Filter");
		
		if(request.getHeader("Authorization") != null) {
			
			//Decote JWT 
			Authentication auth = JWTTokenUtil.decodeToken(request);
			
			// if is valid, send to the context of the requisition with the token
			SecurityContextHolder.getContext().setAuthentication(auth);
		}
		
		
		filterChain.doFilter(request, response);


	}
}