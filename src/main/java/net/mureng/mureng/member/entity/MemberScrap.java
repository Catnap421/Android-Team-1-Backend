package net.mureng.mureng.member.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.mureng.mureng.todayexpression.entity.TodayExpression;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "MEMBER_SCRAP")
public class MemberScrap {
    @EmbeddedId
    private MemberScrapPK id;

    @MapsId("memberId")
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @MapsId("expId")
    @ManyToOne
    @JoinColumn(name = "exp_id")
    private TodayExpression todayExpression;

    @Column(name = "reg_date", nullable = false)
    private LocalDate regDate = LocalDate.now();

    @Builder
    public MemberScrap(MemberScrapPK id, LocalDate regDate) {
        this.id = id;
        this.regDate = regDate;
    }
}
