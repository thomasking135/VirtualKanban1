package nz.ac.kanban;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** Encapsulates SQLite access so the UI does not execute SQL directly. */
public class CardRepository {
    private static final String DATABASE_URL = "jdbc:sqlite:Kanban.db";

    public List<Card> findAll() throws SQLException {
        String sql = "SELECT cardID, details, owner, holder, status, swimlane, timestamp "
                + "FROM Cards ORDER BY cardID";
        List<Card> cards = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                cards.add(new Card(
                    results.getInt("cardID"), results.getString("details"),
                    results.getString("owner"), results.getString("holder"),
                    results.getString("status"), results.getString("swimlane"),
                    results.getString("timestamp")));
            }
        }
        return cards;
    }
}
