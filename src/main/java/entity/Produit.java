package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long produitId;
    private String nom;
    private String prix;
    @Lob
    @Column(name="imageUrl", nullable=false, columnDefinition="longblob")
    private byte[] imageUrl;
    @ManyToOne
    @JoinColumn(name = "categorieId")
    private Categorie categorie;


}
