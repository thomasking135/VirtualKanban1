package nz.ac.kanban;

public record Card(int cardID, String details, String owner, String holder,
                   String status, String swimlane, String timestamp) { }
