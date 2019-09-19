import com.alibaba.fastjson.JSON;
import com.huarui.Dishes_App;
import com.huarui.es.repository.NovelRepository;
import com.huarui.es.type.Novel;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.LongTerms;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.avg.AvgAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.avg.InternalAvg;
import org.elasticsearch.search.aggregations.metrics.max.MaxAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.valuecount.ValueCountAggregationBuilder;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ResultsExtractor;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

/**
 * Created by sloan on 2019/9/8.
 */


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Dishes_App.class)
public class DishTest {



    @Autowired
    NovelRepository novelRepository;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    @Test
    public void test1() {

        //                                                           自己取的名字                 es中的字段名称
        MaxAggregationBuilder aggBuilder = AggregationBuilders.max("wordCount-csrr").field("wordCount1");
        //                                                          自己取的名字          字段名称.
        AvgAggregationBuilder wordCount = AggregationBuilders.avg("wordAve").field("wordCount");
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.addAggregation(aggBuilder);

        Aggregations query = elasticsearchTemplate.query(nativeSearchQueryBuilder.build(), new ResultsExtractor<Aggregations>() {

            @Override
            public Aggregations extract(SearchResponse searchResponse) {
            return                 searchResponse.getAggregations();
            }
        });
        Map<String, Aggregation> asMap = query.asMap();
        //重点，，类型转换
        InternalAvg internalAvg = (InternalAvg)asMap.get("wordAve");
        //获取平均值.....
        System.out.println(com.alibaba.fastjson.JSONObject.toJSONString(internalAvg)+"~~"+        internalAvg.getValue());

        Page<Novel> search1 = novelRepository.search(nativeSearchQueryBuilder.build());
        System.out.println("~~");

        System.out.println(com.alibaba.fastjson.JSONObject.toJSONString(search1));


    }


    /**
     * 按字段分组
     */
    @Test
    public void test2() {

        TermsAggregationBuilder termsAggregationBuilder = AggregationBuilders.terms("wordCount").field("wordCount").order(Terms.Order.count(false));

        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();

        nativeSearchQueryBuilder.addAggregation(termsAggregationBuilder);

        Aggregations aggregations = elasticsearchTemplate.query(nativeSearchQueryBuilder.build(), new ResultsExtractor<Aggregations>() {
            @Override
            public Aggregations extract(SearchResponse searchResponse) {
                return searchResponse.getAggregations();
            }
        });

        Map<String, Aggregation> map = aggregations.asMap();
        LongTerms wordCount = (LongTerms) map.get("wordCount");
        wordCount.getBuckets().forEach(
                a-> {
                    System.out.println(a.getKey()+"~~"); //分组的..
                    System.out.println(a.getDocCount()+"!!");  //对应的结果..

                }
        );




    }

    /**
     * 统计某个字段的数量...
     */
    @Test
    public void test3() {

        ValueCountAggregationBuilder aggregationBuilder = AggregationBuilders.count("wordCount").field("wordCount");

        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.addAggregation(aggregationBuilder);
        Aggregations query = elasticsearchTemplate.query(nativeSearchQueryBuilder.build(), new ResultsExtractor<Aggregations>() {
            @Override
            public Aggregations extract(SearchResponse searchResponse) {
                return searchResponse.getAggregations();
            }
        });

        Map<String, Aggregation> map = query.getAsMap();

        System.out.println(
                com.alibaba.fastjson.JSONObject.toJSONString(map)
        );

        for (String s : map.keySet()) {
            System.out.println("key:"+s);
            System.out.println("value:"+map.get(s));
        }

    }

}
