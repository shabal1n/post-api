package kz.dar.academy.postcoreapi.model;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParcelModel {
    private String parcelId;
    private String senderFullName;
    @NotNull(message = "Receiver name can not be empty")
    @Size(min = 6, max = 35, message = "Receiver full name should be 6 to 35 letters")
    private String receiverFullName;
    private String senderAddress;
    @NotNull(message = "Receiver address can not be empty")
    @Size(min = 8, max = 50, message = "Receiver address should be 8 to 50 letters")
    private String receiverAddress;
    @NotNull(message = "Parcel weight can not be empty")
    private double parcelWeight;
    @NotNull(message = "Status can not be empty")
    private String status;
}
