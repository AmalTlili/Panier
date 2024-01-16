package dto;

import entity.Produit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategorieDTO {

    private Long categorieId;
    private String nom;
    private List<ProduitDTO> produits = new ArrayList<>();
}
