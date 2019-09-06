package com.huarui.es.repository;

import com.huarui.es.type.Novel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by sloan on 2019/7/15.
 */


public interface NovelRepository extends ElasticsearchRepository<Novel,Long> {


}
