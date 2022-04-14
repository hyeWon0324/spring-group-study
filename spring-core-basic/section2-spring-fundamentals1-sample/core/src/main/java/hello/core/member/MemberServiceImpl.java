package hello.core.member;


//회원 서비스
public class MemberServiceImpl implements MemberService{

    //메모리 회원 저장소 객체
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //이 객체가 없으면 nullPointerException 날 것.
    //여기에서는 분명 MemberRepository 라는 인터페이스에 의존하는 것이지만
    //MemoryMemberRepository 에도 의존하게되어 있는 형태.

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
