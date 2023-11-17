package com.giovaniwahl.dslist.domain.services.game;

import com.giovaniwahl.dslist.domain.dtos.GameListDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GameListService {
    @Transactional(readOnly = true)
    List<GameListDto> findAll();
}
