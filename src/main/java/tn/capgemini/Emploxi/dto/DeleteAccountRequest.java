package tn.capgemini.Emploxi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteAccountRequest {
    private Long userId;
    private String token;
}
