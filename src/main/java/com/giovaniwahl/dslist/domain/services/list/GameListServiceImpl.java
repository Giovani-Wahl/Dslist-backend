package com.giovaniwahl.dslist.domain.services.list;

import com.giovaniwahl.dslist.domain.dtos.GameListDto;
import com.giovaniwahl.dslist.domain.entities.GameList;
import com.giovaniwahl.dslist.domain.repositories.GameListRepository;
import com.giovaniwahl.dslist.domain.repositories.GameRepository;
import com.giovaniwahl.dslist.projections.GameMinProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameListServiceImpl implements GameListService {

    private final GameListRepository gameListRepository;
    private final GameRepository gameRepository;
    @Autowired
    public GameListServiceImpl(GameListRepository gameListRepository, GameRepository gameRepository) {
        this.gameListRepository = gameListRepository;
        this.gameRepository = gameRepository;
    }

    @Override
    public List<GameListDto> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDto::new).toList();
    }

    @Override
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> listGames = gameRepository.searchByList(listId);
        GameMinProjection objAltered = listGames.remove(sourceIndex);
        listGames.add(destinationIndex,objAltered);
        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(sourceIndex, destinationIndex);
        for (int i = min; i < max; i++){
            gameListRepository.updateBelongingPosition(listId,listGames.get(i).getId(),i);
        }
    }
}
