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
        /* Gera a lista ordenada*/
        List<GameMinProjection> listGames = gameRepository.searchByList(listId);
        /* Remove o item desejado da lista*/
        GameMinProjection objAltered = listGames.remove(sourceIndex);
        /*Inclui o item desejado novamente na lista na posição desejada*/
        listGames.add(destinationIndex,objAltered);
        /*Encontrar o minimo e o maximo entre o item alterado e sua nova posição*/
        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex :sourceIndex;
        /* atualizar as posições na lista conforme min e max encontrados */
        for (int i = min; i < max; i++){
            gameListRepository.updateBelongingPosition(listId,listGames.get(i).getId(),i);
        }
    }
}
