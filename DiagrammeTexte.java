package projet;

public class DiagrammeTexte extends Diagramme {

	private String[] description;

	public DiagrammeTexte() {
		super();
		this.description = new String[0];
	}

	public String[] getDescription() {
		return this.description;
	}

	protected void ajouter(Type T) {
		listeDesTypes.add(T);
		this.description = new String[this.description.length + 1];
	}

	public void decrire(int NomPackage, int Attributs, int Constructeurs,
			int Methodes, int Nom, int NomType) {

		String Newligne = System.getProperty("line.separator");
		if (NomPackage == 1) {
			for (int i = 0; i < listeDesTypes.size(); i++) {
				this.description[i] = this.description[i]
						+ listeDesTypes.get(i).getNomPackage();
			}
		}

		if (NomType == 1) {
			for (int i = 0; i < listeDesTypes.size(); i++) {
				this.description[i] = this.description[i]
						+ listeDesTypes.get(i).addDescriptionNomType();
			}
		}

		if (Nom == 1) {
			for (int i = 0; i < listeDesTypes.size(); i++) {
				this.description[i] = this.description[i]
						+ listeDesTypes.get(i).addDescriptionNom() + Newligne;
			}
		}

		if (Attributs == 1) {
			for (int i = 0; i < listeDesTypes.size(); i++) {
				this.description[i] = this.description[i] + Newligne
						+ "Attributs :" + Newligne;
				String[] str = listeDesTypes.get(i).getAttributs();
				for (int j = 0; j < str.length; j++) {
					this.description[i] = this.description[i] + str[j]
							+ Newligne;
				}
			}
		}

		if (Constructeurs == 1) {
			for (int i = 0; i < listeDesTypes.size(); i++) {
				this.description[i] = this.description[i] + Newligne
						+ "Constructeurs :" + Newligne;
				String[] str = listeDesTypes.get(i).getConstructeurs();
				for (int j = 0; j < str.length; j++) {
					this.description[i] = this.description[i] + str[j]
							+ Newligne;
				}
			}
		}

		if (Methodes == 1) {
			for (int i = 0; i < listeDesTypes.size(); i++) {
				this.description[i] = this.description[i] + Newligne
						+ "Methodes :" + Newligne;
				String[] str = listeDesTypes.get(i).getMethodes();
				for (int j = 0; j < str.length; j++) {
					this.description[i] = this.description[i] + str[j]
							+ Newligne;
				}
			}
		}

		for (int i = 0; i < this.description.length; i++) {
			System.out.println(this.description[i]);
		}

	}
}