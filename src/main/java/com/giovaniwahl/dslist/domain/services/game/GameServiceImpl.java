package com.giovaniwahl.dslist.domain.services.game;

import com.giovaniwahl.dslist.domain.dtos.GameDto;
import com.giovaniwahl.dslist.domain.dtos.GameShortDto;
import com.giovaniwahl.dslist.domain.entities.Game;
import com.giovaniwahl.dslist.domain.repositories.GameRepository;
import com.giovaniwahl.dslist.projections.GameMinProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameServiceImpl implements GameService{
    private final GameRepository gameRepository;
    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<GameShortDto> findAll() {
        List<Game> result = gameRepository.findAll();
        List<GameShortDto> gameShortDtoList = result.stream().map(GameShortDto::new).toList();
        return gameShortDtoList;
    }

    @Override
    @Transactional(readOnly = true)
    public GameDto findById(Long id) {
        Game result = gameRepository.findById(id).get();
        GameDto gameDto = new GameDto(result);
        return gameDto;
    }

    @Override
    @Transactional(readOnly = true)
    public List<GameShortDto> findByList(Long ListId) {
        List<GameMinProjection> result = gameRepository.searchByList(ListId);
        return result.stream().map(x -> new GameShortDto(x)).toList();
    }
}
