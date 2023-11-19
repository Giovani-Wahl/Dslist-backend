package com.giovaniwahl.dslist.domain.dtos;

import com.giovaniwahl.dslist.domain.entities.Game;
import com.giovaniwahl.dslist.projections.GameMinProjection;

public class GameShortDto {
    private Long id;
    private String title;
    private String year;
    private String imgUrl;
    private String shortDescription;

    public GameShortDto(){}
    public GameShortDto(Game entity) {
        id = entity.getId();
        title = entity.getTitle();
        year = entity.getYear();
        imgUrl = entity.getImgUrl();
        shortDescription = entity.getShortDescription();
    }
    public GameShortDto(GameMinProjection projection) {
        id = projection.getId();
        title = projection.getTitle();
        year = projection.getGameYear();
        imgUrl = projection.getImgUrl();
        shortDescription = projection.getShortDescription();
    }

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getYear() {
        return year;
    }
    public String getImgUrl() {
        return imgUrl;
    }
    public String getShortDescription() {
        return shortDescription;
    }
}
