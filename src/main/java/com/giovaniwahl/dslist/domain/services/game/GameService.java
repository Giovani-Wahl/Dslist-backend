package com.giovaniwahl.dslist.domain.services.game;

import com.giovaniwahl.dslist.domain.dtos.GameDto;
import com.giovaniwahl.dslist.domain.dtos.GameShortDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface GameService {
    Page<GameShortDto> findAll(Pageable pageable);
    Optional<GameDto> findById(Long id);
    List<GameShortDto> findByList(Long ListId);
}
