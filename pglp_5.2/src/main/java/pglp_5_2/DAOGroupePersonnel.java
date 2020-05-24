package pglp_5_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DAOGroupePersonnel extends DAO<GroupePersonnel>{


	private static final long serialVersionUID = 1725544067789096309L;

	@Override
	public boolean creer(GroupePersonnel objet) throws IOException {
		
		File fichier = new File("DAO/GroupePersonnel" + objet.toString() + ".data");
		if(!fichier.exists())
		{
			ObjectOutputStream stream =  new ObjectOutputStream(new FileOutputStream(fichier)) ;
			stream.writeObject(objet);
			stream.close();
			
			return true;
		}
		System.out.print("Le fichier " + fichier.getName() + " existe déja création impossible." );
		
		return false;
	}

	@Override
	public GroupePersonnel lire(String identifiant) throws IOException, ClassNotFoundException {
		
		FileInputStream fichier = new FileInputStream("DAO/GroupePersonnel" + identifiant + ".data");
		ObjectInputStream input = new ObjectInputStream(fichier);
		GroupePersonnel groupe = (GroupePersonnel)input.readObject();
		
		input.close();
		fichier.close();
		
		return groupe;
	}

	@Override
	public boolean supprimer(GroupePersonnel objet) {
		File fichier = new File("DAO/GroupePersonnel" + objet.toString() + ".data");
		if(fichier.exists())
		{
			fichier.delete();
			return true;
		}
		System.out.print("Le fichier : " + fichier.getName() + " n'existe pas suppression impossible." );
		return false;
	}

	@Override
	public boolean maj(GroupePersonnel objet) throws FileNotFoundException, IOException {
		File fichier = new File("bdd/gpersonnel/" + objet.toString() + ".data");
		if(fichier.exists())
		{
			ObjectOutputStream stream =  new ObjectOutputStream(new FileOutputStream(fichier)) ;
			stream.writeObject(objet);
			stream.close();
			return true;
		}
		System.out.print("Le fichier " + fichier.getName() + " n'existe pas MAJ impossible." );
		return false;
	}

}
