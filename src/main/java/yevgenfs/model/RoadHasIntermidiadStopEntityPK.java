package yevgenfs.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class RoadHasIntermidiadStopEntityPK implements Serializable {
    private Integer roadIdRoad;
    private Integer stopIdcity;

    @Column(name = "road_id_road")
    @Id
    public Integer getRoadIdRoad() {
        return roadIdRoad;
    }

    public void setRoadIdRoad(Integer roadIdRoad) {
        this.roadIdRoad = roadIdRoad;
    }

    @Column(name = "stop_idcity")
    @Id
    public Integer getStopIdcity() {
        return stopIdcity;
    }

    public void setStopIdcity(Integer stopIdcity) {
        this.stopIdcity = stopIdcity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoadHasIntermidiadStopEntityPK that = (RoadHasIntermidiadStopEntityPK) o;
        return Objects.equals(roadIdRoad, that.roadIdRoad) &&
                Objects.equals(stopIdcity, that.stopIdcity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roadIdRoad, stopIdcity);
    }

    public RoadHasIntermidiadStopEntityPK() {
    }

    public RoadHasIntermidiadStopEntityPK(Integer roadIdRoad, Integer stopIdcity) {
        this.roadIdRoad = roadIdRoad;
        this.stopIdcity = stopIdcity;
    }

    @Override
    public String toString() {
        return "RoadHasIntermidiadStopEntityPK{" +
                "roadIdRoad=" + roadIdRoad +
                ", stopIdcity=" + stopIdcity +
                '}';
    }
}
