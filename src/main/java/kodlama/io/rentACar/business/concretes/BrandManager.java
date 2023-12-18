package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdResponse;
import kodlama.io.rentACar.business.rules.BrandBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service // bu sınıf bir business nesnesidir
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    public BrandManager(BrandRepository brandRepository, ModelMapperService modelMapperService, BrandBusinessRules brandBusinessRules) {
        this.brandRepository = brandRepository;
        this.modelMapperService = modelMapperService;
        this.brandBusinessRules = brandBusinessRules;
    }

    //controllers isteğin yapıldığı yer
    @Override
    public List<GetAllBrandsResponse> getAll() {

        List<Brand> brands = brandRepository.findAll();
        /*List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();
        for (Brand brand: brands){
            GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
            responseItem.setId(brand.getId());
            responseItem.setName(brand.getName());
            brandsResponse.add(responseItem);
        }*/


        List<GetAllBrandsResponse> brandsResponse = brands.stream()
                .map(brand -> this.modelMapperService.forResponse()
                        .map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
        //iş kuralları koşulları
        return brandsResponse;
    }

    @Override
    public GetByIdResponse getById(int id) {
        return null;
    }

    public GetByIdResponse getByIdResponse(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();

        GetByIdResponse response = this.modelMapperService.forResponse().map(brand, GetByIdResponse.class);

        return response;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
        /*Brand brand = new Brand();
        brand.setName(createBrandRequest.getName());*/
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand); // id de olduğu için update işlemi gerçekleştirir buradaki save
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}
