package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//컴포넌트 스캔 방식으로 빈에 자동 등록
@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired //스프링 컨테이너에 있는 memberService를 가져와서 넣어줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new") //Url에 직접 입력될 때 Get
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new") //URL은 같더라도 Post방식으로 넘어올경우 실행
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/"; //전 화면으로 넘김

    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members); //Name값으로 다음 뷰에서 해당 자원을 사용할수있도록 해줌
        return "members/memberList";
    }

}
