package dev.practice.order.domain.partner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PartnerServiceImpl implements PartnerService{

    @Override
    public PartnerInfo registerPartner(PartnerCommand command) {
        // 1. command -> initPartner
        var initPartner = command.toEntity();

        // 2. initPartner save to DB

        // 3. Partner -> PartnerInfo And Return
        return null;
    }

    @Override
    public PartnerInfo getPartnerInfo(String partnerToken) {
        return null;
    }

    @Override
    public PartnerInfo enablePartner(String partnerToken) {
        return null;
    }

    @Override
    public PartnerInfo disablePartner(String partnerToken) {
        return null;
    }
}
