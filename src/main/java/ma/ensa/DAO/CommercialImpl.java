package ma.ensa.DAO;

import ma.ensa.Module.Commercial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class CommercialImpl implements CommercialDAO{
    // permet d'extraire les elements de la base de données et mettre dans une ArrayList
    @Override
    public Set<Commercial> SelectAll() {
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return null;
        }

        String query = "SELECT * FROM commercial;";
        Set<Commercial> commercials = new HashSet<>();
        try(PreparedStatement preparedStatement = conn.prepareStatement(query)){

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Commercial commercial = new Commercial(resultSet.getInt("matricule"),resultSet.getString("nom"),
                        resultSet.getString("prenom"));
                commercials.add(commercial);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBConnection.close();
        return commercials;

    }

    // permet de supprimer un commercial à partie de son matricule
    @Override
    public void DeleteById(int matricule) {


        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return;
        }
        String query = "DELETE FROM commercial WHERE matricule=?;";
        try(PreparedStatement preparedStatement = conn.prepareStatement(query)){

        preparedStatement.setInt(1,matricule);
        preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBConnection.close();
    }
}
