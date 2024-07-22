# Augmentation des taxes

## Description 
Pour faire face à des difficultés financières du gouvernement, la taxe sur les fruits et légumes a été augmentée. Il faut donc recalculer tous les prix afin de prendre en compte cette nouvelle taxe, que les commerçants vont bien entendu répercuter sur les clients.

## Ce que doit faire votre programme :
Votre programme doit lire trois nombres décimaux : la valeur actuelle de la taxe sur les fruits et légumes (en pourcentage), la nouvelle valeur de la taxe (en pourcentage), puis le prix actuel d'un légume, taxes comprises, en euros. Il devra calculer et afficher le prix du légume avec la nouvelle valeur de la taxe, arrondi au centime près.

## EXAMPLEs
### EXAMPLE 1

input:
5.5
19.6
24.9

output:
28.23

### EXAMPLE 2

input:
21.5
21.5
19.99

output:
19.99

## COMMENTS
On rappelle qu'une taxe de 15% signifie que pour un prix hors-taxe de 100 euros, le prix avec taxe sera de 115 euros.

# Explication de code et resultat :  

## 1. Calcul du prix hors taxe
Le prix avec taxe peut être calculé à partir du prix hors taxe en ajoutant la taxe au prix hors taxe. Par exemple, si un produit coûte 100 euros hors taxe et la taxe est de 20%, alors le prix avec taxe sera :
Prix avec taxe = Prix hors taxe × (1 + taxe/ 100)

Donc, si vous avez le prix avec taxe et voulez trouver le prix hors taxe, vous devez diviser par le facteur d'augmentation de la taxe :
Prix hors taxe = Prix avec taxe / (1 + taxe/100)

Dans notre exemple, le prix actuel du légume inclut déjà la taxe actuelle, donc pour obtenir le prix hors taxe, nous utilisons la formule suivante :
double prixHorsTaxe = prixActuel / (1 + taxeActuelle / 100);

## 2. Application de la nouvelle taxe
Après avoir obtenu le prix hors taxe, vous appliquez la nouvelle taxe pour obtenir le nouveau prix avec la nouvelle taxe :
Nouveau prix avec taxe = Prix hors taxe × (1 + nouvelle taxe/100)
En Java, cela se traduit par :
double nouveauPrix = prixHorsTaxe * (1 + nouvelleTaxe / 100);

## 3. Arrondir au centime près
Dans les transactions financières, il est important d'arrondir les valeurs monétaires au centime près pour éviter les erreurs de calcul dues à la précision limitée des nombres flottants. Pour cela, nous utilisons la classe BigDecimal en Java, qui permet un contrôle précis de l'arrondi.
La ligne suivante :
BigDecimal bd = new BigDecimal(nouveauPrix).setScale(2, RoundingMode.HALF_UP);

fait les choses suivantes :

new BigDecimal(nouveauPrix) : Convertit le double nouveauPrix en un BigDecimal pour une manipulation précise.
.setScale(2, RoundingMode.HALF_UP) : Définit l'échelle (le nombre de chiffres après la virgule) à 2 et utilise le mode d'arrondi HALF_UP (arrondir à l'unité supérieure si le chiffre suivant est 5 ou plus, sinon arrondir à l'unité inférieure).

Enfin, pour obtenir à nouveau un double après l'arrondi, nous utilisons :
nouveauPrix = bd.doubleValue();

## Pourquoi utiliser BigDecimal ?
Les types float et double en Java peuvent introduire des erreurs de précision lors de l'arrondi à cause de la représentation binaire des nombres décimaux. BigDecimal permet de manipuler les nombres avec une précision arbitraire et fournit des méthodes pour arrondir de manière précise et contrôlée.