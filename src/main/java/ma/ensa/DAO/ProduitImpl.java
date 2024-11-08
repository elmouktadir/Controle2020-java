package ma.ensa.DAO;

import ma.ensa.Module.Produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProduitImpl implements ProduitDAO{
    @Override
    public void  add(Produit produit){

        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return;
        }

        String query = "INSERT INTO produit (id, nom, description, prix) VALUES (?,?,?,?);";
        try(PreparedStatement preparedstatement = conn.prepareStatement(query)){

            preparedstatement.setInt(1,produit.getId());
            preparedstatement.setString(2,produit.getNom());
            preparedstatement.setString(3,produit.getDescription());
            preparedstatement.setDouble(4,produit.getPrix());
            preparedstatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBConnection.close();

    }

    @Override
    public void Update(Produit produit){
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return;
        }

        String query = "UPDATE produit SET nom=?,description=?,prix=? WHERE id=?;";
        try(PreparedStatement preparedstatement = conn.prepareStatement(query)){

            preparedstatement.setString(1,produit.getNom());
            preparedstatement.setString(2,produit.getDescription());
            preparedstatement.setDouble(3,produit.getPrix());
            preparedstatement.setInt(4,produit.getId());
            preparedstatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBConnection.close();
    }
}
