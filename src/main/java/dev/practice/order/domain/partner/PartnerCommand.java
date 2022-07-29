package dev.practice.order.domain.partner;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class PartnerCommand {
    private final String partnerName;
    private final String businessNo;
    private final String email;
}
