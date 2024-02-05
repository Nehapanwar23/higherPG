package com.project.higherpg.entity;






import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "pumpenergy")
public class pumpEnergy {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feeder_sequence")
    @SequenceGenerator(name = "feeder_sequence", sequenceName = "YOUR_SEQUENCE_NAME", allocationSize = 1)
    private Long Id;
    @Getter
    @Setter
    private String RST;
    @Getter
    @Setter
    private String subDivision;
    @Getter
    @Setter
    private String feeder;
    @Getter
    @Setter
    private String TotalSupply;
    @Getter
    @Setter
    private String KW;

    @Setter
    @Getter
    @Temporal(TemporalType.TIMESTAMP)
    private Date energyDate;

    public void setEnergyDateString(String energyDateString) {
        // Assuming energyDateString is in a format that can be parsed
        // Adjust the parsing logic based on the actual format
        try {
            this.energyDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(energyDateString);
        } catch (ParseException e) {
            e.printStackTrace();
            // Handle the parsing exception as needed
        }
    }

    public String getEnergyDateString() {
        // Assuming energy_date should be returned in a specific format (e.g., ISO 8601)
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(this.energyDate);
    }

}
