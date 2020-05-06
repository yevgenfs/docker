package yevgenfs.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "road_has_intermidiad_stop", schema = "mydb", catalog = "")
@IdClass(RoadHasIntermidiadStopEntityPK.class)
public class RoadHasIntermidiadStopEntity {
    private Integer roadIdRoad;
    private Integer stopIdcity;
    private Integer numberOfStop;
    private RoadEntity roadByRoadIdRoad;
    private CityEntity cityByStopIdcity;



    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "road_id_road")
    public Integer getRoadIdRoad() {
        return roadIdRoad;
    }

    public void setRoadIdRoad(Integer roadIdRoad) {
        this.roadIdRoad = roadIdRoad;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "stop_idcity")
    public Integer getStopIdcity() {
        return stopIdcity;
    }

    public void setStopIdcity(Integer stopIdcity) {
        this.stopIdcity = stopIdcity;
    }

    @Basic
    @Column(name = "number_of_stop")
    public Integer getNumberOfStop() {
        return numberOfStop;
    }

    public void setNumberOfStop(Integer numberOfStop) {
        this.numberOfStop = numberOfStop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoadHasIntermidiadStopEntity that = (RoadHasIntermidiadStopEntity) o;
        return Objects.equals(roadIdRoad, that.roadIdRoad) &&
                Objects.equals(stopIdcity, that.stopIdcity) &&
                Objects.equals(numberOfStop, that.numberOfStop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roadIdRoad, stopIdcity, numberOfStop);
    }

    @ManyToOne
    @JoinColumn(name = "road_id_road", referencedColumnName = "id_road", nullable = false,insertable=false,updatable=false)
    public RoadEntity getRoadByRoadIdRoad() {
        return roadByRoadIdRoad;
    }

    public void setRoadByRoadIdRoad(RoadEntity roadByRoadIdRoad) {
        this.roadByRoadIdRoad = roadByRoadIdRoad;
    }

    @ManyToOne
    @JoinColumn(name = "stop_idcity", referencedColumnName = "idcity", nullable = false,insertable=false,updatable=false)
    public CityEntity getCityByStopIdcity() {
        return cityByStopIdcity;
    }

    public void setCityByStopIdcity(CityEntity cityByStopIdcity) {
        this.cityByStopIdcity = cityByStopIdcity;
    }

    public RoadHasIntermidiadStopEntity() {
    }

    public RoadHasIntermidiadStopEntity(Integer roadIdRoad, Integer stopIdcity, Integer numberOfStop) {
        this.roadIdRoad = roadIdRoad;
        this.stopIdcity = stopIdcity;
        this.numberOfStop = numberOfStop;

    }

    @Override
    public String toString() {
        return String.format("%-11s %-11s %-11s ", roadIdRoad , stopIdcity , numberOfStop);
    }
}
