package com.giovaniwahl.dslist.domain.services.game;

import com.giovaniwahl.dslist.domain.dtos.GameDto;
import com.giovaniwahl.dslist.domain.dtos.GameShortDto;
import com.giovaniwahl.dslist.domain.entities.Game;
import com.giovaniwahl.dslist.domain.repositories.GameRepository;
import com.giovaniwahl.dslist.projections.GameMinProjection;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return result.stream().map(GameShortDto::new).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<GameDto> findById(Long id) {
        Optional<Game> gameOptional = gameRepository.findById(id);
        return gameOptional.map(GameDto::new);
    }

    @Override
    @Transactional(readOnly = true)
    public List<GameShortDto> findByList(Long ListId) {
        List<GameMinProjection> result = gameRepository.searchByList(ListId);
        return result.stream().map(GameShortDto::new).toList();
    }
}
