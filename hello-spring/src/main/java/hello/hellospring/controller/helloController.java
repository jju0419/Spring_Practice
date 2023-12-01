package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {

    //정적 컨탠츠
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello");
        return "hello";
    }

    //MVC,템플릿 엔진 방식 : view단과의 상호 작용해서 변화된 html전달
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }


    //API통신 방법 : 직접 적인 데이터(객체)를 반환
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name;
    }

    //API통신 방법2 : json방식으로 데이터 던짐
    @GetMapping("hello-api")
    @ResponseBody//객체룰 넘겨야 할 경우 JSON으로 변환한다 (JSONConverter)
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;//json객체 반환 -> 이름 : name / value : 파라미터 값
    }

    static class Hello{
        private String name;
        //Alt+Insert generator 단축키 (getter setter 등)
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
