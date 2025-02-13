package vttp.batch5.paf.movies.repositories;

public class SqlStatements {

    public static final String SQL_UPDATE_ROW = """
            INSERT INTO imdb(
            imdb_id,
            vote_average,
            vote_count,
            release_date,
            revenue,
            budget,
            runtime
            )
            VALUES (
            ?,
            ?,
            ?,
            ?,
            ?,
            ?,
            ?
            )
            """;
    
}
