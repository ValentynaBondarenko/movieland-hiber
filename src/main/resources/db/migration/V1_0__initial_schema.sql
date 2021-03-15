CREATE TABLE movies (
    id SERIAL PRIMARY KEY,
    name_native VARCHAR(200) NOT NULL,
    name_russian VARCHAR(200) NOT NULL,
    year BIGINT NOT NULL,
    description TEXT,
    rating DOUBLE PRECISION,
    price DOUBLE PRECISION  NOT NULL,
    poster_img VARCHAR
);

CREATE TABLE genres (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
    );

CREATE TABLE movie_to_genre (
    column_id SERIAL PRIMARY KEY,
    movie_id INTEGER NOT NULL,
    genre_id INTEGER NOT NULL,
    CONSTRAINT FK_movie_id FOREIGN KEY (movie_id) REFERENCES movies(id),
    CONSTRAINT FK_genre_id FOREIGN KEY (genre_id) REFERENCES genres(id)
);



