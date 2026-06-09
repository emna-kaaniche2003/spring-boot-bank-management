package tn.enis.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompteDTO {
    private String rib;
    private BigDecimal solde;
}