package yevgenfs.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tiket", schema = "mydb", catalog = "")
@IdClass(TiketEntityPK.class)
public class TiketEntity {
    private Integer idorder;
    private String ticetForMan;
    private String ticetForChildren;
    private String ticetsForDisablePeople;
    private Integer extraLugage;
    private Integer userIduser;
    private Integer price;
    private Integer busIdBus;
    private String busTypeOfBus;
    private UserEntity userByUserIduser;
    private BusEntity bus;



    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idorder")
    public Integer getIdorder() {
        return idorder;
    }

    public void setIdorder(Integer idorder) {
        this.idorder = idorder;
    }

    @Basic
    @Column(name = "ticet_for_man")
    public String getTicetForMan() {
        return ticetForMan;
    }

    public void setTicetForMan(String ticetForMan) {
        this.ticetForMan = ticetForMan;
    }

    @Basic
    @Column(name = "ticet_for_children")
    public String getTicetForChildren() {
        return ticetForChildren;
    }

    public void setTicetForChildren(String ticetForChildren) {
        this.ticetForChildren = ticetForChildren;
    }

    @Basic
    @Column(name = "ticets_for_disable_people")
    public String getTicetsForDisablePeople() {
        return ticetsForDisablePeople;
    }

    public void setTicetsForDisablePeople(String ticetsForDisablePeople) {
        this.ticetsForDisablePeople = ticetsForDisablePeople;
    }

    @Basic
    @Column(name = "extra_lugage")
    public Integer getExtraLugage() {
        return extraLugage;
    }

    public void setExtraLugage(Integer extraLugage) {
        this.extraLugage = extraLugage;
    }

    @Id
    @Column(name = "user_iduser")
    public Integer getUserIduser() {
        return userIduser;
    }

    public void setUserIduser(Integer userIduser) {
        this.userIduser = userIduser;
    }

    @Basic
    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Id
    @Column(name = "bus_id_bus")
    public Integer getBusIdBus() {
        return busIdBus;
    }

    public void setBusIdBus(Integer busIdBus) {
        this.busIdBus = busIdBus;
    }

    @Id
    @Column(name = "bus_type_of_bus")
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
        TiketEntity that = (TiketEntity) o;
        return Objects.equals(idorder, that.idorder) &&
                Objects.equals(ticetForMan, that.ticetForMan) &&
                Objects.equals(ticetForChildren, that.ticetForChildren) &&
                Objects.equals(ticetsForDisablePeople, that.ticetsForDisablePeople) &&
                Objects.equals(extraLugage, that.extraLugage) &&
                Objects.equals(userIduser, that.userIduser) &&
                Objects.equals(price, that.price) &&
                Objects.equals(busIdBus, that.busIdBus) &&
                Objects.equals(busTypeOfBus, that.busTypeOfBus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idorder, ticetForMan, ticetForChildren, ticetsForDisablePeople, extraLugage, userIduser, price, busIdBus, busTypeOfBus);
    }

    @ManyToOne
    @JoinColumn(name = "user_iduser", referencedColumnName = "iduser", nullable = false,insertable=false,updatable=false)
    public UserEntity getUserByUserIduser() {
        return userByUserIduser;
    }

    public void setUserByUserIduser(UserEntity userByUserIduser) {
        this.userByUserIduser = userByUserIduser;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "bus_id_bus", referencedColumnName = "id_bus", nullable = false,insertable=false,updatable=false), @JoinColumn(name = "bus_type_of_bus", referencedColumnName = "type_of_bus", nullable = false,insertable=false,updatable=false)})
    public BusEntity getBus() {
        return bus;
    }

    public void setBus(BusEntity bus) {
        this.bus = bus;
    }

    public TiketEntity() {
    }

    public TiketEntity(Integer idorder, String ticetForMan, String ticetForChildren, String ticetsForDisablePeople, Integer extraLugage, Integer userIduser, Integer price, Integer busIdBus, String busTypeOfBus) {
        this.idorder = idorder;
        this.ticetForMan = ticetForMan;
        this.ticetForChildren = ticetForChildren;
        this.ticetsForDisablePeople = ticetsForDisablePeople;
        this.extraLugage = extraLugage;
        this.userIduser = userIduser;
        this.price = price;
        this.busIdBus = busIdBus;
        this.busTypeOfBus = busTypeOfBus;

    }

    @Override
    public String toString() {
        return String.format(" %-11d %-3s %-3s %-3s %-11d %-11d %-10d %-11d %-4s" , idorder ,ticetForMan ,ticetForChildren , ticetsForDisablePeople , extraLugage , userIduser ,price , busIdBus , busTypeOfBus );
    }
}
