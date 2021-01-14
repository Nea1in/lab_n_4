package com.lpnu.service;



import com.lpnu.dto.GameDTO;

import java.util.List;

public interface GameService {
    GameDTO getGameById(Long id);
    List<GameDTO> getAllGames();
    GameDTO createGame(GameDTO gameDTO);
    GameDTO updateGame(GameDTO gameDTO);
    void deleteGameById(Long id);
}
