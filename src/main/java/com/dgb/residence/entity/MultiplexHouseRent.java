package com.dgb.residence.entity;

import com.dgb.constant.ResidenceType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

import java.time.YearMonth;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "MULTIPLEX_HOUSE_RENT")
public class MultiplexHouseRent extends ResidenceRent {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mhouseNm;

    @Builder
    public MultiplexHouseRent(YearMonth dealDate, Point point, Integer deposit, Integer monthlyRent, String mhouseNm) {
        super(ResidenceType.연립다세대, dealDate, point, deposit, monthlyRent);
        this.mhouseNm = mhouseNm;
    }

    @Override
    public String toString() {
        return "MultiplexHouseRent{" +
                "dealDate=" + getDealDate() +
                ", dealType=" + getDealType() +
                ", point=" + getPoint() +
                ", deposit=" + getDeposit() +
                ", monthlyRent=" + getMonthlyRent() +
                ", mhouseNm='" + mhouseNm + '\'' +
                '}';
    }

    @Override
    public void update(Residence newResidence) {
        if (newResidence instanceof MultiplexHouseRent newMultiplexHouseRent) {
            this.dealDate = newMultiplexHouseRent.getDealDate();
            this.dealType = newMultiplexHouseRent.getDealType();
            this.point = newMultiplexHouseRent.getPoint();
            this.deposit = newMultiplexHouseRent.getDeposit();
            this.monthlyRent = newMultiplexHouseRent.getMonthlyRent();
            this.mhouseNm = newMultiplexHouseRent.getMhouseNm();
        } else {
            throw new IllegalArgumentException("Invalid entity type for update");
        }
    }
}
