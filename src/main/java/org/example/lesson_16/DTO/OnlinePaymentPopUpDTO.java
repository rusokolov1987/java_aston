package org.example.lesson_16.DTO;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OnlinePaymentPopUpDTO {
    private String cardNumber;
    private String validityPeriod;
    private String secretCode;
    private String holderName;
}
