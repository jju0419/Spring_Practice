package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//컴포넌트 스캔 방식으로 빈에 자동 등록
@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired //스프링 컨테이너에 있는 memberService를 가져와서 넣어줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
