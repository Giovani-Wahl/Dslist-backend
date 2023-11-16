package com.giovaniwahl.dslist.domain.services.game;

import com.giovaniwahl.dslist.domain.dtos.GameShortDto;
import com.giovaniwahl.dslist.domain.entities.Game;

import java.util.List;

public interface GameService {
    List<GameShortDto> findAll();
}
