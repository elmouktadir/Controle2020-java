package ma.ensa.DAO;
import ma.ensa.Module.Commercial;

import java.util.Set;

public interface CommercialDAO {
    Set<Commercial> SelectAll();
    public void DeleteById(int matricule);
}
