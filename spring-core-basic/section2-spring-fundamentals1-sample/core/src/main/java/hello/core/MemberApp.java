package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {

        //순수한 자바 코드
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP); //ctrl+alt+v
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new memeber = " + member.getName());
        System.out.println("find memeber = " + findMember.getName());

        //출력
//        new member = memberA
//        find Member = memberA

    }
}