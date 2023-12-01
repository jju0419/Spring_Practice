package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    //수동으로 스프링컨테이너에 빈으로 등록 (사실 @Service, @Repository로 자동등록 가능)
    //대신 다음 번에 Repository를 변경하고싶을때 Config를 통해서 간단히 변경가능
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository()); //이 방식이 아닌 @Autowired로 넣어줄수도 있음
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
