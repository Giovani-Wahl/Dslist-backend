package com.giovaniwahl.dslist.domain.services.game;

import com.giovaniwahl.dslist.domain.dtos.GameDto;
import com.giovaniwahl.dslist.domain.dtos.GameShortDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GameService {
    @Transactional(readOnly = true)
    List<GameShortDto> findAll();
    @Transactional(readOnly = true)
    GameDto findById(Long id);
}
