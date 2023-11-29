package com.devhayul.gamergram.entity;

import com.devhayul.gamergram.dto.GameFeedRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity  // 데이터테이블 DB와 연결하기위해  @Entity 를 사용, 빈관리가 안되는 포조?클래스 => POJO클래스(Plain Old Java Object) 오래된 방식의 Java클래스
@NoArgsConstructor  // 기본생성자 생성
//@Table(name = "GameFeed") // 클래스 이름과 테이블 이름이 다른경우 DB에 연결하기위해 사용한다.
public class GameFeed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //Long는 Wrapper타입 원시타입을 객체처럼 만든 것 // null값이 들어갈수있다. pk

    @Column(name = "nickname", nullable = false) //DB Table의 Column을 연결할때 사용, nullable은 null값 입력가능한지 여부 확인
    private String nickname;

    @Column(name = "title", nullable = false) //DB Table의 Column을 연결할때 사용, nullable은 null값 입력가능한지 여부 확인
    private String title;

    @Column(name = "contents", nullable = false) //DB Table의 Column을 연결할때 사용, nullable은 null값 입력가능한지 여부 확인
    private String contents;

    public GameFeed(GameFeedRequestDto gameFeedRequestDto) {
        this.nickname = getNickname();
        this.title = getTitle();
        this.contents = getContents();
    }

    public void update(GameFeedRequestDto gameFeedRequestDto) {
        this.nickname = gameFeedRequestDto.getNickname();
        this.title = gameFeedRequestDto.getTitle();
        this.contents = gameFeedRequestDto.getContents();
    }

}
