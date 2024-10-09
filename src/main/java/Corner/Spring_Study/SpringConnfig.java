package Corner.Spring_Study;

import Corner.Spring_Study.repository.MemberRepository;
import Corner.Spring_Study.repository.MemoryMemberRepository;
import Corner.Spring_Study.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConnfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
