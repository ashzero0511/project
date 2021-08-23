package org.example.project;

import org.example.project.config.auth.SecurityConfig;
import org.example.project.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) //스프링부트 테스트와 JUnit 사이에 연결자 역활
@WebMvcTest(controllers = HelloController.class,
        excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
        }
    ) //@Controller, @ControllerAdvice 사용가능
public class HelloControllerTest {
    @Autowired //스프링이 관리하는 bean을 주입받음
    private MockMvc mvc; //웹 API 테스트에 사용, 테스트의 시작점

    @WithMockUser(roles="USER")
    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")) //hello라는 주소로 get요청을 보냄
                .andExpect(status().isOk()) //접속상태가 정상적인지 확인
                .andExpect(content().string(hello)); //응답 본문의 내용을 검증, "hello"를 반환하는지 확인
    }

    @WithMockUser(roles="USER")
    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name="hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name) //요청 파라미터 설정, String값만 허용
                        .param("amount", String.valueOf(amount))
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) //JSON 응답값을 필드별로 검증
                .andExpect(jsonPath("$.amount",is(amount)));

    }
}
