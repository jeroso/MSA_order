package dev.practice.order.domain.partner;

import dev.practice.order.domain.partner.Partner.Status;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Builder
public class PartnerInfo {
    private Long id;
    private String partnerToken;
    private String partnerName;
    private String businessNo;
    private String email;
    @Enumerated(EnumType.STRING)
    private Status status;
}
