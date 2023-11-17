package com.giovaniwahl.dslist.domain.repositories;

import com.giovaniwahl.dslist.domain.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList,Long> {
}
