package kodlama.io.rentACar.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateModelRequest {
    @NotNull
    @NotBlank
    @Size(min = 3, max = 20)
    private String name;
    @NotNull
    @NotBlank
    private int brandId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public CreateModelRequest(String name, int brandId) {
        this.name = name;
        this.brandId = brandId;
    }

    public CreateModelRequest() {
    }
}
