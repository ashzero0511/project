package org.example.project.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor //기본생성자 자동 추가
@Entity //테이블과 링크될 클래스임을 나타냄
public class Posts extends BaseTimeEntity{
    @Id //해당 테이블의 pk 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk의 생성규칙 정의 auto_increment 옵션부여
    private Long id;

    @Column(length = 500, nullable = false) //테이블의 칼럼정의, 사이즈를 늘리거나 타입변경할때 옵션부여
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //해당 클래스의 빌더 패턴 클래스를 생성
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
