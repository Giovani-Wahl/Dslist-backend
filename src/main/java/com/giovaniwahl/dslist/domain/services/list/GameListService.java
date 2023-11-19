package com.giovaniwahl.dslist.domain.services.list;

import com.giovaniwahl.dslist.domain.dtos.GameListDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GameListService {
    @Transactional(readOnly = true)
    List<GameListDto> findAll();
    @Transactional
    void move(Long listId, int sourceIndex, int destinationIndex);
}
