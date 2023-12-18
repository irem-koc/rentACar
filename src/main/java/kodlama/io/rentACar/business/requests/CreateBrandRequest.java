package kodlama.io.rentACar.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
public class CreateBrandRequest {
    @NotNull //bunlar devreye girmedi başta @Valid
    @NotBlank
    @Size(min = 3, max = 20)
    private String name;

    public CreateBrandRequest() {
    }

    public CreateBrandRequest(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
