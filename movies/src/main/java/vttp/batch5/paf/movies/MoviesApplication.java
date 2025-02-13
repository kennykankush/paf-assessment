package vttp.batch5.paf.movies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import vttp.batch5.paf.movies.bootstrap.Dataloader;
import vttp.batch5.paf.movies.models.Movie;
import vttp.batch5.paf.movies.repositories.MongoMovieRepository;
import vttp.batch5.paf.movies.repositories.MySQLMovieRepository;
import vttp.batch5.paf.movies.services.MovieService;

@SpringBootApplication
public class MoviesApplication implements CommandLineRunner {

	@Autowired
	private Dataloader dataloader;

	@Autowired
	private MySQLMovieRepository sqlRepo;

	@Autowired
	private MongoMovieRepository mongoRepo;

	@Autowired
	private MovieService movieService;


	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

	@Override
	public void run(String... args){

		try {
		List<Movie> movies = dataloader.json2Movie();
		movieService.batchImport(movies);
		// sqlRepo.batchInsertMovies(movies);
		// mongoRepo.batchInsertMovies(movies);

		} catch (Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();

		}



	}

}
