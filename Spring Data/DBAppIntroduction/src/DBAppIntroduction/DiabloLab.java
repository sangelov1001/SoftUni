package DBAppIntroduction;

import java.io.InputStream;
import java.sql.*;
import java.util.Calendar;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.Executor;

public class DiabloLab {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "sisko2400601");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", props);
        // if "no such user exist.."
        PreparedStatement statement = connection.prepareStatement(
                        "SELECT user_name, first_name, last_name, COUNT(users_games.id) AS games_played FROM users" +
                            " JOIN users_games ON users_games.user_id = users.id" +
                             " Where user_name = ?" +
                                " GROUP BY users_games.user_id");
            String username = scanner.nextLine();
            // на първото въпросче където имаме искаме да добавим username-a
            // това е заявка към която закачаме параметър
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                resultSet.getMetaData();
              String dbUsername = resultSet.getString("user_name");
              String dbFirstName = resultSet.getString("first_name");
             String dbLastName = resultSet.getString("last_name");
             Integer dbGamesCount = resultSet.getInt("games_played");

                System.out.printf("User: %s\n%s %s has played %d games\n", dbUsername, dbFirstName, dbLastName, dbGamesCount);
            } else {
            System.out.println("No such user exists");
        }
        }
    }