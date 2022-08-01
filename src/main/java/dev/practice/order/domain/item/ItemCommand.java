package dev.practice.order.domain.item;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.util.List;

public class ItemCommand {

    //static inner class

    @Getter
    @Builder
    @ToString
    public static class RegisterItemRequest{
        private final String itemName;
        private final Long itemPrice;
        private final List<RegisterItemOptionGroupRequest> itemOptionGroupRequestList; //ex)색상, 사이즈

        public Item toEntity(Long partnerId) {
            return Item.builder()
                    .partnerId(partnerId)
                    .itemName(itemName)
                    .itemPrice(itemPrice)
                    .build();
        }
    }

    public static class RegisterItemOptionGroupRequest{

    }

    public static class RegisterItemOptionRequest{

    }
}
