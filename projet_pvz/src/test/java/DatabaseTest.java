import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseTest {

    public static void main(String[] args) {
        // Détails de la connexion à la base de données
        String url = "jdbc:mysql://localhost:3306/pvz?useSSL=false&serverTimezone=UTC";
        String username = "epf";  // Remplace par ton utilisateur MySQL
        String password = "mot_de_passe";  // Remplace par ton mot de passe

        try {
            // Se connecter à la base de données
            Connection connection = DriverManager.getConnection(url, username, password);

            // Si la connexion réussit, affiche ce message
            if (connection != null) {
                System.out.println("Connexion à la base de données réussie !");
            }

            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            // Si la connexion échoue, afficher l'erreur
            System.out.println("Erreur de connexion à la base de données : " + e.getMessage());
        }
    }
}
