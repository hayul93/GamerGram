package com.devhayul.gamergram.repository;

import com.devhayul.gamergram.entity.GameFeed;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository//빈으로 관리하라는 어노테이션 사용가능하나 생략 가능,
public interface GameFeedRepository extends JpaRepository<GameFeed, Long> {

}
