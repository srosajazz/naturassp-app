package sergiorosa.naturassp.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class MyWebApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		System.out.println("-------> Access config");

		
		httpSecurity.csrf().disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/produto").permitAll()
		.antMatchers(HttpMethod.POST, "/login").permitAll()
		.anyRequest()
				.authenticated();


		httpSecurity.addFilterBefore(new TokenFilter(),UsernamePasswordAuthenticationFilter.class);
	}

}
