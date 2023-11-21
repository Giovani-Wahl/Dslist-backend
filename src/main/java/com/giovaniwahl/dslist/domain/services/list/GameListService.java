package com.giovaniwahl.dslist.domain.services.list;

import com.giovaniwahl.dslist.domain.dtos.GameListDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GameListService {
    @Transactional(readOnly = true)
    Page<GameListDto> findAll(Pageable pageable);
    @Transactional
    void move(Long listId, int sourceIndex, int destinationIndex);
}
