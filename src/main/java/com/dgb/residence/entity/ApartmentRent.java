package com.dgb.residence.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

import java.time.YearMonth;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "APARTMENT_RENT")
public class ApartmentRent extends ResidenceRent {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String aptNm;

    @Builder
    public ApartmentRent(YearMonth dealDate, Point point, Integer deposit, Integer monthlyRent, String aptNm) {
        this.dealDate = dealDate;
        this.point = point;
        this.deposit = deposit;
        this.monthlyRent = monthlyRent;
        this.aptNm = aptNm;
    }

    @Override
    public String toString() {
        return "ApartmentRent{" +
                "dealDate=" + dealDate +
                ", point=" + point +
                ", deposit=" + deposit +
                ", monthlyRent=" + monthlyRent +
                ", aptNm='" + aptNm + '\'' +
                '}';
    }

    @Override
    public void update(Residence newResidence) {
        if (newResidence instanceof ApartmentRent newApartmentRent) {
            this.dealDate = newApartmentRent.getDealDate();
            this.point = newApartmentRent.getPoint();
            this.deposit = newApartmentRent.getDeposit();
            this.monthlyRent = newApartmentRent.getMonthlyRent();
            this.aptNm = newApartmentRent.getAptNm();
        } else {
            throw new IllegalArgumentException("Invalid entity type for update");
        }
    }
}
