package com.huarui.es.service;

import com.huarui.es.repository.MenuRepository;
import com.huarui.es.repository.NovelRepository;
import com.huarui.es.type.Menu;
import com.huarui.es.type.Novel;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeRequestBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by sloan on 2019/7/15.
 */

@Service
public class NovelService {

    @Autowired
    NovelRepository novelRepository;

    public void addNovel(Long id,Integer wordCount, String bookName, String author,String brief) {


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Novel novel = new Novel();
        novel.setId(id);
        novel.setWordCount(wordCount);
        novel.setBookName(bookName);
        novel.setAuthor(author);
        novel.setBriefIntroduction(brief);
        novel.setPublishDate(sdf.format(new Date()));

        novelRepository.save(novel);
    }

    public Page<Novel> selectNovel(String query) {

        QueryBuilder queryBuilder = QueryBuilders.boolQuery().must(QueryBuilders.multiMatchQuery(query,"bookName","briefIntroduction"));

        //前一个是字段，后一个是值....
        MatchQueryBuilder builder2 = QueryBuilders.matchQuery("briefIntroduction",query);

        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(queryBuilder);

        Page<Novel> search = novelRepository.search(nativeSearchQueryBuilder.build());


        return search;


    }
}
