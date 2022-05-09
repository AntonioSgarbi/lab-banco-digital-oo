package tech.antoniosgarbi.desafiobanco.dto.auth;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginRequest {
    private String login;
    private String password;
    private String username;

}
