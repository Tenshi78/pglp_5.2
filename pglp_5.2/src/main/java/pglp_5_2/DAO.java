package pglp_5_2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

public abstract class DAO<T> implements Serializable{

	private static final long serialVersionUID = 2218718748708688119L;
	
	public abstract boolean creer(T objet) throws IOException, SQLException;
	public abstract boolean supprimer(T objet);
	public abstract boolean maj(T objet) throws FileNotFoundException, IOException;
	public Personnel lire(String Nom, String Prenom) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public GroupePersonnel lire(String identifiant) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean supprimer(String Nom, String Prenom) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}