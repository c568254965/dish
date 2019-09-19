package com.huarui.es.service;

import com.huarui.es.repository.MenuRepository;
import com.huarui.es.type.Menu;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.metrics.avg.AvgAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.max.MaxAggregationBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sloan on 2019/7/15.
 */

@Service
public class MenuService {

    @Autowired
    MenuRepository menuRepository;

    public List<Menu> selectByName(String name){


        return  menuRepository.findMenuByStepsAndTitle("鸭架","鸭");
    }

    public Page<Menu> selectByNamePage(String title, int startPage, int pageSize) {


        QueryBuilder queryBuilder = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("title",title));



        //分页查询...从0页开始.
        Page<Menu> search = menuRepository.search(queryBuilder, PageRequest.of(startPage, pageSize));


        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //构建查询
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();

        FieldSortBuilder sort = SortBuilders.fieldSort("id").order(SortOrder.ASC);


//        nativeSearchQueryBuilder.withSort(sort);  //排序
//        nativeSearchQueryBuilder.withQuery(queryBuilder); //查询条件
//        nativeSearchQueryBuilder.withPageable(PageRequest.of(startPage,pageSize)); //分页...
//        NativeSearchQuery build = nativeSearchQueryBuilder.build();

  //      Page<Menu> page = menuRepository.search(build);

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //多字段查询...                                  没有中文分词
        MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery(title, "title", "imtro");
        Iterable<Menu> search1 = menuRepository.search(multiMatchQueryBuilder);
        for (Menu menu : search1) {
            System.out.println(menu.getTitle()+"oooooooooooooooo");
        }

        //*****************************************
        MaxAggregationBuilder maxBuilder = AggregationBuilders.max("wordCount-csrr").field("wordCount1");

        nativeSearchQueryBuilder.addAggregation(maxBuilder);




        return null;
    }
}
