package yevgenfs.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "price_multiplier", schema = "mydb", catalog = "")
public class PriceMultiplierEntity {
    private String typeOfBus;
    private Integer priceCountercol;
    private Collection<BusEntity> busesByTypeOfBus;



    @Id
    @Column(name = "type_of_bus")
    public String getTypeOfBus() {
        return typeOfBus;
    }

    public void setTypeOfBus(String typeOfBus) {
        this.typeOfBus = typeOfBus;
    }

    @Basic
    @Column(name = "price_countercol")
    public Integer getPriceCountercol() {
        return priceCountercol;
    }

    public void setPriceCountercol(Integer priceCountercol) {
        this.priceCountercol = priceCountercol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceMultiplierEntity that = (PriceMultiplierEntity) o;
        return Objects.equals(typeOfBus, that.typeOfBus) &&
                Objects.equals(priceCountercol, that.priceCountercol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfBus, priceCountercol);
    }

    @OneToMany(mappedBy = "priceMultiplierByTypeOfBus")
    public Collection<BusEntity> getBusesByTypeOfBus() {
        return busesByTypeOfBus;
    }

    public void setBusesByTypeOfBus(Collection<BusEntity> busesByTypeOfBus) {
        this.busesByTypeOfBus = busesByTypeOfBus;
    }

    public PriceMultiplierEntity() {
    }

    public PriceMultiplierEntity(String typeOfBus, Integer priceCountercol) {
        this.typeOfBus = typeOfBus;
        this.priceCountercol = priceCountercol;

    }

    public String toString() {
        return String.format("%-4s %-5s" ,typeOfBus ,priceCountercol );
    }
}
