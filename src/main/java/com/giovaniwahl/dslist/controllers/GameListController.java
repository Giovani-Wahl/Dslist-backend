package com.giovaniwahl.dslist.controllers;

import com.giovaniwahl.dslist.domain.dtos.GameListDto;
import com.giovaniwahl.dslist.domain.dtos.GameShortDto;
import com.giovaniwahl.dslist.domain.services.game.GameService;
import com.giovaniwahl.dslist.domain.services.list.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {
    private final GameListService gameListService;
    private final GameService gameService;
    @Autowired
    public GameListController(GameListService gameListService, GameService gameService) {
        this.gameListService = gameListService;
        this.gameService = gameService;
    }

    @GetMapping
    public List<GameListDto> findAll(){
        List<GameListDto> result = gameListService.findAll();
        return result;
    }
    @GetMapping("/{ListId}/games")
    public List<GameShortDto> findByList(@PathVariable Long ListId){
        List<GameShortDto> result = gameService.findByList(ListId);
        return result;
    }
}
