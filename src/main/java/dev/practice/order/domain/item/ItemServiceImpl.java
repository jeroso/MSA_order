package dev.practice.order.domain.item;

import dev.practice.order.domain.partner.PartnerReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemServiceImpl {
    private final PartnerReader partnerReader;  //partner 토큰
    private final ItemStore itemStore; //item 저장
    private final ItemReader itemReader; //  status 변경시 필요
    private final ItemOptionSeriesFactory; //itemOption 저장
}
