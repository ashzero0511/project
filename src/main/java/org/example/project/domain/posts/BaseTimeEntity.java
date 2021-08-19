package org.example.project.domain.posts;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //상속할 경우 필드들도 칼럼으로 인식
@EntityListeners(AuditingEntityListener.class) //클래스에 Auditing 기능을 포함
public abstract class BaseTimeEntity {

    @CreatedDate //엔티티 생성되어 저장될때의 시간 저장장
   private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
