package tech.antoniosgarbi.desafiobanco.dto.auth;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LogOutRequest {
  private Long userId;
}
