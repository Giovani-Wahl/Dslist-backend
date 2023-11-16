package com.giovaniwahl.dslist.domain.repositories;

import com.giovaniwahl.dslist.domain.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game,Long> {
}
