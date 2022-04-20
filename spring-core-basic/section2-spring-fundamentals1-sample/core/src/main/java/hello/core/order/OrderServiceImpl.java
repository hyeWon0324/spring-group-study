package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    //회원을 조회하기 위해
//    private final MemberRepository memberRepository = new MemoryMemberRepository();

    //할인 정책을 가져온다.
    //DIP를 위반
//    private final DiscountPolicy discountPolicy = new FixedDiscountPolicy(); //고정 할인 금액
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); //고정 할인 금액

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy; //인터페이스에만 의존하지만 null pointer Exception

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        //내부적으로 할인 정책이 바뀌어도 여리를 바뀔 필요없음. 역할이 잘 구분됨.

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
