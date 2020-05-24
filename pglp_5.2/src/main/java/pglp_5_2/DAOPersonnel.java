package pglp_5_2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DAOPersonnel extends DAO<Personnel>{

	private static final long serialVersionUID = -155707383354982018L;

	@Override
	public boolean creer(Personnel objet) throws IOException, SQLException {
		
		Connection connection =null;
		Properties proprieteconnection =new Properties();
		proprieteconnection.put("utilisateur", "utilisateur");
		proprieteconnection.put("mdp", "mdp");
		
		try {
			connection = DriverManager.getConnection("jdbc:derby:test;create=true", proprieteconnection);
			
			PreparedStatement requete = connection.prepareStatement("INSERT INTO personnel (nom, prenom, poste, datenaissance, numerotelephone) VALUES(?, ?, ?, ?, ?)");
			requete.setString(1, objet.getNom());
			requete.setString(2, objet.getPrenom());
			requete.setString(3, objet.getPoste());
			requete.setString(4, objet.getDateNaissance());
			requete.setString(5, objet.getNumeroTelephone());
			int test = requete.executeUpdate();
			if(test == 0)
			{
				connection.close();
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		connection.close();
		return true;
	}

	@Override
	public Personnel lire(String Nom, String Prenom) throws SQLException 
	{

		Connection connection =null;
		Properties proprieteconnection =new Properties();
		proprieteconnection.put("utilisateur", "utilisateur");
		proprieteconnection.put("mdp", "mdp");
		
		try
		{
			connection = DriverManager.getConnection("jdbc:derby:test;create=true", proprieteconnection);
			PreparedStatement requete = connection.prepareStatement("SELECT * FROM personnel WHERE Nom = ? AND Prenom = ?");
			requete.setString(1, Nom);
			requete.setString(2,Prenom);
			ResultSet test = requete.executeQuery();
			if(test.first())
			{
				HashSet<NumeroTelephone> t = new HashSet<NumeroTelephone>();
				String phones = test.getString("telephone");
				
				for(int i = 0; i < phones.length(); i+=10)
				{
					t.add(new NumeroTelephone(phones.substring(i, i+9)));
				}
				
				Personnel p = new Personnel.Builder(test.getString("nom"), test.getString("prenom")).poste(test.getString("poste")).datedenaissance(LocalDate.parse(test.getString("date"))).telephone(t).build();
								
				connection.close();
				return p;
			}
			
		} catch(SQLException e)
		{
			e.printStackTrace();
			connection.close();
			return null;
		}
		connection.close();
		return null;
	}

	@Override
	public boolean supprimer(String Nom, String Prenom) throws SQLException {
		Connection connection =null;
		Properties proprieteconnection =new Properties();
		proprieteconnection.put("utilisateur", "utilisateur");
		proprieteconnection.put("mdp", "mdp");
		
		try
		{
			connection = DriverManager.getConnection("jdbc:derby:test;create=true", proprieteconnection);
			PreparedStatement requete = connection.prepareStatement("DELETE FROM personnel WHERE Nom = ? AND Prenom = ?");
			requete.setString(1, Nom);
			requete.setString(2,Prenom);
			int test = requete.executeUpdate();
			if(test == 0)
			{
				return false;
			}
			
		} catch(SQLException e)
		{
			e.printStackTrace();
			connection.close();
			return false;
		}
		connection.close();
		return true;
	}

	@Override
	public boolean supprimer(Personnel objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean maj(Personnel objet) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return false;
	}
}
