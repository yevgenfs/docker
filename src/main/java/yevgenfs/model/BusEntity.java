package yevgenfs.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "bus", schema = "mydb", catalog = "")
@IdClass(BusEntityPK.class)
public class BusEntity {

    private Integer idBus;
    private String busNumber;
    private Integer freeSeats;
    private String typeOfBus;
    private String departueDate;
    private String returnTime;
    private Integer age;
    private String manafacturer;
    private PriceMultiplierEntity priceMultiplierByTypeOfBus;
    private DriversEntity driversByBusNumber;
    private Collection<TiketEntity> tikets;



    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_bus")
    public Integer getIdBus() {
        return idBus;
    }

    public void setIdBus(Integer idBus) {
        this.idBus = idBus;
    }

    @Basic
    @Column(name = "bus_number")
    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    @Basic
    @Column(name = "free_seats")
    public Integer getFreeSeats() {
        return freeSeats;
    }

    public void setFreeSeats(Integer freeSeats) {
        this.freeSeats = freeSeats;
    }

    @Id
    @Column(name = "type_of_bus")
    public String getTypeOfBus() {
        return typeOfBus;
    }

    public void setTypeOfBus(String typeOfBus) {
        this.typeOfBus = typeOfBus;
    }

    @Basic
    @Column(name = "departue_date")
    public String getDepartueDate() {
        return departueDate;
    }

    public void setDepartueDate(String departueDate) {
        this.departueDate = departueDate;
    }

    @Basic
    @Column(name = "return_time")
    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "manafacturer")
    public String getManafacturer() {
        return manafacturer;
    }

    public void setManafacturer(String manafacturer) {
        this.manafacturer = manafacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusEntity busEntity = (BusEntity) o;
        return Objects.equals(idBus, busEntity.idBus) &&
                Objects.equals(busNumber, busEntity.busNumber) &&
                Objects.equals(freeSeats, busEntity.freeSeats) &&
                Objects.equals(typeOfBus, busEntity.typeOfBus) &&
                Objects.equals(departueDate, busEntity.departueDate) &&
                Objects.equals(returnTime, busEntity.returnTime) &&
                Objects.equals(age, busEntity.age) &&
                Objects.equals(manafacturer, busEntity.manafacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBus, busNumber, freeSeats, typeOfBus, departueDate, returnTime, age, manafacturer);
    }

    @ManyToOne
    @JoinColumn(name = "type_of_bus", referencedColumnName = "type_of_bus", nullable = false,insertable=false,updatable=false)
    public PriceMultiplierEntity getPriceMultiplierByTypeOfBus() {
        return priceMultiplierByTypeOfBus;
    }

    public void setPriceMultiplierByTypeOfBus(PriceMultiplierEntity priceMultiplierByTypeOfBus) {
        this.priceMultiplierByTypeOfBus = priceMultiplierByTypeOfBus;
    }

    @ManyToOne
    @JoinColumn(name = "bus_number", referencedColumnName = "bus_number", nullable = false,insertable=false,updatable=false)
    public DriversEntity getDriversByBusNumber() {
        return driversByBusNumber;
    }

    public void setDriversByBusNumber(DriversEntity driversByBusNumber) {
        this.driversByBusNumber = driversByBusNumber;
    }

    @OneToMany(mappedBy = "bus")
    public Collection<TiketEntity> getTikets() {
        return tikets;
    }

    public void setTikets(Collection<TiketEntity> tikets) {
        this.tikets = tikets;
    }

    public BusEntity(Integer idBus, String busNumber, Integer freeSeats, String typeOfBus, String departueDate, String returnTime, Integer age, String manafacturer) {
        this.idBus = idBus;
        this.busNumber = busNumber;
        this.freeSeats = freeSeats;
        this.typeOfBus = typeOfBus;
        this.departueDate = departueDate;
        this.returnTime = returnTime;
        this.age = age;
        this.manafacturer = manafacturer;

    }

    public BusEntity() {
    }
    @ManyToMany
    @JoinTable(name = "bus_has_road", schema = "mydb",
            joinColumns = @JoinColumn(name = "bus_id_bus", referencedColumnName = "id_bus", nullable = false), inverseJoinColumns = @JoinColumn(name = "road_id_road", referencedColumnName = "id_road", nullable = false))
    private List<RoadEntity> persons;
    @Override
    public String toString() {
        return String.format("%-11d %-8s %-11d %-4s %s %s %-11d %s"
                , idBus
                , busNumber
                , freeSeats
                , typeOfBus
                , departueDate
                , returnTime
                , age
                , manafacturer);
    }
}
