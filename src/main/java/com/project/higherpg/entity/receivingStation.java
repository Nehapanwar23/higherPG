package com.project.higherpg.entity;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ReceivingStation")
public class receivingStation {

    @Id
    @GeneratedValue(generator = "UUID")
    @Setter
    @Getter// Use a UUID generator
    private UUID RSID;

    @Getter
    @Setter
    private String stationName;
    @Getter
    @Setter
    private String reason;
    @Getter
    @Setter
    private String lastUpdate;
    @Getter
    @Setter
    private String offTime;
    @Getter
    @Setter
    private String onTime;
    //@Getter
    @Setter
    @Column(nullable = false, columnDefinition = "NUMBER(1,0) default 1")
    private boolean status;

    public Boolean getStatus() {
        return this.status;
    }
    public void updateOnOffTime() {
        if (status) {
            // If status is true, update onTime
            onTime = getCurrentTime();
        } else {
            // If status is false, update offTime
            offTime = getCurrentTime();
        }
    }

    private String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        return dateFormat.format(now);
    }


//		@Column(name = "user_id", updatable = false, nullable = false)
//		private UUID user_id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false, updatable = false)
    private Date createDate;

    @PrePersist
    protected void onCreate() {
        createDate = new Date();
    }

}


