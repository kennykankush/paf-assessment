package vttp.batch5.paf.movies.repositories;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.stereotype.Repository;

import com.mongodb.client.MongoCollection;

import vttp.batch5.paf.movies.models.Movie;


@Repository
public class MongoMovieRepository {

    @Autowired
    private MongoTemplate mongoTemplate;


 // TODO: Task 2.3
 // You can add any number of parameters and return any type from the method
 // You can throw any checked exceptions from the method
 // Write the native Mongo query you implement in the method in the comments
 //
 //   db.collection.insertMany()
 //
 public void batchInsertMovies(List<Movie> movies) {

    MongoCollection<Document> collection = mongoTemplate.getCollection("imdb");

    List<Document> documents = new ArrayList<>();

    for (int i = 0; i < movies.size(); i++){
        Document document = new Document();
        Movie movie = movies.get(i);

        document.put("imdb_id", movie.getImdbId());
        document.put("title", movie.getTitle());
        document.put("directors", movie.getDirector());
        document.put("overview", movie.getOverview());
        document.put("tagline", movie.getTagline());
        document.put("genres", movie.getGenres());
        document.put("imdb_rating", movie.getImdbRating());
        document.put("imdb_votes", movie.getImdbVotes());

        documents.add(document);

    }

    collection.insertMany(documents);
    }


 // TODO: Task 2.4
 // You can add any number of parameters and return any type from the method
 // You can throw any checked exceptions from the method
 // Write the native Mongo query you implement in the method in the comments
 //
 //    native MongoDB query here
 //
 public void logError() {

 }

 // TODO: Task 3
 // Write the native Mongo query you implement in the method in the comments
 //
 //    native MongoDB query here
 // 
 //** db.imdb.aggregate([
//     {
//         $group: {
//             "_id": "$directors",
//             movies: { $sum: 1 },
            
//         }
//         },
//         {
//          $sort: {movies:-1}
             
//          }
        
//     ])
 //

 public List<Document> getProlificDirectors(int size){

    GroupOperation group = Aggregation.group("directors")
    .count().as("movies");

    SortOperation sort = Aggregation.sort(Sort.Direction.DESC, "movies");

    Aggregation aggregation = Aggregation.newAggregation(group,sort);

    AggregationResults<Document> results = mongoTemplate.aggregate(aggregation,
        "imdb",
        Document.class
    );

    List<Document> filtered = new ArrayList<>();

    List<Document> documents = results.getMappedResults();

    for (int i = 0; i < size; i ++){
        filtered.add(documents.get(i));

    }

    return filtered;

 }


}
