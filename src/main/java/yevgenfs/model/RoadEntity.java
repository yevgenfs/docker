package yevgenfs.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "road", schema = "mydb", catalog = "")
public class RoadEntity {
    private Integer idRoad;
    private Integer mileageOfRoad;
    private Collection<RoadHasIntermidiadStopEntity> roadHasIntermidiadStopsByIdRoad;



    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_road")
    public Integer getIdRoad() {
        return idRoad;
    }

    public void setIdRoad(Integer idRoad) {
        this.idRoad = idRoad;
    }

    @Basic
    @Column(name = "mileage_of_road" )
    public Integer getMileageOfRoad() {
        return mileageOfRoad;
    }

    public void setMileageOfRoad(Integer mileageOfRoad) {
        this.mileageOfRoad = mileageOfRoad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoadEntity that = (RoadEntity) o;
        return Objects.equals(idRoad, that.idRoad) &&
                Objects.equals(mileageOfRoad, that.mileageOfRoad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRoad, mileageOfRoad);
    }

    @OneToMany(mappedBy = "roadByRoadIdRoad" )
    public Collection<RoadHasIntermidiadStopEntity> getRoadHasIntermidiadStopsByIdRoad() {
        return roadHasIntermidiadStopsByIdRoad;
    }

    public void setRoadHasIntermidiadStopsByIdRoad(Collection<RoadHasIntermidiadStopEntity> roadHasIntermidiadStopsByIdRoad) {
        this.roadHasIntermidiadStopsByIdRoad = roadHasIntermidiadStopsByIdRoad;
    }

    public RoadEntity() {
    }

    public RoadEntity(Integer idRoad, Integer mileageOfRoad  ) {
        this.idRoad = idRoad;
        this.mileageOfRoad = mileageOfRoad;

    }
    @ManyToMany(mappedBy = "persons")
    private List<BusEntity> books;
    @Override
    public String toString() {
        return String.format("%-11d %-10d", idRoad, mileageOfRoad );
    }

}
