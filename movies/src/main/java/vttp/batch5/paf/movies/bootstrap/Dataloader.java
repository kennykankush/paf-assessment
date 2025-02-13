package vttp.batch5.paf.movies.bootstrap;

import java.sql.Date;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import vttp.batch5.paf.movies.models.Movie;

@Component
public class Dataloader {

  //TODO: Task 2

  public List<Movie> json2Movie() throws FileNotFoundException, IOException{

    File directory = new File("/..");

    File file = new File(directory,"movies_post_2010.zip");

    if (file.exists()){
      System.out.println("exists");
      System.out.println(file.getAbsolutePath());
      System.out.println(file.getCanonicalPath());
    } else {
      System.out.println("doesnt");
      System.out.println(file.getAbsolutePath());
      System.out.println(file.getCanonicalPath());
    }

    FileInputStream fis = new FileInputStream(file);
    BufferedInputStream bis = new BufferedInputStream(fis);
    ZipInputStream zis = new ZipInputStream(bis);
    ZipEntry entry = zis.getNextEntry();
    BufferedReader reader = new BufferedReader(new InputStreamReader(zis));

    String line;
    List<Movie> movies = new ArrayList<>();
    ObjectMapper mapper = new ObjectMapper();

    // line = reader.readLine();
    // System.out.println(line);
    // line = reader.readLine();
    // System.out.println(line);

    /*
    private String imdbId;
    private float voteAverage;
    private int voteCount;
    private Date releaseDate;
    private long revenue;
    private long budget;
    private int runtime;
    private String title;
    private String director;
    private String overview;
    private String tagline;
    private List<String> genres;
    private int imdbRating;
    private int imdbVotes;
     */

    while ((line = reader.readLine()) != null) {
      // System.out.println(line);

      JsonNode node = mapper.readTree(line);

      String dateJson = node.get("release_date").asText();
      String getStringYear = dateJson.substring(0,4);
      int getYear = Integer.parseInt(getStringYear);

      if (getYear >= 2018){

        Movie movie = new Movie();

        movie.setImdbId(node.get("imdb_id").asText());
        movie.setVoteAverage(node.get("vote_average").floatValue());
        movie.setVoteCount(node.get("vote_count").asInt());

        try {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        java.util.Date utilDate = dateFormat.parse(dateJson);
        Date date = new Date(utilDate.getTime());
        movie.setReleaseDate(date);

        } catch (Exception e) {
          e.printStackTrace();

        }

        movie.setRevenue(node.get("revenue").asLong());
        movie.setBudget(node.get("budget").asLong());
        movie.setRuntime(node.get("runtime").asInt());
        movie.setTitle(node.get("title").asText());
        movie.setDirector(node.get("director").asText());
        movie.setOverview(node.get("overview").asText());
        movie.setTagline(node.get("tagline").asText());
        movie.setGenres(node.get("genres").asText());
        movie.setImdbRating(node.get("imdb_rating").asInt());
        movie.setImdbVotes(node.get("imdb_votes").asInt());
      
        movies.add(movie);

      }
      

    }
    zis.closeEntry();
    zis.close();

    // System.out.println(movies.size()); //69515 //2093 if >=2018

    return movies;

    // System.out.println(entry.getName()); //should return movies_post_2010.json

    // byte[] bytes = zis.readAllBytes();

    

    //https://stackoverflow.com/questions/41249750/reading-json-objects-separated-by-new-line

    // ObjectMapper objectMapper = new ObjectMapper();

    // JsonParser parse = objectMapper.getFactory().createParser(zis);
    // JsonNode object 



    // JsonReader jsonReader = Json.createReader(zis);
    // JsonObject node = jsonReader.readArray();

    // System.out.println(node);



    // JsonNode json = objectMapper.readTree(zis);

  //  for (int i = 0; i < 5; i++){
  //   JsonNode json = objectMapper.readTree(zis);
  //   System.out.println(json);
  //  }

    // return objectMapper.readTree(zis);

  }


}


