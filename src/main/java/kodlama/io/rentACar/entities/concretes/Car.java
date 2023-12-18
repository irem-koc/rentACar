package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.*;

@Table(name = "cars")
@Entity
public class Car {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "plate", unique = true)
    private String plate;
    @Column(name = "dailyPrice")
    private double dailyPrice;
    @Column(name = "modelYear")
    private int modelYear;
    @Column(name = "state")
    private int state; //1 available 2 rented 3 maintenance
    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Car() {
    }

    public Car(int id, String plate, double dailyPrice, int modelYear, int state, Model model) {
        this.id = id;
        this.plate = plate;
        this.dailyPrice = dailyPrice;
        this.modelYear = modelYear;
        this.state = state;
        this.model = model;
    }
}
