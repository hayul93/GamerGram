package com.devhayul.gamergram.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameFeedRequestDto { //요청받은 값들이다.
    private String nickname;
    private String title;
    private String contents;
}
