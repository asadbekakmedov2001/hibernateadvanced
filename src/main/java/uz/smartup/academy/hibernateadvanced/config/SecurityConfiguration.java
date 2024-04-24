package uz.smartup.academy.hibernateadvanced.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration {
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager detailsManager = new JdbcUserDetailsManager(dataSource);

        detailsManager.setUsersByUsernameQuery("SELECT username, password, enabled FROM user WHERE username = ?");
        detailsManager.setAuthoritiesByUsernameQuery("SELECT username, role FROM role WHERE username = ?");

        return detailsManager;
    }

//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//        UserDetails wayne = User.builder()
//                .username("wayne")
//                .password("{noop}secret")
//                .roles("STUDENT")
//                .build();
//
//        UserDetails martin = User.builder()
//                .username("martin")
//                .password("{noop}secret")
//                .roles("STUDENT", "INSTRUCTOR")
//                .build();
//
//        UserDetails melmen = User.builder()
//                .username("melmen")
//                .password("{noop}secret")
//                .roles("STUDENT", "INSTRUCTOR", "MANAGER")
//                .build();
//
//        UserDetails alex = User.builder()
//                .username("alex")
//                .password("{noop}secret")
//                .roles("STUDENT", "INSTRUCTOR", "MANAGER", "ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(wayne, martin, melmen, alex);
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authRegistry ->
                        authRegistry
                                .requestMatchers(HttpMethod.GET,  "/web/instructors", "/web/instructors/*").hasAnyRole("ADMIN", "MANAGER")
                                .requestMatchers(HttpMethod.POST, "/web/instructors/*").hasAnyRole("ADMIN", "MANAGER")
                                .requestMatchers(HttpMethod.PUT, "/web/instructors/*").hasAnyRole("ADMIN", "MANAGER")
                                .requestMatchers(HttpMethod.DELETE, "/web/instructors/*").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.GET, "/web/students/*").hasAnyRole("ADMIN", "MANAGER", "INSTRUCTOR")
                                .requestMatchers(HttpMethod.POST, "/web/students/*").hasAnyRole("ADMIN", "MANAGER", "INSTRUCTOR")
                                .requestMatchers(HttpMethod.PUT, "/web/students/*").hasAnyRole("ADMIN", "MANAGER", "INSTRUCTOR")
                                .requestMatchers(HttpMethod.DELETE, "/web/students/*").hasAnyRole("ADMIN", "MANAGER")
                                .requestMatchers(HttpMethod.GET, "/web/courses/*").hasAnyRole("ADMIN", "MANAGER", "INSTRUCTOR", "STUDENT")
                                .requestMatchers(HttpMethod.PUT, "/web/courses/*").hasAnyRole("INSTRUCTOR")
                                .requestMatchers(HttpMethod.DELETE, "/web/courses/*").hasAnyRole("INSTRUCTOR")
                                .requestMatchers(HttpMethod.GET, "/web/reviews/*").hasAnyRole("ADMIN", "MANAGER", "INSTRUCTOR", "STUDENT")
                                .requestMatchers(HttpMethod.DELETE, "/web/reviews/*").hasAnyRole("STUDENT")
                                .requestMatchers("/access-denied").permitAll()
                                .anyRequest().authenticated())
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied"))
                .formLogin(form ->
                        form.loginPage("/login")
                                .loginProcessingUrl("/authenticate")
                                .permitAll())
                .logout(LogoutConfigurer::permitAll);

        http.csrf(AbstractHttpConfigurer::disable);
        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
