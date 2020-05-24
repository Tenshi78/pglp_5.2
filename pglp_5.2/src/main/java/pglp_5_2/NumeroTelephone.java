package pglp_5_2;

public class NumeroTelephone extends EstSerialisable{
	
	private static final long serialVersionUID = -5563402245080102081L;
	private String numero;
	
	public NumeroTelephone(String num)
	{
		if(num.length() < 10)
		{
			this.numero = "0000000000";
		}
		else
		{
			this.numero = num;
		}
	}
	
	public String toString()
	{
		return this.numero;
	}

}
