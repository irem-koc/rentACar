package kodlama.io.rentACar.dataAccess.abstracts;

import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//hangi nesne için ve primary key alanı ne

public interface BrandRepository extends JpaRepository<Brand, Integer>{

}
