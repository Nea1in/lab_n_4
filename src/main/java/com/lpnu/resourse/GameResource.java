package resourse;

import dto.GameDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.GameService;

import java.util.List;

@RestController
public class GameResource {
    /*
    @Autowired
    private GameService gameService;

    @GetMapping("/games/{id}")
    public GameDTO getGameById(final @PathVariable Long id){
        return gameService.getGameById(id);
    }

    @GetMapping("/games")
    public List<GameDTO> getAllGames(){
        return gameService.getAllGames();
    }

    @PostMapping("/games")
    public GameDTO createGame(final @RequestBody GameDTO gameDTO){
        return gameService.createGame(gameDTO);
    }

    @PutMapping("/games")
    public GameDTO updateGame(final @RequestBody GameDTO gameDTO){
        return gameService.updateGame(gameDTO);
    }

    @DeleteMapping("/games/{id}")
    public void deleteGameById(final @PathVariable Long id){
        gameService.deleteGameById(id);
    }

     */
}
