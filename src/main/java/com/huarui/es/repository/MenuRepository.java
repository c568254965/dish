package com.huarui.es.repository;

import com.huarui.es.type.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by sloan on 2019/7/15.
 */


public interface MenuRepository extends ElasticsearchRepository<Menu,Long> {

    List<Menu> findByTitle(String name);
    List<Menu> findAllBy();
    List<Menu> findMenuByStepsAndTitle(String step,String title);



}
