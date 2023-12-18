package kodlama.io.rentACar.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateModelRequest {
    @NotNull
    @NotBlank
    @Size(min = 3, max = 20)
    private String name;
    @NotNull
    @NotBlank
    private int brandId;

    public CreateModelRequest(String name, int brandId) {
        this.name = name;
        this.brandId = brandId;
    }

    public CreateModelRequest() {
    }
}
