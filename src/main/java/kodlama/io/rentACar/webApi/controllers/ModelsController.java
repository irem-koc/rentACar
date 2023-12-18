package kodlama.io.rentACar.webApi.controllers;

import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
    private ModelService modelService;



    @GetMapping()// "/api/models/getAll" diyince sen çalış "/getAll" vardı
    public List<GetAllModelsResponse> getAll() {

        return modelService.getAll();
    }
    @PostMapping() ///add vardı
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(@RequestBody @Valid() CreateModelRequest createModelRequest) {

        this.modelService.add(createModelRequest);
        System.out.println("Added " + createModelRequest.getName());
    }

}
