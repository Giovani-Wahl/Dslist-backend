package com.giovaniwahl.dslist.domain.services.game;

import com.giovaniwahl.dslist.domain.dtos.GameShortDto;
import com.giovaniwahl.dslist.domain.entities.Game;
import com.giovaniwahl.dslist.domain.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService{
    private final GameRepository gameRepository;
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public List<GameShortDto> findAll() {
        List<Game> gameList = gameRepository.findAll();
        List<GameShortDto> gameShortDtoList = gameList.stream().map(GameShortDto::new).toList();
        return gameShortDtoList;
    }
}
