package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


//스프링 데이터 JPA를 이용해 가장 효율적으로 운용하는 방식
public interface SpringDataJpaMemberRepositry extends JpaRepository<Member, Long> , MemberRepository {


    //반환 타입 매서드 이름 파라미터를 이용해 SQL을 자동으로 만들어줌
    @Override
    Optional<Member> findByName(String name);//기본적인건 다 제공하지만 통용되지않는 매서드는 만들어야함
}
