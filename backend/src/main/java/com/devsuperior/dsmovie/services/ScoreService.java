package com.devsuperior.dsmovie.services;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.entities.Score;
import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.exceptions.MovieNotFoundException;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import com.devsuperior.dsmovie.repositories.ScoreRepository;
import com.devsuperior.dsmovie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class ScoreService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScore(ScoreDTO scoreDTO) {
        Long movieId = scoreDTO.getMovieId();
        String email = scoreDTO.getEmail();
        Double value = scoreDTO.getScore();

        User user = getUser(email);

        Movie movie = getMovie(movieId);

        scoreRepository.saveAndFlush(new Score(movie, user, value));

        Set<Score> movieScores = movie.getScores();

        movie.setScore(getMovieScoreAverage(movieScores));
        movie.setCount(movieScores.size());

        return new MovieDTO(movieRepository.save(movie));
    }

    private User getUser(String email) {
        return userRepository.findByEmail(email)
                             .orElseGet(() -> createAndSaveUser(email));
    }

    private Movie getMovie(Long movieId) {
        return movieRepository.findById(movieId)
                              .orElseThrow(() -> new MovieNotFoundException(
                                      String.format("Movie of id %d not found",
                                                    movieId)));
    }

    private double getMovieScoreAverage(Set<Score> movieScores) {
        return movieScores.stream()
                          .mapToDouble(Score::getValue)
                          .average()
                          .orElse(0.0);
    }

    private User createAndSaveUser(String email) {
        User newUser = new User();
        newUser.setEmail(email);
        return userRepository.saveAndFlush(newUser);
    }
}
