package tech.antoniosgarbi.desafiobanco.dto.auth;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class  TokenRefreshRequest {
  private String refreshToken;
}
