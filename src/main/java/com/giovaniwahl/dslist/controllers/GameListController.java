package com.giovaniwahl.dslist.controllers;

import com.giovaniwahl.dslist.domain.dtos.GameListDto;
import com.giovaniwahl.dslist.domain.dtos.GameShortDto;
import com.giovaniwahl.dslist.domain.dtos.ReplacementDto;
import com.giovaniwahl.dslist.domain.services.game.GameService;
import com.giovaniwahl.dslist.domain.services.list.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Page<GameListDto>> findAll(@PageableDefault(page = 0, size = 5, sort = "id",
            direction = Sort.Direction.ASC)Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(gameListService.findAll(pageable));
    }
    @GetMapping("/{ListId}/games")
    public List<GameShortDto> findByList(@PathVariable Long ListId){
        return gameService.findByList(ListId);
    }
    @PostMapping("/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDto body){
        gameListService.move(listId,body.getSourceIndex(),body.getDestinationIndex());
    }
}
