package projet;

public class Type implements IType {

	private String nom;
	private String typeClasse;
	private String nomPaquet;
	private String[] attributs;
	private String[] constructeurs;
	private String[] methodes;

	public Type(String nom, String typeClasse, String nomPaquet,
			String[] attributs, String[] constructeurs, String[] methodes) {
		super();
		this.nom = nom;
		this.typeClasse = typeClasse;
		this.nomPaquet = nomPaquet;
		this.attributs = attributs;
		this.constructeurs = constructeurs;
		this.methodes = methodes;
	}

	public Type(Class<?> c) {
		this.nom = c.getName();
		this.methodes = Methodes.getMethods(c);
		this.nomPaquet = Methodes.getNomPackage(c);
		this.constructeurs = Methodes.getConstructeurs(c);
		this.attributs = Methodes.getVariablesInstance(c);
		this.typeClasse = Methodes.getType(c);
	}

	@Override
	public String getNomPackage() {
		// TODO Auto-generated method stub
		return this.nomPaquet;
	}

	@Override
	public String[] getAttributs() {
		// TODO Auto-generated method stub
		return this.attributs;
	}

	@Override
	public String[] getConstructeurs() {
		// TODO Auto-generated method stub
		return this.constructeurs;
	}

	@Override
	public String[] getMethodes() {
		// TODO Auto-generated method stub
		return this.methodes;
	}

	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return this.nom;
	}

	@Override
	public String getTypeClasse() {
		// TODO Auto-generated method stub
		return this.typeClasse;
	}

	@Override
	public String addDescriptionNomPackage() {
		// TODO Auto-generated method stub
		String description = "";
		String Newligne = System.getProperty("line.separator");
		return description = description + Newligne + this.getNomPackage();
	}

	@Override
	public String addDescriptionAttributs() {
		// TODO Auto-generated method stub
		String description = "";
		String[] str = this.getAttributs();
		String Newligne = System.getProperty("line.separator");
		for (int i = 0; i < str.length; i++) {
			description = description + Newligne + str[i];
		}
		return description;
	}

	@Override
	public String addDescriptionConstructeurs() {
		// TODO Auto-generated method stub
		String description = "";
		String[] str = this.getConstructeurs();
		String Newligne = System.getProperty("line.separator");
		for (int i = 0; i < str.length; i++) {
			description = description + Newligne + str[i];
		}
		return description;
	}

	@Override
	public String addDescriptionMethodes() {
		// TODO Auto-generated method stub
		String description = "";
		String[] str = this.getMethodes();
		String Newligne = System.getProperty("line.separator");
		for (int i = 0; i < str.length; i++) {
			description = description + Newligne + str[i];
		}
		return description;
	}

	@Override
	public String addDescriptionNom() {
		// TODO Auto-generated method stub
		String description = "";
		String Newligne = System.getProperty("line.separator");
		description = description + Newligne + this.getNom();
		return description;
	}

	@Override
	public String addDescriptionNomType() {
		// TODO Auto-generated method stub
		String description = "";
		String Newligne = System.getProperty("line.separator");
		description = description + Newligne + this.getTypeClasse();
		return description;
	}

	public String decrireTexte() {
		String str = "";
		return str + this.addDescriptionMethodes();
	};
}
