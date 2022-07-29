package dev.practice.order.domain.partner;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PartnerServiceImpl implements PartnerService{
    private final PartnerStore partnerStore;
    private final PartnerReader partnerReader;

    @Override
    public PartnerInfo registerPartner(PartnerCommand command) {
        // 1. command -> initPartner
        var initPartners = command.toEntity();
        // 2. initPartner save to DB
        Partner partner = partnerStore.store(initPartners);
        // 3. Partner -> PartnerInfo And Return
        return new PartnerInfo(partner);
    }

    @Override
    public PartnerInfo getPartnerInfo(String partnerToken) {
        // 1. partnerToken -> Partner
        Partner partner = partnerReader.getPartner(partnerToken);
        // 2. Partner -> PartnerInfo return
        return new PartnerInfo(partner);
    }

    @Override
    public PartnerInfo enablePartner(String partnerToken) {
        // 1. partnerToken -> Partner
        Partner partner = partnerReader.getPartner(partnerToken);
        // 2. Partner.enable()
        partner.enable();
        return new PartnerInfo(partner);
    }

    @Override
    public PartnerInfo disablePartner(String partnerToken) {
        // 1. partnerToken -> Partner
        Partner partner = partnerReader.getPartner(partnerToken);
        // 2. Partner.disable()
        partner.disable();
        return new PartnerInfo(partner);
    }
}
