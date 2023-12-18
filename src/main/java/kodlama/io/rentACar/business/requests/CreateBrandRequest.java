package kodlama.io.rentACar.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBrandRequest {
    @NotNull
    @NotBlank
    @Size(min = 3, max = 20)
    private String name;
}
