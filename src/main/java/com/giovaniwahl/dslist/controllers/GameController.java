package com.giovaniwahl.dslist.controllers;

import com.giovaniwahl.dslist.domain.dtos.GameShortDto;
import com.giovaniwahl.dslist.domain.services.game.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    private final GameService gameService;
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<GameShortDto> findAll(){
        List<GameShortDto> gameList = gameService.findAll();
        return gameList;
    }
}
