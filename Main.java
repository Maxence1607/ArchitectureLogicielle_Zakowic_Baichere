package projet;

import java.io.IOException;
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Type type1 = new Type(Type.class);
		Type type2 = new Type(Couple.class);
		Type type3 = new Type(Diagramme.class);
		DiagrammeSVG dt = new DiagrammeSVG();
		dt.ajouter(type1);
		dt.ajouter(type2);
		dt.ajouter(type3);
		// dt.setShapeColor(Color.RED);
		// dt.setPolice(new Font("Courier", Font.BOLD, 10));
		// dt.setEpaisseurTraitBoite((float) 6.0);
		dt.decrire(1, 1, 1, 1, 1, 1);

		// Type type1 = new Type(Type.class);
		// Type type2 = new Type(Couple.class);
		// Type type3 = new Type(Diagramme.class);
		// DiagrammeTexte dt = new DiagrammeTexte();
		// dt.ajouter(type1);
		// dt.ajouter(type2);
		// dt.ajouter(type3);
		// dt.decrire(1, 1, 1, 1, 1, 1);
	}

}
