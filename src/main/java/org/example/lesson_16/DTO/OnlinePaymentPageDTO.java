package org.example.lesson_16.DTO;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OnlinePaymentPageDTO {
    private String paymentType;
    private String specialField;
    private String phone;
    private String total;
    private String email;
}
