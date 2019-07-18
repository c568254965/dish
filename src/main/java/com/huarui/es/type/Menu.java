package com.huarui.es.type;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Mapping;

import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by sloan on 2019/7/15.
 */


@Document(indexName = "menu_index",type = "menu")
@Data
@Mapping(mappingPath = "mapping.json")

public class Menu implements Serializable{


    @Id
    private Long id;

    private String title;
    private String tags;
    private String imtro;
    private String ingredients;
    private String burden;
    private String albums;
    private String steps;
}
