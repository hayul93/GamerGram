package com.devhayul.gamergram.dto;

import com.devhayul.gamergram.entity.GameFeed;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GameFeedResponseDto {// Json 데이터로 담아서 준다. //직렬화 , JACKSON 라이브러리를 통해 변한다.
    private Long id;
    private String nickname;
    private String title;
    private String contents;

    public GameFeedResponseDto(GameFeed gameFeed) {//요청받은 값을 반환하기위해 순수한 클래스로 생성자를 만들어 응답값을 반환한다.
        this.id = gameFeed.getId(); //엔티티클래스에 있는 ID 필드를 가져와 현재 리스폰스DTO 필드값에 넣어준다.
        this.nickname = gameFeed.getNickname();
        this.title = gameFeed.getTitle();
        this.contents = gameFeed.getContents();
    }

//    public GameFeedResponse(Long id, String nickname, String title, String contents) {//요청받은 값을 반환하기위해 순수한 클래스로 생성자를 만들어 응답값을 반환한다.
//        this.id = id; //엔티티클래스에 있는 ID 필드를 가져와 현재 리스폰스DTO 필드값에 넣어준다.
//        this.nickname = nickname;
//        this.title = title;
//        this.contents = contents;
//    }
}