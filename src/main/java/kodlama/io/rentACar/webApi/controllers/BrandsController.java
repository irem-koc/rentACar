package kodlama.io.rentACar.webApi.controllers;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdResponse;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController //annotation bilgilendirme
@RequestMapping("/api/brands") //adresleme
@AllArgsConstructor
public class BrandsController {
    private BrandService brandService;

    @GetMapping()// "/api/brands/getAll" diyince sen çalış "/getAll" vardı
    public List<GetAllBrandsResponse> getAll() {
        return brandService.getAll();
    }

    @PostMapping() ///add vardı
    @ResponseStatus(code=HttpStatus.CREATED)
    public void add(@RequestBody CreateBrandRequest createBrandRequest) {
        this.brandService.add(createBrandRequest);
    }
    @GetMapping("/{id}")// "/api/brands/getAll" diyince sen çalış "/getAll" vardı
    public GetByIdResponse getById(@PathVariable int id) {
        return brandService.getById(id);
    }

    @PutMapping()
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);
    }
}
