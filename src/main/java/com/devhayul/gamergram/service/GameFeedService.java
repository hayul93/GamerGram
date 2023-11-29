package com.devhayul.gamergram.service;

import com.devhayul.gamergram.dto.GameFeedRequestDto;
import com.devhayul.gamergram.dto.GameFeedResponseDto;
import com.devhayul.gamergram.entity.GameFeed;
import com.devhayul.gamergram.repository.GameFeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//서비스 클래스는 비지니스 로직을 작성하는 클래스이다.
@Service//빈으로 관리하라는 어노테이션 , 오토와이얼드를 할수있다. 단 서로간의 상태는 빈으로 관리할 수 있어야 한다.// 싱글 톤이란 패턴으로 만들어야한다 데이터가 변경되면안된다.
@RequiredArgsConstructor// final 이 달려있는 필드를 찾아서 생성자를 자동으로 만들어준다.
public class GameFeedService {

    //@Autowired // 자동주입  ioc container에서 GameFeedRepository객체를 넣어준다
    private final GameFeedRepository gameFeedRepository;


    //게시글 생성 저장 역할
    public GameFeedResponseDto createGameFeeds(GameFeedRequestDto gameFeedRequestDto) {
        //JPA에서 테이블이랑 연결해 저장하기 위해선 @Entity 어노테이션이 달린 클래스가 필요하다.
        GameFeed gameFeed = new GameFeed(gameFeedRequestDto); //Entity 객체 1개는 테이블에서 1row이다. 1줄
        // 이렇게 되면 레포지토리에 저장이 된다.
        gameFeedRepository.save(gameFeed); //테이블에 1row 저장

        // 반환 되는 데이터 응답값
        return new GameFeedResponseDto(gameFeed);
    }


    //게시글 조회
    public List<GameFeedResponseDto> getGameFeeds() {
        //List<GameFeedResponseDto 로 반환 타입을 받는 이유는 여러 객체가 생성되어 1개아 아닌 다수의 row값이 있을수있기 때문

        //gameFeedRepository에 있는 모든 테이블 row값 조회
        //.findAll은 리스트타입으로 반환한다. List<GameFeed> 이다. 엔티티를 반환타입으로 한다.
        List<GameFeed> gameFeedList = gameFeedRepository.findAll();
        // 여기에 담겨있는 값을 List<GameFeedResponseDto>로 바꿔줘야하기때문에 하나씩 옮겨서 넣어줘보자.
        //새로운 리스트 객체를 만든다.
        List<GameFeedResponseDto> gameFeedResponseList = new ArrayList<>();

        //그리고 for 문을 이용해 하나씩 옮길 수 있다.
        for (GameFeed gameFeed : gameFeedList) {
            GameFeedResponseDto response = new GameFeedResponseDto(gameFeed);
            gameFeedResponseList.add(response);
        }
        return gameFeedResponseList;
    }

    public void updateGameFeed(Long id, GameFeedRequestDto gameFeedRequestDto) {
         GameFeed updateGameFeed = gameFeedRepository.findById(id).orElseThrow(NullPointerException :: new);// 찾고자 하는 데이터가 없을때
        updateGameFeed.update(gameFeedRequestDto);
        gameFeedRepository.save(updateGameFeed);
    }


}
