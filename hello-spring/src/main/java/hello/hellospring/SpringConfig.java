package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    //일반적인 JDBC방식일떄 사용
    //private DataSource dateSource;
//    @Autowired
//    public SpringConfig(DataSource dateSource) {
//        this.dateSource = dateSource;
//    }

    //JPA일때 사용
//    private EntityManager em;
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }


    //SpringDataJpa일때 사용
    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) { //SpringDataJpaMemberRepositry를 찾아서 알아서 주입
        this.memberRepository = memberRepository;
    }

    //수동으로 스프링컨테이너에 빈으로 등록 (사실 @Service, @Repository로 자동등록 가능)
    //대신 다음 번에 Repository를 변경하고싶을때 Config를 통해서 간단히 변경가능
    @Bean
    public MemberService memberService() {
        //return new MemberService(memberRepository()); //이 방식이 아닌 @Autowired로 넣어줄수도 있음
        return new MemberService(memberRepository); //SpringDataJpa일때
    }

//    @Bean
//    public MemberRepository memberRepository(){
//        //  return new MemoryMemberRepository(); //메모리가 아닌 DB와 연결하기 위해서 주석
//        //  return new JdbcMemberRepository(dateSource);
//        //  return new JdbcTemplateMemberRepository(dateSource);
//        //  return new JpaMemberRepository(em);
//    }



}
