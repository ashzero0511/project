package org.example.project.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트(){
        String name = "test";
        int amount = 1000;

        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //assertThat : 검증하고 싶은 대상을 메소드 인자로 받음
        //isEqualTo : 두 값이 같은지 비교하는 메소드
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
