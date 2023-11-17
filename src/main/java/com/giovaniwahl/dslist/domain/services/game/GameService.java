package com.giovaniwahl.dslist.domain.services.game;

import com.giovaniwahl.dslist.domain.dtos.GameDto;
import com.giovaniwahl.dslist.domain.dtos.GameShortDto;

import java.util.List;

public interface GameService {
    List<GameShortDto> findAll();
    GameDto findById(Long id);
    List<GameShortDto> findByList(Long ListId);
}
