package bean;

import java.time.LocalDateTime;

public class Orders {
    private Integer id;
    private Integer good_ID;
    private Integer number;
    private LocalDateTime dateTime;

    public Orders(Integer good_ID, Integer number, LocalDateTime dateTime) {
        this.good_ID = good_ID;
        this.number = number;
        this.dateTime = dateTime;
    }

    public Orders() {

    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", \ngood_ID=" + good_ID +
                ", \nnumber=" + number +
                ", \ndateTime=" + dateTime +
                "\n}";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGood_ID() {
        return good_ID;
    }

    public void setGood_ID(Integer good_ID) {
        this.good_ID = good_ID;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
