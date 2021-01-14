package repository;

import entity.Game;
import exception.ServiceException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class GameRepository {

    @PostConstruct
    public void init(){
        savedGames = new ArrayList<>();
    }

    private static Long lastId = 1L;
    private List<Game> savedGames;

    public Game getGameById(final Long id){
        return savedGames.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Game with id: " + id + " not found ", null));
    }

    public List<Game> getAllGames(){
        return savedGames;
    }

    public Game createGame(final Game game){
        if(game.getId() != null){
            throw new ServiceException(400, "Game shouldn't have an id ", null);
        }

        ++lastId;
        game.setId(lastId);

        savedGames.add(game);

        return game;
    }

    public Game updateGame(final Game game){
        if(game.getId() == null){
            throw new ServiceException(400, "User shouldn't have an id ", null);
        }

        final Game savedGame = getGameById(game.getId());


        savedGame.setNameGame(game.getNameGame());
        savedGame.setPrice(game.getPrice());
        savedGame.setCompanyName(game.getCompanyName());

        return savedGame;
    }

    public void deleteGameById(final Long id){
        if(id == null){
            throw new ServiceException(400, "Id isn't specified", null);
        }

        savedGames.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Game with id: " + id + " not found ", null));

        savedGames = savedGames.stream()
                .filter(e -> !e.getId().equals(id))
                .collect(Collectors.toList());

    }
}