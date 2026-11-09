package nz.ac.kanban;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CardRepository repository = new CardRepository();
        try {
            List<Card> cards = repository.findAll();
            System.out.println("VIRTUAL KANBAN - ITERATION 1");
            System.out.println("Cards retrieved: " + cards.size());
            for (Card card : cards) {
                System.out.printf("%d | %s | %s | %s | %s | %s | %s%n",
                    card.cardID(), card.details(), card.owner(), card.holder(),
                    card.status(), card.swimlane(), card.timestamp());
            }
        } catch (SQLException exception) {
            System.err.println("Database query failed: " + exception.getMessage());
            System.exit(1);
        }
    }
}
