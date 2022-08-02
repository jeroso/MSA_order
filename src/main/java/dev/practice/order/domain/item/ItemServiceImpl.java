package dev.practice.order.domain.item;

import dev.practice.order.domain.partner.Partner;
import dev.practice.order.domain.partner.PartnerReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemServiceImpl implements ItemService{
    private final PartnerReader partnerReader;  //partner 토큰
    private final ItemStore itemStore; //item 저장
    private final ItemReader itemReader; //  status 변경시 필요
    private final ItemOptionSeriesFactory itemOptionSeriesFactory;  //옵션 저장

    @Override
    @Transactional
    public String registerItem(ItemCommand.RegisterItemRequest command, String partnerToken) {
        Partner partner = partnerReader.getPartner(partnerToken);
        Item initItem = command.toEntity(partner.getId());
        Item item = itemStore.store(initItem);
        itemOptionSeriesFactory.store(command, item);
        return item.getItemToken();
    }

    @Override
    @Transactional
    public void changeOnSale(String itemToken) {
        Item item = itemReader.getItemBy(itemToken);
        item.changeOnSales();
    }

    @Override
    @Transactional
    public void changeEndOfSale(String itemToken) {
        Item item = itemReader.getItemBy(itemToken);
        item.changeEndOfSales();
    }

    @Override
    public ItemInfo.Main retrieveItemInfo(String itemToken) {
        Item item = itemReader.getItemBy(itemToken);
        List<ItemInfo.ItemOptionGroupInfo> itemOptionGroupInfoList = itemReader.getItemOptionSeries(item);
        return new ItemInfo.Main(item, itemOptionGroupInfoList);
    }
}
