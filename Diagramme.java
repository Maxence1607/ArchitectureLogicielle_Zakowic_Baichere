package projet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Diagramme {
	protected ArrayList<Type> listeDesTypes;
	protected List<Couple> listeDesCouples;

	public Diagramme() {
		super();
		this.listeDesTypes = new ArrayList<Type>();
		this.listeDesCouples = new ArrayList<Couple>();
	}

	protected void ajouter(Type T) {
		listeDesTypes.add(T);
	}

	protected void enleverType(Type T) {
		listeDesTypes.remove(T);
	}

	protected void connecterType(Type T1, IRelation R, Type T2) {
		listeDesCouples.add(new Couple(T1, R, T2));
	}

	abstract void decrire(int NomPackage, int Attributs, int Constructeurs,
			int Methodes, int Nom, int NomType) throws IOException;
}