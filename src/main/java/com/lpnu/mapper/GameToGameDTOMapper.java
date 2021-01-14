package mapper;

import dto.GameDTO;
import entity.Game;
import org.springframework.stereotype.Component;

@Component
public class GameToGameDTOMapper {
    public Game toEntity(final GameDTO gameDTO){
        final Game game = new Game();

        game.setId(gameDTO.getId());
        game.setCompanyName(gameDTO.getCompanyName());
        game.setPrice(gameDTO.getPrice());
        game.setNameGame(gameDTO.getNameGame());

        return game;
    }

    public GameDTO toDTO(final Game game){
        final GameDTO gameDTO = new GameDTO();

        gameDTO.setId(game.getId());
        gameDTO.setCompanyName(game.getCompanyName());
        gameDTO.setPrice(game.getPrice());
        gameDTO.setNameGame(game.getNameGame());

        return gameDTO;
    }
}