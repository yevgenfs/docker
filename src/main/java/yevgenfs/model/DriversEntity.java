package yevgenfs.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "drivers", schema = "mydb", catalog = "")
public class DriversEntity   {
    private Integer idDriver;
    private String name;
    private String busNumber;
    private String phoneNumber;
    private String lastDrivenBus;
    private Integer numberOfBusChanged;
    private Collection<BusEntity> byNumber;



    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_driver")
    public Integer getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(Integer idDriver) {
        this.idDriver = idDriver;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "last_driven_bus")
    public String getLastDrivenBus() {
        return lastDrivenBus;
    }

    public void setLastDrivenBus(String lastDrivenBus) {
        this.lastDrivenBus = lastDrivenBus;
    }

    @Basic
    @Column(name = "number_of_bus_changed")
    public Integer getNumberOfBusChanged() {
        return numberOfBusChanged;
    }

    public void setNumberOfBusChanged(Integer numberOfBusChanged) {
        this.numberOfBusChanged = numberOfBusChanged;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriversEntity that = (DriversEntity) o;
        return Objects.equals(idDriver, that.idDriver) &&
                Objects.equals(name, that.name) &&
                Objects.equals(busNumber, that.busNumber) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(lastDrivenBus, that.lastDrivenBus) &&
                Objects.equals(numberOfBusChanged, that.numberOfBusChanged);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDriver, name, busNumber, phoneNumber, lastDrivenBus, numberOfBusChanged);
    }

    @OneToMany(mappedBy = "driversByBusNumber")
    public Collection<BusEntity> getByNumber() {
        return byNumber;
    }

    public void setByNumber(Collection<BusEntity> byNumber) {
        this.byNumber = byNumber;
    }

    public DriversEntity() {
    }

    public DriversEntity(Integer idDriver, String name, String busNumber, String phoneNumber, String lastDrivenBus, Integer numberOfBusChanged) {
        this.idDriver = idDriver;
        this.name = name;
        this.busNumber = busNumber;
        this.phoneNumber = phoneNumber;
        this.lastDrivenBus = lastDrivenBus;
        this.numberOfBusChanged = numberOfBusChanged;

    }

    @Override
    public String toString() {
        return String.format("%-11d %s %-8s %s %-8s %-11d" , idDriver ,name  , phoneNumber ,  lastDrivenBus ,numberOfBusChanged );
    }
}
