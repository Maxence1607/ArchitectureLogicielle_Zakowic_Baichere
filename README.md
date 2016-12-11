# ArchitectureLogicielle_Zakowic_Baichere

Le but de ce projet est de définir un langage embarqué pour dessiner des diagrammes de types.

Notre diagramme est initialement vide.

# Ajout d'un type:
- Faire appel dans la classe Main à new Type().
- Définir la classe/interface à l'aide de la méthode .classe(Classe<?> c).
- Ajouter le type au diagramme à l'aide de la méthode .ajouter.

# Diagramme:
- Est instancié par une liste des types présents et par une liste de couples (un couple représentant une relation entre deux types).
 La classe diagramme est une classe abstraite dont héritent DiagrammeTexte et DiagrammeSVG. Ces deux classes vont nous permettre de     représenter notre diagramme sous format texte ou SVG.
- Pour obtenir la description de notre diagramme il suffit de faire appel à la méthode abstraite decrire(int NomPackage, int Attributs, int Constructeurs, int Methodes, int Nom, int NomType).
 Elle permet d'obtenir une représentation souple qui répond aux envies de l'utilisateur. En effet, il lui suffit de mettre une valeur égale à 1 à chaque fois qu'il souhaite la présence de cette information dans la représentation des types de son diagramme.
 
# Police, Couleur et Epaisseur:
  Dans la représentation SVG de notre digramme il est possible de modifier ces différents paramètres:
  - Pour la police des caractères faire appel à setPolice.
  - Pour la couleur du texte faire appel à setTexteColor.
  - Pour la couleur des formes faire appel à setShapeColor.
  - Pour l'épaisseur des formes faire appel à setEpaisseurTraitBoite.

Binôme: Aurélien Zakowic et Maxence Baichère
Projet sous la tutelle de Mr Hevé Grall
