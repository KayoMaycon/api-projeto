package br.com.apiecocoleta.projeto.security;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        
        http.authorizeHttpRequests((authz) -> authz
            .requestMatchers("/usuarios", "/usuarios/login", "/usuarios/create").permitAll()
            .anyRequest().authenticated()
        )

        .addFilterBefore(new SecurityFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();


        /*http    Backup------------
            .csrf((csrf) -> csrf.disable())
            .authorizeHttpRequests((authz) -> authz
            .requestMatchers(HttpMethod.POST,"/usuarios/login", "/usuarios").permitAll()

            .anyRequest().authenticated()
            )
            .httpBasic(withDefaults());

        http.addFilterBefore(new SecurityFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();*/

        
       
    }

}

