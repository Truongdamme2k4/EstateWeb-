package com.javaweb.entity;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "building")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BuildingEntity extends BaseEntity {

    @Column(name = "name")
    String name;

    @Column(name = "street")
    String street;

    @Column(name = "ward")
    String ward;

    @Column(name = "district")
    String district;

    @Column(name = "structure")
    String structure;

    @Column(name = "numberofbasement")
    Integer numberOfBasement;

    @Column(name = "floorarea")
    Integer floorArea;

    @Column(name = "direction")

    String direction;

    @Column(name = "level")
    String level;

    @Column(name = "rentprice")
    Integer rentPrice;

    @Column(name = "rentpricedescription")
    String rentPriceDes;

    @Column(name = "servicefee")
    String serviceFee;

    @Column(name = "carfee")
    String carFee;

    @Column(name = "motofee")
    String motoFee;

    @Column(name = "overtimefee")
    String overtimeFee;

    @Column(name = "waterfee")
    String waterFee;

    @Column(name = "electricityfee")
    String electricityFee;

    @Column(name = "deposit")
    String deposit;

    @Column(name = "payment")
    String payment;

    @Column(name = "renttime")
    String rentTime;

    @Column(name = "decorationtime")
    String decorationTime;

    @Column(name = "brokeragefee")
    Integer brokerageFee;

    @Column(name = "type")
    String typeCode;

    @Column(name = "note")
    String note;

    @Column(name = "managername")
    String managerName;

    @Column(name = "managerphone")
    String managerPhone;

    @Column(name = "avatar")
    String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


//    @OneToMany(fetch = FetchType.LAZY,mappedly = "buildingEntity", cascade = (CascadeType.MERGE, CascadeType.PERSIST), orphanRemoval = true)
//    List<RentAreaEntity> rentAreaEntities = new ArrayList<>();

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "buildingEntity", cascade = CascadeType.ALL)
//    List<AssignBuildingEntity> assignBuildingEntities = new ArrayList<>();

    @OneToMany(mappedBy="building",fetch=FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE},orphanRemoval = true)
    private List<RentAreaEntity> rentAreas= new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)//, cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    @JoinTable(name = "assignmentbuilding",
                joinColumns = @JoinColumn(name = "buildingid", nullable = false),
                inverseJoinColumns = @JoinColumn(name = "staffid", nullable = false))
    private List<UserEntity> userEntities = new ArrayList<>();



}