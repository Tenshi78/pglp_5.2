package pglp_5_2;

import java.util.HashSet;

public class GroupePersonnel extends EstSerialisable implements Groupe{
	
	private static final long serialVersionUID = -815776725748013664L;
	private HashSet<Groupe> employes = new HashSet<Groupe>();
	
	@Override
	public String toString()
	{
		String chaine ="";
		for(Groupe g : employes)
		{
			chaine += (g.toString() + "\n");
		}
		return chaine;
	}
	
	public void AjouterPersonnel(Groupe g)
	{
		employes.add(g);
	}
	
	public void RetirerPersonnel(Groupe g)
	{
		employes.remove(g);
	}
}
