package sergiorosa.naturassp.security;

import java.security.Key;
import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import sergiorosa.naturassp.model.Usuario;

public class JWTTokenUtil {

	private static final String SECRET_KEY = "12345678901234561234567890123456";
	private static final int EXPIRATION = 2 * 60 * 1000;
	private static final String TK_PREFIX = "Bearer";
	private static final String HEADER_AUTH = "Authorization";

	public static String generateToken(Usuario usuario) {
		Key secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
		String jwt = Jwts.builder().setSubject(usuario.getUsername()).setIssuer("*Sergiorosa")
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
				.signWith(secretKey, SignatureAlgorithm.HS256).compact();

		return TK_PREFIX + jwt;
	}

	public static boolean isIssueValid(String issuer) {
		return issuer.equals("*Sergio rosa");
	}

	public static boolean isSubjectValid(String subject) {
		return  subject != null && subject.length() > 0;
		}
	
	public static boolean isExpirationValid(Date experiation) {
		return experiation.after(new Date(System.currentTimeMillis()));
	}
	
	public static Authentication decodeToken(HttpServletRequest request) {
		String token = request.getHeader(HEADER_AUTH);
		token = token.replace(TK_PREFIX, ""); // remove Bearer 
		
		Jws<Claims> jswClaims = Jwts.parserBuilder()
									.setSigningKey(SECRET_KEY.getBytes())
									.build()
									.parseClaimsJws(token);
		
		String username = jswClaims.getBody().getSubject();
		String emissor =  jswClaims.getBody().getIssuer();
		Date   expira  =  jswClaims.getBody().getExpiration();		
		
		if(isSubjectValid(username) && isIssueValid(emissor) && isExpirationValid(expira)) {
			return new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
			}
			return null;
		}
}
