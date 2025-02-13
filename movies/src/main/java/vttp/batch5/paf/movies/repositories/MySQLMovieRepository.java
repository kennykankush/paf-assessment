package vttp.batch5.paf.movies.repositories;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vttp.batch5.paf.movies.models.Movie;

@Repository
public class MySQLMovieRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  /*
   *private String imdbId;
    private float voteAverage;
    private int voteCount;
    private Date releaseDate;
    private long revenue;
    private long budget;
    private int runtime;
   */


  // TODO: Task 2.3
  // You can add any number of parameters and return any type from the method
  public void batchInsertMovies(List<Movie> movies) {

      jdbcTemplate.batchUpdate(SqlStatements.SQL_UPDATE_ROW, new BatchPreparedStatementSetter() {

        @Override
        public void setValues(PreparedStatement ps, int i) throws SQLException {
          Movie movie = movies.get(i);
          ps.setString(1, movie.getImdbId());
          ps.setFloat(2, movie.getVoteAverage());
          ps.setInt(3, movie.getVoteCount());
          ps.setDate(4, movie.getReleaseDate());
          ps.setLong(5, movie.getRevenue());
          ps.setLong(6, movie.getBudget());
          ps.setInt(7, movie.getRuntime());
        }
  
        @Override
              public int getBatchSize() {
                System.out.println("movies.size");
                  return movies.size();
              }
        
      });

    }
   
  
  
  // // TODO: Task 3
  // public List<Document> getProlificDirectors(List<Document> mongoSide){
    
  // }
}



