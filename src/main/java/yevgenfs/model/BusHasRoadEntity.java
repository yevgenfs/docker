package yevgenfs.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "bus_has_road", schema = "mydb", catalog = "")
@IdClass(BusHasRoadEntityPK.class)
public class BusHasRoadEntity {
    private Integer busIdBus;
    private Integer roadIdRoad;

    @Id
    @Column(name = "bus_id_bus")
    public Integer getBusIdBus() {
        return busIdBus;
    }

    public void setBusIdBus(Integer busIdBus) {
        this.busIdBus = busIdBus;
    }

    @Id
    @Column(name = "road_id_road")
    public Integer getRoadIdRoad() {
        return roadIdRoad;
    }

    public void setRoadIdRoad(Integer roadIdRoad) {
        this.roadIdRoad = roadIdRoad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusHasRoadEntity that = (BusHasRoadEntity) o;
        return Objects.equals(busIdBus, that.busIdBus) &&
                Objects.equals(roadIdRoad, that.roadIdRoad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(busIdBus, roadIdRoad);
    }
}
