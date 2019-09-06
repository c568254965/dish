package com.huarui.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by sloan on 2019/7/13.
 */

@Data
@Table(name = "dish")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String tags;
    private String imtro;
    private String ingredients;
    private String burden;
    private String albums;
    private String steps;



}
