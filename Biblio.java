import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Biblio {

    static String name_user; // Nom de l'utilisateur
    static String name_admin; // Nom de l'administrateur
    static String password_admin; // Mot de passe administrateur
    static String password_user; // Mot de passe utilisateur
    static int nombre_de_livre_emprunter; // Nombre de livres empruntés
    static String titre_livre; // Titre du livre
    static String resumer_livre; // Résumé du livre
    static String auteur_livre; // Nom de l'auteur

    static boolean trouver;

    static Scanner sc = new Scanner(System.in);

    static List<String> administrateurs = new ArrayList<>(List.of("admin1", "admin2", "admin3")); // Liste des noms

    static List<String> utilisateurs = new ArrayList<>(List.of("user1", "user2", "user3")); // Liste des noms

    static List<String> adminPasswords = new ArrayList<>(List.of("pass1", "pass2", "pass3")); // Liste des mots de passe

    static List<String> userPasswords = new ArrayList<>(List.of("userpass1", "userpass2", "userpass3")); // Liste des

    static List<String> livres = new ArrayList<>(); // Liste des titres de livres

    static List<String> livresEmpruntes = new ArrayList<>();

    static List<String> auteurs = new ArrayList<>();

    static List<String> resumers = new ArrayList<>();

    public void setName_user(String oldName, String newName) {
        int index = utilisateurs.indexOf(oldName);
        if (index != -1) {
            utilisateurs.set(index, newName);
        }
    }

    public void setPassword_user(String name_user, String newPassword) {
        int index = utilisateurs.indexOf(name_user);
        if (index != -1) {
            userPasswords.set(index, newPassword);
        }
    }

    public void setTitre_livre(String oldTitle, String newTitle) {
        int index = livres.indexOf(oldTitle.toLowerCase());
        if (index != -1) {
            livres.set(index, newTitle);
        }
    }

    public void setAuteur_livre(String titre_livre, String newAuthor) {
        int index = livres.indexOf(titre_livre.toLowerCase());
        if (index != -1) {
            auteurs.set(index, newAuthor);
        }
    }

    public void setResumer_livre(String titre_livre, String newSummary) {
        int index = livres.indexOf(titre_livre.toLowerCase());
        if (index != -1) {
            resumers.set(index, newSummary);
        }
    }

    // Rechercher un compte utilisateur
    public static boolean rechercherUtilisateur(String name_user) {
        for (String utilisateur : utilisateurs) {
            if (utilisateur.equals(name_user)) {
                return true;
            }
        }
        return false;
    }

    // Supprimer un compte utilisateur
    public void supprimerUnUtilisateur(String name_user) {
        Iterator<String> iterator = utilisateurs.iterator();
        Iterator<String> passwordIterator = userPasswords.iterator();

        while (iterator.hasNext() && passwordIterator.hasNext()) {
            String utilisateur = iterator.next();
            passwordIterator.next();

            if (utilisateur.equals(name_user)) {
                System.out.println("Êtes-vous sûr de vouloir supprimer le compte " + name_user + "? (oui/non)");
                String confirmation = sc.next();
            
                // Récupérer le premier caractère de la réponse
                char firstChar = confirmation.toLowerCase().charAt(0);
            
                if (firstChar == 'o') { // 'o' pour "oui"
                    iterator.remove();
                    passwordIterator.remove();
                    System.out.println("Le compte " + name_user + " a été supprimé.");
                } else {
                    System.out.println("Suppression annulée");
                }
                return;
            }
            
            System.out.println("Le nom du compte ne correspond pas.");
        }            
    }

    // Crée un compte utilsateur
    public void creerUnUtilisateur() {
        System.out.println("Entrer le nom");
        name_user = sc.next();

        System.out.println("Entrer votre mot de passe");
        password_user = sc.next();

        utilisateurs.add(name_user);
        userPasswords.add(password_user);
    }

    // Modifier un compte utilisateur
    public void modifierUnUtilisateur() {
        System.out.println("Entrez le nom de l'utilisateur à modifier :");
        String oldName = sc.next();

        if (utilisateurs.contains(oldName)) {
            System.out.println("Que voulez-vous modifier ?");
            System.out.println("1: Nom");
            System.out.println("2: Mot de passe");

            int choix_modifierUnUtilisateur = sc.nextInt();

            switch (choix_modifierUnUtilisateur) {
                case 1:
                    System.out.println("Entrez le nouveau nom :");
                    String newName_user = sc.next();
                    setName_user(oldName, newName_user);
                    System.out.println("Nom mis à jour avec succès");
                    break;

                case 2:
                    System.out.println("Entrez le nouveau mot de passe :");
                    String newPassword_user = sc.next();
                    setPassword_user(oldName, newPassword_user);
                    System.out.println("Mot de passe mis à jour avec succès");
                    break;

                default:
                    System.out.println("Choix invalide");
            }
        } else {
            System.out.println("Utilisateur non trouvé");
        }
    }

    // Modifier un livre
    public void modifierUnLivre(String titre_livre_modif) {

        // Afficher le contenu de la liste des livres pour vérification
        System.out.println("Contenu de la liste des livres : " + livres);

        // Normalisation des chaînes pour comparaison
        int index = livres.indexOf(titre_livre_modif.toLowerCase());
        System.out.println("Index trouvé : " + index); // Ajouter pour débogage

        // Normalisation des chaînes pour comparaison
        // int index = livres.indexOf(titre_livre_modif.toLowerCase());
        if (index != -1) {
            System.out.println("Que voulez-vous modifier ?");
            System.out.println("1: Titre du livre");
            System.out.println("2: Nom de l'auteur");
            System.out.println("3: Résumé du livre");

            int choix_modifierUnLivre = sc.nextInt();
            sc.nextLine(); // pour consommer la nouvelle ligne après le nextInt()

            switch (choix_modifierUnLivre) {
                case 1:
                    System.out.println("Entrez le nouveau titre du livre :");
                    String newTitre_livre = sc.nextLine();
                    setTitre_livre(titre_livre_modif, newTitre_livre);
                    System.out.println("Le titre a été mis à jour avec succès");
                    break;

                case 2:
                    System.out.println("Entrez le nouveau nom de l'auteur :");
                    String newAuteur_livre = sc.nextLine();
                    setAuteur_livre(titre_livre_modif, newAuteur_livre);
                    System.out.println("Le nom de l'auteur a été mis à jour avec succès");
                    break;

                case 3:
                    System.out.println("Entrez le nouveau résumé du livre :");
                    String newResumer_livre = sc.nextLine();
                    setResumer_livre(titre_livre_modif, newResumer_livre);
                    System.out.println("Le résumé du livre a été mis à jour avec succès");
                    break;

                default:
                    System.out.println("Choix invalide");
            }
        } else {
            System.out.println("Livre non trouvé");
        }
    }

    // Supprimer un livre
    public void supprimerUnLivre(String titre) {
        Iterator<String> iterator = livres.iterator();
    
        while (iterator.hasNext()) {
            String livre = iterator.next();
            if (livre.contains(titre)) {
                System.out.println("Êtes-vous sûr de vouloir supprimer le livre " + titre + "? (oui/non)");
                String confirmation = sc.next();
    
                // Récupérer le premier caractère de la réponse
                char firstChar = confirmation.toLowerCase().charAt(0);
    
                if (firstChar == 'o') { // 'o' pour "oui"
                    iterator.remove();
                    System.out.println("Le livre " + titre + " a été supprimé.");
                } else {
                    System.out.println("Suppression annulée");
                }
                return;
            }
        }
        System.out.println("Livre non trouvé");
    }
    

    // Cree un livre
    public void creerUnLivre() {
        System.out.println("Entrer le titre du livre");
        String titre_livre = sc.nextLine(); // Lire le titre du livre
        livres.add(titre_livre); // Ajouter le titre du livre à la liste des titres

        System.out.println("Entrer le nom de l'auteur");
        String auteur_livre = sc.nextLine(); // Lire le nom de l'auteur
        auteurs.add(auteur_livre); // Ajouter le nom de l'auteur à la liste des auteurs

        System.out.println("Entrer le résumé du livre");
        String resumer_livre = sc.nextLine(); // Lire le résumé du livre
        resumers.add(resumer_livre); // Ajouter le résumé du livre à la liste des résumés
    }

    // Chercher Un livre
    public void chercherUnLivre(String titre) {
        for (String livre : livres) {
            if (livre.contains(titre)) {
                System.out.println("Livre trouvé: " + livre);
                return;
            }
        }
        System.out.println("Livre non trouvé");
    }

    // Afficher un livre
    public void afficherUnLivre() {
        if (livres.isEmpty()) {
            System.out.println("Aucun livre dans la bibliothèque.");
        } else {
            System.out.println("Liste des livres dans la bibliothèque : ");
            for (String livre : livres) {
                System.out.println(livre);
            }
        }
    }

    // Emprunter un livre
    public void emprunterUnLivre(String titre) {
        Iterator<String> iterator = livres.iterator();
        while (iterator.hasNext()) {
            String livre = iterator.next();
            if (livre.contains(titre)) {
                iterator.remove();
                livresEmpruntes.add(livre);
                System.out.println("Livre emprunté: " + livre);
                nombre_de_livre_emprunter++;
                return;
            }
        }
        System.out.println("Livre non disponible");
    }

    // Retourner un livre
    public void retournerUnLivre(String titre) {
        Iterator<String> iterator = livresEmpruntes.iterator();
        while (iterator.hasNext()) {
            String livre = iterator.next();
            if (livre.contains(titre)) {
                iterator.remove();
                livres.add(livre);
                System.out.println("Livre retourné: " + livre);
                nombre_de_livre_emprunter--;
                return;
            }
        }
        System.out.println("Livre non trouvé parmi les empruntés");
    }

    // Afficher les livres empruntés
    public void afficherLivresEmpruntes() {
        if (livresEmpruntes.isEmpty()) {
            System.out.println("Aucun livre emprunté.");
        } else {
            System.out.println("Livres empruntés : ");
            for (String livre : livresEmpruntes) {
                System.out.println(livre);
            }
        }
    }

   
        public static void main(String[] args) {
            Biblio biblio = new Biblio();
            Scanner sc = new Scanner(System.in);
            boolean exit = false;
    
            while (!exit) {
                System.out.println("Veuillez choisir votre compte de connexion");
                System.out.println("0: Quitter");
                System.out.println("1: Administrateur");
                System.out.println("2: Utilisateur");
    
                int choix_bienvenue = validateChoice(sc, 0, 2);
    
                switch (choix_bienvenue) {
                    case 0:
                        exit = true;
                        System.out.println("Merci d'avoir utilisé notre service. Au revoir !");
                        break;
                    case 1:
                        System.out.println("Entrer votre nom");
                        String name_admin = sc.next();
                        boolean trouver = false;
    
                        // Vérification du nom
                        for (String admin : Biblio.administrateurs) {
                            if (admin.equals(name_admin)) {
                                trouver = true;
                                break;
                            }
                        }
    
                        if (trouver) {
                            System.out.println("Entrer votre mot de passe");
                            String password_admin = sc.next();
                            boolean passwordCorrect = false;
                            for (int i = 0; i < Biblio.administrateurs.size(); i++) {
                                if (Biblio.adminPasswords.get(i).equals(password_admin)
                                        && Biblio.administrateurs.get(i).equals(name_admin)) {
                                    passwordCorrect = true;
                                    break;
                                }
                            }
    
                            if (passwordCorrect) {
                                System.out.println("Connexion réussie !");
                                int choix_admin;
                                do {
                                    System.out.println("Bienvenue à la bibliothèque cher admin");
                                    System.out.println("1: Afficher les comptes utilisateurs");
                                    System.out.println("2: Chercher un compte utilisateur");
                                    System.out.println("3: Supprimer un compte utilisateur");
                                    System.out.println("4: Créer un compte utilisateur");
                                    System.out.println("5: Modifier un compte utilisateur");
                                    System.out.println("6: Modifier un livre");
                                    System.out.println("7: Supprimer un livre");
                                    System.out.println("8: Ajouter un livre");
                                    System.out.println("9: Afficher les livres");
                                    System.out.println("0: Deconnexion");
    
                                    choix_admin = validateChoice(sc, 0, 9);
    
                                    switch (choix_admin) {
                                        case 1:
                                            for (int i = 0; i < Biblio.utilisateurs.size(); i++) {
                                                System.out.println("Le nom est : " + Biblio.utilisateurs.get(i)
                                                        + " le mot de passe est : " + Biblio.userPasswords.get(i));
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Entrer le nom de l'utilisateur");
                                            String name_user = sc.next();
    
                                            trouver = Biblio.rechercherUtilisateur(name_user);
    
                                            if (trouver) {
                                                System.out.println("Utilisateur trouvé !");
                                            } else {
                                                System.out.println("Echec de recherche, le nom de compte n'existe pas");
                                            }
                                            break;
                                        case 3:
                                            System.out.println("Entrer le numero de compte que vous souhaitez supprimer");
                                            name_user = sc.next();
                                            biblio.supprimerUnUtilisateur(name_user);
                                            break;
                                        case 4:
                                            biblio.creerUnUtilisateur();
                                            break;
                                        case 5:
                                            biblio.modifierUnUtilisateur();
                                            break;
                                        case 6:
                                            System.out.println("Entrer le titre du livre à modifier :");
                                            sc.nextLine(); // pour consommer la nouvelle ligne après le nextInt()
                                            String titre_livre_modif = sc.nextLine();
                                            biblio.modifierUnLivre(titre_livre_modif);
                                            break;
    
                                        case 7:
                                            System.out.println("Entrer le titre du livre à supprimer");
                                            String titre_livre = sc.next();
                                            biblio.supprimerUnLivre(titre_livre);
                                            break;
                                        case 8:
                                            biblio.creerUnLivre();
                                            break;
                                        case 9:
                                            biblio.afficherUnLivre();
                                            break;
                                        case 0:
                                            System.out.println("Merci d'avoir utilisé notre service");
                                            break;
                                        default:
                                            System.out.println("Choix invalide");
                                            break;
                                    }
                                } while (choix_admin != 0); // Ajouter une condition de sortie
                            } else {
                                System.out.println("Mot de passe incorrect");
                            }
                        } else {
                            System.out.println("Le nom de l'administrateur saisi est incorrect");
                        }
                        break;
    
                    case 2:
                        System.out.println("Entrer votre nom");
                        String name_user = sc.next();
                        trouver = false;
    
                        // Vérification du nom
                        for (String user : Biblio.utilisateurs) {
                            if (user.equals(name_user)) {
                                trouver = true;
                                break;
                            }
                        }
    
                        if (trouver) {
                            System.out.println("Entrer votre mot de passe");
                            String password_user = sc.next();
                            boolean passwordCorrect = false;
                            for (int i = 0; i < Biblio.utilisateurs.size(); i++) {
                                if (Biblio.userPasswords.get(i).equals(password_user)
                                        && Biblio.utilisateurs.get(i).equals(name_user)) {
                                    passwordCorrect = true;
                                    break;
                                }
                            }
    
                            if (passwordCorrect) {
                                System.out.println("Connexion réussie !");
                                int choix_user;
                                do {
                                    System.out.println("Bienvenue à la bibliothèque cher utilisateur");
                                    System.out.println("1: Chercher un livre");
                                    System.out.println("2: Deposer un livre");
                                    System.out.println("3: Emprunter un livre");
                                    System.out.println("4: Afficher les livres");
                                    System.out.println("5: Afficher les livres emprunté");
                                    System.out.println("0: Deconnexion");
    
                                    choix_user = validateChoice(sc, 0, 5);
    
                                    switch (choix_user) {
                                        case 1:
                                            System.out.println("Entrer le titre du livre à chercher");
                                            sc.nextLine(); // pour consommer la nouvelle ligne
                                            String titre_livre = sc.nextLine();
                                            biblio.chercherUnLivre(titre_livre);
                                            break;
                                        case 2:
                                            System.out.println("Entrer le titre du livre à retourner");
                                            String livreARetourner = sc.next();
                                            biblio.retournerUnLivre(livreARetourner);
                                            break;
                                        case 3:
                                            System.out.println("Entrer le titre du livre à emprunter");
                                            String livreAEmprunter = sc.next();
                                            biblio.emprunterUnLivre(livreAEmprunter);
                                            break;
                                        case 4:
                                            biblio.afficherUnLivre();
                                            break;
                                        case 5:
                                            biblio.afficherLivresEmpruntes();
                                            break;
                                        case 0:
                                            System.out.println("Merci d'avoir utiliser notre services");
                                            break;
                                        default:
                                            System.out.println("Choix invalide");
                                            break;
                                    }
                                } while (choix_user != 0); // Ajouter une condition de sortie
                            } else {
                                System.out.println("Mot de passe incorrect");
                            }
                        } else {
                            System.out.println("Le nom de l'utilisateur saisi est incorrect");
                        }
                        break;
    
                    default:
                        System.out.println("Choix invalide");
                        break;
                }
            }
            sc.close();
        }
    
        // Méthode pour valider et consommer les entrées incorrectes
        private static int validateChoice(Scanner sc, int min, int max) {
            while (true) {
                if (sc.hasNextInt()) {
                    int choix = sc.nextInt();
                    if (choix >= min && choix <= max) {
                        return choix;
                    } else {
                        System.out.println("Veuillez choisir un nombre entre " + min + " et " + max + ".");
                    }
                } else {
                    System.out.println("Veuillez entrer un nombre valide.");
                    sc.next(); // Consommer l'entrée incorrecte
                }
            }
        }
    }
