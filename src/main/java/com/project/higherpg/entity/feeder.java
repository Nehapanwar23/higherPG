package com.project.higherpg.entity;




;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "Feeder")
public class feeder {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feeder_sequence")
    @SequenceGenerator(name = "feeder_sequence", sequenceName = "YOUR_SEQUENCE_NAME", allocationSize = 1)
    private Long FID;
    @Getter
    @Setter
    private String feederName;
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
    @Getter
    @Setter
    @Column(nullable = false, columnDefinition = "NUMBER(1,0) default 1")
    private boolean status;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="RSID" , referencedColumnName = "RSID")
    private receivingStation receivingStation;

    public void updateFeederStatus() {
        if (receivingStation != null && !receivingStation.getStatus()) {
            // If the associated receivingStation status is false, feeder should not work
            this.status = false;
            this.offTime = null;
            this.onTime = null;
        } else {
            // If the associated receivingStation is null or has true status, update offTime and onTime based on status
            if (status) {
                this.onTime = getCurrentTime();
                this.offTime = null;
            } else {
                this.offTime = getCurrentTime();
                this.onTime = null;
            }
        }
    }

    private String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        return dateFormat.format(now);
    }



}


