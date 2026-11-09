# Virtual Kanban — BIT707 Assessment 1, Iteration 1

## Requirements
- Apache NetBeans with Maven support
- JDK 17 or newer supported JDK (project configured for Java 17)
- Internet access on first build to download Maven's sqlite-jdbc dependency

## Open and run
1. Extract this project, keeping `Kanban.db` beside `pom.xml`.
2. In NetBeans, File > Open Project and select `VirtualKanban`.
3. Set the project's Java platform to JDK 17 or newer.
4. Right-click project > Clean and Build. Maven downloads the SQLite JDBC dependency.
5. Right-click project > Run. Main class: `nz.ac.kanban.Main`.
6. Ensure the NetBeans/Maven working directory is the project root; the database URL is `jdbc:sqlite:Kanban.db`.
7. Output should report `Cards retrieved: 5` and list all five rows.

## Verify the database
Open `Kanban.db` in DB Browser for SQLite. The Cards table has seven fields and five rows. Or run `SELECT * FROM Cards;`.

## Evidence to capture
- DB Browser: table structure showing seven fields and types.
- DB Browser: Browse Data showing five records.
- NetBeans: `CardRepository.java` with connection and SELECT query.
- NetBeans: successful build and Run output showing five records without errors.

## Scope and design notes
This is the architecture proof for Task 4, not the complete GUI or CRUD implementation for later assessments. The schema uses the exact seven fields specified in Task 4. `details` is treated as the task name/description because the specified schema has no separate name field. `timestamp` uses SQLite-compatible `YYYY-MM-DD HH:MM:SS` text. A due-date field is not added because it is absent from the specified Iteration 1 schema; clarify it during later analysis.

The database access is encapsulated in `CardRepository`. The database is an existing file rather than an auto-created empty database. If you see `no such table: Cards`, check the working directory.

This project is a worked example. Read, test, adapt, and explain the code yourself before assessment submission.
