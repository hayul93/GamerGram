package com.devhayul.gamergram.controller;

import com.devhayul.gamergram.dto.GameFeedRequestDto;
import com.devhayul.gamergram.dto.GameFeedResponseDto;
import com.devhayul.gamergram.service.GameFeedService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//controller의 역할은 클라이언트와 상호 작용하는역할만 한다. 요청 받고 응답 보내주는 역할
@RequestMapping("/api/game-feeds")  //- 꼬치 형태 케밥 케이스
@RestController //@Controller에 @ReponseBody를 추가한 것. Json형태로 객체 데이터를 반환할 때 사용
@RequiredArgsConstructor //@RequiredArgsConstructor는 초기화 되지않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성
public class GameController {



    private final GameFeedService gameFeedService; //GameFeedService 를 주입받아와서 객체에 메서드를 호줄해서 전달함
    @PostMapping
    //ResponseEntity<> 로 반환 타입을 받는 이유가 status 값을 반환하기 위해서인지? 범용성이 좋아서 사용 여러가지 기능이있다.
    public ResponseEntity<GameFeedResponseDto>  createGameFeeds(@RequestBody GameFeedRequestDto gameFeedRequestDto) {
        GameFeedResponseDto gameFeedResponseDto = gameFeedService.createGameFeeds(gameFeedRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(gameFeedResponseDto);
    }

    @GetMapping
    //반환타입을 List<GameFeedResponseDto 로 반환 받는 이유는 피드들이 여러 객체로 만들어져 그 객체들을 리스트 형식으로 받아서 응답 값으로 반환 해줘야 하기 때문이다.
    public ResponseEntity<?> getGameFeeds() {
        List<GameFeedResponseDto> gameFeedResponseList = gameFeedService.getGameFeeds();

        return ResponseEntity.ok(gameFeedResponseList);
    }

    //{id} 동적 할당
    //@PathVariable 중괄호 데이터 주입
    //@PathVariable(name = "id") Long gameFeedId 로도 사용할 수 있다.
    @PutMapping("/{id}")
    public void UpdateGameFeed (@PathVariable Long id, @RequestBody GameFeedRequestDto gameFeedRequestDto){
        gameFeedService.updateGameFeed(id, gameFeedRequestDto);

    }
}
