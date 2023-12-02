package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

//통합 테스트 : 컨테이너를 활용해 테스트를 하지만 속도가 느림
@SpringBootTest //스프링 부트 테스트임을 알림
@Transactional //테스트케이스에 붙은 경우! 테스트 한번 할때마다 테스트 끝나면 롤백해줌
class MemberServiceIntegerationTest {

// 원 소스 밑줄로 대체
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;


// 원 소스 메모리가 아닌 디비 테스트임으로 필요없음 (@Transactional으로 자동 초기화)


    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        Long saveId = memberService.join(member);


        //then
        Member findMemer = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMemer.getName());
    }


    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");


        //when
        memberService.join(member1);

        //assertThrows(이 에러가 발생해야함 , 이 람다식을 실행했을때)
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        //then
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

    }
    @Test
    void findMemers() {
    }

    @Test
    void findOne() {
    }
}