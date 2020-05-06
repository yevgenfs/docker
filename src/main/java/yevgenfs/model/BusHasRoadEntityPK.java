package yevgenfs.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class BusHasRoadEntityPK implements Serializable {
    private Integer busIdBus;
    private Integer roadIdRoad;

    @Column(name = "bus_id_bus")
    @Id
    public Integer getBusIdBus() {
        return busIdBus;
    }

    public void setBusIdBus(Integer busIdBus) {
        this.busIdBus = busIdBus;
    }

    @Column(name = "road_id_road")
    @Id
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
        BusHasRoadEntityPK that = (BusHasRoadEntityPK) o;
        return Objects.equals(busIdBus, that.busIdBus) &&
                Objects.equals(roadIdRoad, that.roadIdRoad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(busIdBus, roadIdRoad);
    }
}
