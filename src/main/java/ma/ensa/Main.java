package ma.ensa;

import ma.ensa.DAO.CommercialDAO;
import ma.ensa.DAO.CommercialImpl;
import ma.ensa.DAO.ProduitDAO;
import ma.ensa.DAO.ProduitImpl;
import ma.ensa.Module.Commercial;
import ma.ensa.Module.Produit;

import java.util.HashSet;
import java.util.Set;


public class Main {
    public static void main(String[] args) {

        ProduitDAO produitDAO = new ProduitImpl();
        CommercialDAO commercialDAO = new CommercialImpl();

        Set<Commercial> commercialSet = new HashSet<>();
        commercialSet = commercialDAO.SelectAll();

        for (Commercial commercial : commercialSet){
            System.out.println(commercial.toString());
        }

        commercialDAO.DeleteById(31);

        produitDAO.add(new Produit(16,"produit","description produit",1900));

        produitDAO.Update(new Produit(24,"produit update","description produit update",1700));
    }
}