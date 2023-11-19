package com.giovaniwahl.dslist.projections;

public interface GameMinProjection {
    Long getId();
    String getTitle();
    String getGameYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();
}
