package com.lpnu.impl;


import com.lpnu.dto.GameDTO;
import com.lpnu.exception.ServiceException;
import com.lpnu.mapper.GameToGameDTOMapper;
import com.lpnu.repository.GameRepository;
import com.lpnu.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GameToGameDTOMapper gameToGameDTOMapper;

    @Override
    public GameDTO getGameById(final Long id) {

        return gameToGameDTOMapper.toDTO(gameRepository.getGameById(id));
    }

    @Override
    public List<GameDTO> getAllGames() {
        return gameRepository.getAllGames().stream()
                .map(e -> gameToGameDTOMapper.toDTO(e))
                .collect(Collectors.toList());
    }

    @Override
    public GameDTO createGame(final GameDTO gameDTO) {
        if(gameDTO.getId() != null){
            throw new ServiceException(400, "Game shouldn't have an id ", null);
        }

        return gameToGameDTOMapper.toDTO(gameRepository.createGame(gameToGameDTOMapper.toEntity(gameDTO)));
    }

    @Override
    public GameDTO updateGame(final GameDTO gameDTO) {
        if(gameDTO.getId() == null){
            throw new ServiceException(400, "Game have an id ", null);
        }

        return gameToGameDTOMapper.toDTO(gameRepository.updateGame(gameToGameDTOMapper.toEntity(gameDTO)));
    }

    @Override
    public void deleteGameById(final Long id) {
        gameRepository.deleteGameById(id);
    }
}