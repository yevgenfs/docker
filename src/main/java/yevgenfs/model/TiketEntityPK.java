package yevgenfs.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class TiketEntityPK implements Serializable {
    private Integer idorder;
    private Integer userIduser;
    private Integer busIdBus;
    private String busTypeOfBus;

    @Column(name = "idorder")
    @Id
    public Integer getIdorder() {
        return idorder;
    }

    public void setIdorder(Integer idorder) {
        this.idorder = idorder;
    }

    @Column(name = "user_iduser")
    @Id
    public Integer getUserIduser() {
        return userIduser;
    }

    public void setUserIduser(Integer userIduser) {
        this.userIduser = userIduser;
    }

    @Column(name = "bus_id_bus")
    @Id
    public Integer getBusIdBus() {
        return busIdBus;
    }

    public void setBusIdBus(Integer busIdBus) {
        this.busIdBus = busIdBus;
    }

    @Column(name = "bus_type_of_bus")
    @Id
    public String getBusTypeOfBus() {
        return busTypeOfBus;
    }

    public void setBusTypeOfBus(String busTypeOfBus) {
        this.busTypeOfBus = busTypeOfBus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TiketEntityPK that = (TiketEntityPK) o;
        return Objects.equals(idorder, that.idorder) &&
                Objects.equals(userIduser, that.userIduser) &&
                Objects.equals(busIdBus, that.busIdBus) &&
                Objects.equals(busTypeOfBus, that.busTypeOfBus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idorder, userIduser, busIdBus, busTypeOfBus);
    }

    public TiketEntityPK(Integer idorder, Integer userIduser, Integer busIdBus, String busTypeOfBus) {
        this.idorder = idorder;
        this.userIduser = userIduser;
        this.busIdBus = busIdBus;
        this.busTypeOfBus = busTypeOfBus;
    }

    public TiketEntityPK() {
    }

    @Override
    public String toString() {
        return "TiketEntityPK{" +
                "idorder=" + idorder +
                ", userIduser=" + userIduser +
                ", busIdBus=" + busIdBus +
                ", busTypeOfBus='" + busTypeOfBus + '\'' +
                '}';
    }
}
