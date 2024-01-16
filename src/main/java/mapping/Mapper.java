package mapping;

import dto.CategorieDTO;
import dto.ProduitDTO;
import entity.Categorie;
import entity.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import services.CategorieService;
import services.ProduitService;

import javax.swing.text.Document;
import java.util.ArrayList;
import java.util.List;

@Component
public class Mapper {
    @Autowired
    private ProduitService produitService;
    @Autowired
    private CategorieService categorieService;
    public Mapper(ProduitService produitService, CategorieService categorieService){
        this.categorieService = categorieService;
        this.produitService =produitService;
    }
    public Categorie toCategorie(CategorieDTO categorieDTO) throws Exception{
        Categorie categorie = new Categorie();
        categorie.setCategorieId(categorieDTO.getCategorieId());
        categorie.setNom(categorieDTO.getNom());
        if (null != categorieDTO.getProduits() && !categorieDTO.getProduits().isEmpty()){
            List<Produit> produits = new ArrayList<>();
            for (ProduitDTO produitDTO : categorieDTO.getProduits()){
                Produit catProduit = new Produit();
                catProduit.setProduitId(produitDTO.getProduitId());
                catProduit.setNom(produitDTO.getNom());
                catProduit.setPrix(produitDTO.getPrix());
                catProduit.setImageUrl(produitDTO.getImageUrl().getBytes());
                produits.add(catProduit);
            }
            categorie.setProduits(produits);
        }
        return categorie;
    }
    public CategorieDTO toCategorieDTO(Categorie categorie) throws Exception{
        CategorieDTO categorieDTO = new CategorieDTO();
        categorieDTO.setCategorieId(categorie.getCategorieId());
        categorieDTO.setNom(categorie.getNom());
        if (null != categorie.getProduits() && !categorie.getProduits().isEmpty()){
            List<ProduitDTO> produitDTOS = new ArrayList<>();
            for (Produit produit : categorie.getProduits()){
                produitDTOS.add(toProduitDTO(produit));
            }
            categorieDTO.setProduits(produitDTOS);
        }
        return  categorieDTO;
    }
    public Produit toProduit(ProduitDTO produitDTO) throws Exception{
        Produit produit = new Produit();
        produit.setNom(produitDTO.getNom());
        produit.setPrix(produitDTO.getPrix());
        produit.setImageUrl(produitDTO.getImageUrl().getBytes());
        if (produitDTO.getCategorieId() != null){
            Categorie categorie = categorieService.retrieveCategorieById(produitDTO.getCategorieId());
            if (null != categorie){
                produit.setCategorie(categorie);
            }else {
                throw new Exception("Categorie dosen't exist");
            }
        }
        return produit;
    }
    public ProduitDTO toProduitDTO(Produit produit) throws Exception{
        ProduitDTO produitDTO = new ProduitDTO();
        produitDTO.setNom(produit.getNom());
        produitDTO.setPrix(produit.getPrix());
        produitDTO.setImageUrl(new String(produit.getImageUrl()));
        if (null != produit.getCategorie()){
            produitDTO.setCategorieId(produit.getCategorie().getCategorieId());
            produitDTO.setCategorieLabel(produit.getCategorie().getNom());
        }
        return produitDTO;
    }
}
