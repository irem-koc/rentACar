package kodlama.io.rentACar.business.requests;

public class UpdateBrandRequest {
    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UpdateBrandRequest(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public UpdateBrandRequest() {
    }
}
