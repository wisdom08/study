package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // 추상화에도 의존, 구체화에도 의존하는 상태
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
