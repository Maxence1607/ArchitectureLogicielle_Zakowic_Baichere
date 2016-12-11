package projet;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import org.jfree.graphics2d.svg.SVGGraphics2D;
import org.jfree.graphics2d.svg.SVGUtils;

public class DiagrammeSVG extends Diagramme {

	private SVGGraphics2D description;
	private Color textecolor;
	private Color shapecolor;
	private float epaisseurTraitBoite;
	private Font police;

	public DiagrammeSVG() {
		super();
		this.description = new SVGGraphics2D(1000, 1000);
		this.epaisseurTraitBoite = 2;
		// TODO Auto-generated constructor stub
	}

	public void setTexteColor(Color c) {
		this.textecolor = c;
	}

	public void setShapeColor(Color c) {
		this.shapecolor = c;
	}

	public void setEpaisseurTraitBoite(Float e) {
		this.epaisseurTraitBoite = e;
	}

	public void setPolice(Font police) {
		this.police = police;
	}

	@Override
	public void decrire(int NomPackage, int Attributs, int Constructeurs,
			int Methodes, int Nom, int NomType) throws IOException {
		// TODO Auto-generated method stub
		this.description.setPaint(textecolor);
		this.description.setFont(police);
		int taille1 = 20;
		if (NomPackage == 1) {
			for (int i = 0; i < listeDesTypes.size(); i++) {
				this.description.drawString(listeDesTypes.get(i)
						.addDescriptionNomPackage(), 20 + 300 * i, taille1);
			}
			taille1 = taille1 + 20;
		}
		int taille2 = taille1;

		if (NomType == 1) {
			for (int i = 0; i < listeDesTypes.size(); i++) {
				this.description.drawString(listeDesTypes.get(i)
						.addDescriptionNomType(), 20 + 300 * i, taille2);
			}
			taille2 = taille2 + 20;
		}
		int taille3 = taille2;
		if (Nom == 1) {
			for (int i = 0; i < listeDesTypes.size(); i++) {
				this.description.drawString(listeDesTypes.get(i)
						.addDescriptionNom(), 20 + 300 * i, taille3);
			}
			taille3 = taille3 + 20;
		}

		int taille4 = taille3;
		int lastmax = 20;
		if (Attributs == 1) {
			taille4 = taille4 + 20;
			for (int i = 0; i < listeDesTypes.size(); i++) {
				int newmax = 20;
				this.description.drawString("Attributs :", 20 + 300 * i,
						taille4);
				String[] str = listeDesTypes.get(i).getAttributs();
				for (int j = 0; j < str.length; j++) {
					this.description.drawString(str[j], 20 + 300 * i, taille4
							+ 20 * (j + 1));
					newmax = newmax + 20;
				}
				lastmax = Math.max(newmax, lastmax);
			}
			taille4 = taille4 + lastmax;
		}

		int taille5 = taille4;

		lastmax = 20;
		if (Constructeurs == 1) {
			taille5 = taille5 + 20;
			for (int i = 0; i < listeDesTypes.size(); i++) {
				int newmax = 20;
				this.description.drawString("Constructeurs :", 20 + 300 * i,
						taille5);
				String[] str = listeDesTypes.get(i).getConstructeurs();
				for (int j = 0; j < str.length; j++) {
					this.description.drawString(str[j], 20 + 300 * i, taille5
							+ 20 * (j + 1));
					newmax = newmax + 20;
				}
				lastmax = Math.max(newmax, lastmax);
			}
			taille5 = taille5 + lastmax;
		}

		int taille6 = taille5;

		lastmax = 20;
		if (Methodes == 1) {
			taille6 = taille6 + 20;
			for (int i = 0; i < listeDesTypes.size(); i++) {
				int newmax = 20;
				this.description
						.drawString("Methodes :", 20 + 300 * i, taille6);
				String[] str = listeDesTypes.get(i).getMethodes();
				for (int j = 0; j < str.length; j++) {
					this.description.drawString(str[j], 20 + 300 * i, taille6
							+ 20 * (j + 1));
					newmax = newmax + 20;
				}
				lastmax = Math.max(newmax, lastmax);
			}
			taille6 = taille6 + lastmax;
		}

		this.description.setStroke(new BasicStroke(this.epaisseurTraitBoite));
		this.description.setPaint(shapecolor);
		for (int i = 0; i < listeDesTypes.size(); i++) {
			this.description.draw(new Rectangle(300 * i + 10, 5, 250, taille6));
		}

		SVGUtils.writeToSVG(new File("description.svg"),
				this.description.getSVGElement());

	}

}
