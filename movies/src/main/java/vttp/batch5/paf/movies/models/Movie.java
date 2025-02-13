package vttp.batch5.paf.movies.models;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

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
    private String genres;
    private int imdbRating;
    private int imdbVotes;

    // @Override
    // public String toString() {
    //     return "Movie [imdbId=" + imdbId + ", voteAverage=" + voteAverage + ", voteCount=" + voteCount
    //             + ", releaseDate=" + releaseDate + ", revenue=" + revenue + ", budget=" + budget + ", runtime="
    //             + runtime + "]";
    // }

    // public Movie(String imdbId, float voteAverage, int voteCount, Date releaseDate, long revenue, long budget,
    //         int runtime) {
    //     this.imdbId = imdbId;
    //     this.voteAverage = voteAverage;
    //     this.voteCount = voteCount;
    //     this.releaseDate = releaseDate;
    //     this.revenue = revenue;
    //     this.budget = budget;
    //     this.runtime = runtime;
    // }
    
    // public String getImdbId() {
    //     return imdbId;
    // }
    // public void setImdbId(String imdbId) {
    //     this.imdbId = imdbId;
    // }
    // public float getVoteAverage() {
    //     return voteAverage;
    // }
    // public void setVoteAverage(float voteAverage) {
    //     this.voteAverage = voteAverage;
    // }
    // public int getVoteCount() {
    //     return voteCount;
    // }
    // public void setVoteCount(int voteCount) {
    //     this.voteCount = voteCount;
    // }
    // public Date getReleaseDate() {
    //     return releaseDate;
    // }
    // public void setReleaseDate(Date releaseDate) {
    //     this.releaseDate = releaseDate;
    // }
    // public long getRevenue() {
    //     return revenue;
    // }
    // public void setRevenue(long revenue) {
    //     this.revenue = revenue;
    // }
    // public long getBudget() {
    //     return budget;
    // }
    // public void setBudget(long budget) {
    //     this.budget = budget;
    // }
    // public int getRuntime() {
    //     return runtime;
    // }
    // public void setRuntime(int runtime) {
    //     this.runtime = runtime;
    // }


    
}
