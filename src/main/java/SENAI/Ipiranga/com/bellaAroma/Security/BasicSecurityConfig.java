package SENAI.Ipiranga.com.bellaAroma.Security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@EnableWebSecurity
@Configuration 
public class BasicSecurityConfig {
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean//pemisao e gereciamente de rota
	public AuthenticationManager authenticationManager(
			HttpSecurity http,
			PasswordEncoder passwordEncoder,
			UserDetailsService userDetailsService) throws Exception {
			AuthenticationManagerBuilder builder = 
			http.getSharedObject(AuthenticationManagerBuilder.class);
			builder.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder);
			return builder.build();
	}
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
		.csrf(csrf->csrf.disable())
		.cors(cors->{})
		.sessionManagement(session -> 
		 session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.authorizeHttpRequests(auth -> auth
				.requestMatchers("/funcionario/cadastrar").permitAll()
            .requestMatchers("/funcionario/logar").permitAll()
            .requestMatchers("/funcionario/id/{id}").permitAll()
            .requestMatchers("/funcionario/nome/{nome}").permitAll()
            .requestMatchers("/funcionario/status/{status}").permitAll()
            .requestMatchers("/funcionario/npedido/{nPedido}").permitAll()
            .requestMatchers("/funcionario/delete/{idFuncionario}").permitAll()
			.requestMatchers("/produto/idProduto/{idProduto}").permitAll()
			.requestMatchers("/produto/quantidade/{quantidade}").permitAll()
			.requestMatchers("/produto/preco/{valorVenda}").permitAll()
			.requestMatchers("/produto/nome/{nome}").permitAll()
			.requestMatchers("/produto/atualizar/{idProduto}").permitAll()
			.requestMatchers("/funcionario/atualizar/{idFuncionario}").permitAll()
			.requestMatchers("/produto/deletar/{idProduto}").permitAll()
			.requestMatchers("/produto/cadastrar").permitAll()
			 .requestMatchers("/tipoproduto/cadastrar").permitAll()
            .requestMatchers("/tipoproduto/id/{idTipoProduto}").permitAll()
            .requestMatchers("/tipoproduto/tipo/{tipo}").permitAll()
            .requestMatchers("/tipoproduto/codigo/{codproduto}").permitAll()
            .requestMatchers("/tipoproduto/atualizar").permitAll()
            .requestMatchers("/tipoproduto/deletar/{id}").permitAll()
			.requestMatchers("/atualizar").permitAll()
			.requestMatchers("/deletar/{id}").permitAll()
			.requestMatchers("/Vandas").permitAll()
			.requestMatchers("/idVendas/{idVendas}").permitAll()
			.requestMatchers("/valor/{valor}").permitAll()
			.requestMatchers("/atualizar").permitAll()
			.requestMatchers("/deletar/{idVendas}").permitAll()
				.anyRequest().authenticated());
				http.httpBasic(basic->{});
				return http.build();	
	}
}
