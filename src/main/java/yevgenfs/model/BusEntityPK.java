package yevgenfs.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class BusEntityPK implements Serializable {
    private Integer idBus;
    private String typeOfBus;

    @Column(name = "id_bus")
    @Id
    public Integer getIdBus() {
        return idBus;
    }

    public void setIdBus(Integer idBus) {
        this.idBus = idBus;
    }

    @Column(name = "type_of_bus")
    @Id
    public String getTypeOfBus() {
        return typeOfBus;
    }

    public void setTypeOfBus(String typeOfBus) {
        this.typeOfBus = typeOfBus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusEntityPK that = (BusEntityPK) o;
        return Objects.equals(idBus, that.idBus) &&
                Objects.equals(typeOfBus, that.typeOfBus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBus, typeOfBus);
    }

    public BusEntityPK() {
    }

    public BusEntityPK(Integer idBus, String typeOfBus) {
        this.idBus = idBus;
        this.typeOfBus = typeOfBus;
    }

    @Override
    public String toString() {
        return "BusEntityPK{" +
                "idBus=" + idBus +
                ", typeOfBus='" + typeOfBus + '\'' +
                '}';
    }
}
