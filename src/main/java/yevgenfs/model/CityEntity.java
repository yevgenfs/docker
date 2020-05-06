package yevgenfs.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "city", schema = "mydb", catalog = "")
public class CityEntity {
    private Integer idcity;
    private String cityName;
    private Collection<RoadHasIntermidiadStopEntity> roadHasIntermidiadStopsByIdcity;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcity")
    public Integer getIdcity() {
        return idcity;
    }

    public void setIdcity(Integer idcity) {
        this.idcity = idcity;
    }

    @Basic
    @Column(name = "city_name")
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityEntity that = (CityEntity) o;
        return Objects.equals(idcity, that.idcity) &&
                Objects.equals(cityName, that.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcity, cityName);
    }

    @OneToMany(mappedBy = "cityByStopIdcity")
    public Collection<RoadHasIntermidiadStopEntity> getRoadHasIntermidiadStopsByIdcity() {
        return roadHasIntermidiadStopsByIdcity;
    }

    public void setRoadHasIntermidiadStopsByIdcity(Collection<RoadHasIntermidiadStopEntity> roadHasIntermidiadStopsByIdcity) {
        this.roadHasIntermidiadStopsByIdcity = roadHasIntermidiadStopsByIdcity;
    }

    public CityEntity(Integer idcity, String cityName) {
        this.idcity = idcity;
        this.cityName = cityName;

    }

    public CityEntity() {
    }

    public CityEntity(String cityName) {
        this.cityName = cityName;
    }

    public String toString() {
        return String.format( "%-11d %s " ,idcity ,cityName );
    }
}
