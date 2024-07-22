package pkg1.pkg1.augmentation.des.taxes;
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 *
 * @author hichem
 */
public class AugmentationDesTaxes {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        
        System.out.println("Veuillez saisir la valeur actuelle de la taxe (en pourcentage) : \n");
        double taxeActuel = S.nextDouble();
        
        System.out.println("Veuillez saisir la nouvelle valeur de la taxe (en pourcentage) : \n" );
        double  nouvelleTaxe = S.nextDouble();
        
        System.out.println("Veuillez saisir le prix actuel du légume (taxes comprises, en euros) : \n");
        double prixActuel = S.nextDouble();
        
        double prixHorsTaxe = prixActuel / (1 + taxeActuel / 100); //  Prix TTC = Prit HT * (1 + taxe/100) alors Prix HT = Prix TTC / 1 + taxe/100 
        
        double nouveauPrix = prixHorsTaxe * (1 + nouvelleTaxe / 100); // Nouveau Prix TTC = Prix HT * (1 + Nouvelle Taxe/100)
        
        BigDecimal bd = new BigDecimal(nouveauPrix).setScale(2, RoundingMode.HALF_UP);// new BigDecimal(nouveauPrix) : Convertit le double nouveauPrix en un BigDecimal pour une manipulation précise.
        // .setScale(2, RoundingMode.HALF_UP) : Définit l'échelle (le nombre de chiffres après la virgule) à 2 et utilise le mode d'arrondi HALF_UP (arrondir à l'unité supérieure si le chiffre suivant est 5 ou plus, sinon arrondir à l'unité inférieure).
        
        nouveauPrix = bd.doubleValue();
        
        System.out.printf("Le nouveau prix arrondi au centime près : %.2f\n", nouveauPrix);

    }
    
}


/*
Pour faire face à des difficultés financières du gouvernement, la taxe sur les fruits et légumes a été augmentée. Il faut donc recalculer tous les prix afin de prendre en compte cette nouvelle taxe, que les commerçants vont bien entendu répercuter sur les clients.

Ce que doit faire votre programme :
Votre programme doit lire trois nombres décimaux : la valeur actuelle de la taxe sur les fruits et légumes (en pourcentage), la nouvelle valeur de la taxe (en pourcentage), puis le prix actuel d'un légume, taxes comprises, en euros. Il devra calculer et afficher le prix du légume avec la nouvelle valeur de la taxe, arrondi au centime près.

EXAMPLEs
EXAMPLE 1
input:

5.5
19.6
24.9
output:

28.23
EXAMPLE 2
input:

21.5
21.5
19.99
output:

19.99
COMMENTS
On rappelle qu'une taxe de 15% signifie que pour un prix hors-taxe de 100 euros, le prix avec taxe sera de 115 euros.


 */