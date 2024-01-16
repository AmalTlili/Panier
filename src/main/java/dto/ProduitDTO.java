package dto;

import entity.Categorie;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProduitDTO {
    private Long produitId;
    private String nom;
    private String prix;
    private String imageUrl;
    private Long categorieId;
    private String categorieLabel;
}
