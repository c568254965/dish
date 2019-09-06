package com.huarui.es.type;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Mapping;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by sloan on 2019/7/15.
 */


@Document(indexName = "book_v5",type = "novel")
@Data
@Mapping(mappingPath = "mapping.json")

public class Novel implements Serializable{


    @Id
    private Long id;

    @Field(searchAnalyzer = "ik_smart", analyzer = "ik_smart")
    private String bookName;

    private Integer  wordCount;

    private String author;
    private String publishDate;
    @Field(searchAnalyzer = "ik_smart", analyzer = "ik_smart")
    private String briefIntroduction;

    //分词使用的注意事项，要在es建立index的时候，精确到字段指明使用(zk)分词器..同时在java端，实体类上，使用Field注解来一对一指明分词器

// "briefIntroduction":{
//        "type":"text",
//                "analyzer": "ik_smart",
//                "search_analyzer": "ik_smart"
//    },
}
