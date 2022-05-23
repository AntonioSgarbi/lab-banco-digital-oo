package tech.antoniosgarbi.desafiobanco.security.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.antoniosgarbi.desafiobanco.model.Cliente;
import tech.antoniosgarbi.desafiobanco.model.User;
import tech.antoniosgarbi.desafiobanco.repository.UserRepository;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  private final UserRepository userRepository;

  public UserDetailsServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

    return UserDetailsImpl.build(user);
  }

  public User criarUsuarioParaCliente(Cliente cliente, String email) {
    User user = new User();

    Argon2PasswordEncoder argon = new Argon2PasswordEncoder();
    String senhaEncripitada = argon.encode("senha_default");

    user.setPassword(senhaEncripitada);
    user.setUsername(cliente.getDocumento());
    user.setEmail(email);
    user.setRoles(List.of("CLIENTE"));
    user.setAdmin(false);
    user.setId(null);
    user.setLogin(cliente.getDocumento());

    return user;
  }

}
