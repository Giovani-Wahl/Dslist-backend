package com.giovaniwahl.dslist.domain.services.game;

import com.giovaniwahl.dslist.domain.dtos.GameDto;
import com.giovaniwahl.dslist.domain.dtos.GameShortDto;
import com.giovaniwahl.dslist.domain.entities.Game;
import com.giovaniwahl.dslist.domain.repositories.GameRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService{
    private final GameRepository gameRepository;
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public List<GameShortDto> findAll() {
        List<Game> result = gameRepository.findAll();
        List<GameShortDto> gameShortDtoList = result.stream().map(GameShortDto::new).toList();
        return gameShortDtoList;
    }

    @Override
    public GameDto findById(Long id) {
        Game result = gameRepository.findById(id).get();
        GameDto gameDto = new GameDto(result);
        return gameDto;
    }
}
