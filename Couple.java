package projet;

public class Couple {
	private Type T1;
	private Type T2;
	private IRelation R;

	public Couple(Type T1, IRelation R, Type T2) {
		this.T1 = T1;
		this.T2 = T2;
		this.R = R;
	}

}