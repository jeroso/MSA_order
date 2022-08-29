package dev.practice.order.interfaces.partner;

import dev.practice.order.application.partner.PartnerFacade;
import dev.practice.order.common.response.CommonResponse;
import dev.practice.order.domain.partner.Partner;
import dev.practice.order.domain.partner.PartnerCommand;
import dev.practice.order.domain.partner.PartnerInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/partners")
public class PartnerApiController {
    private final PartnerFacade partnerFacade;
    private final PartnerDtoMapper partnerDtoMapper;

    @GetMapping()
    public CommonResponse registerPartner(PartnerDto.RegisterRequest request) {
        // 1. 외부에서 전달된 파라미터 (dto) -> Command, Criteria convert
        // var command = request.toCommand();
        // dto request -> command mapping
        PartnerCommand command = partnerDtoMapper.of(request);

        // 2. facade 호출 .. PartnerInfoㅎ
        PartnerInfo partnerInfo = partnerFacade.registerPartner(command);

        // 3. PartnerInfo -> CommonResponse covert AND return
        var response = new PartnerDto.RegisterResponse(partnerInfo);
        return CommonResponse.success(response);
    }

}
