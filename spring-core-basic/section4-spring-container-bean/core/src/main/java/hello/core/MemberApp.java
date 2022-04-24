package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService(); //appConfig 에서 결정하도록 한다
        //순수한 자바 코드
//        MemberService memberService = new MemberServiceImpl();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP); //ctrl+alt+v
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new memeber = " + member.getName());
        System.out.println("find memeber = " + findMember.getName());
        //출력
//        new member = memberA
//        find Member = memberA

        Order order = orderService.createOrder(memberId, "itemA", 20000);
        System.out.println("order = " + order);


    }
}