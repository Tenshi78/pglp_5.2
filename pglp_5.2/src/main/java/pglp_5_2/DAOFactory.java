package pglp_5_2;

public class DAOFactory {
	
	public static DAO<Personnel>getPersonnelDAO()
	{
		return new DAOPersonnel();
	}
	public static DAO<GroupePersonnel>getGroupeDAO()
	{
		return new DAOGroupePersonnel();
	}
}
