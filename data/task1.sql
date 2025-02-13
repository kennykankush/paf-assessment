CREATE DATABASE IF NOT EXISTS movies;

USE movies;

CREATE TABLE IF NOT EXISTS imdb(
    imdb_id VARCHAR(16),
    vote_average FLOAT DEFAULT 0,
    vote_count INT DEFAULT 0,
    release_date DATE,
    revenue DECIMAL(15,2) DEFAULT 1000000,
    budget DECIMAL(15,2) DEFAULT 1000000,
    runtime INT DEFAULT 90
)

