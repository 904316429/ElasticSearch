package com.es.elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;

/**
 * 说明：
 * Created by jiang on 2022/5/17 17:36
 */
public class ESTest_Doc_Query {

    public static void main(String[] args) throws Exception {

        // 创建 ElasticSearch客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1", 9200, "http"))
        );

        // 1.查询索引中所有的数据数据
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchResponse response = esClient.search(request.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery())), RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit s : hits) {
//            System.out.println(s.getSourceAsString());
//        }

        // 2.条件查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchResponse response = esClient.search(
//                request.source(
//                        new SearchSourceBuilder()
//                                .query(QueryBuilders
//                                        .termQuery("age", 15))),
//                RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit s : hits) {
//            System.out.println(s.getSourceAsString());
//        }

        // 3.分页查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder()
//                .query(QueryBuilders
//                        .matchAllQuery());
//        builder.from(0); //(页码-1) * 每页条数
//        builder.size(2);
//
//        SearchResponse response = esClient.search(
//                request.source(builder),
//                RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit s : hits) {
//            System.out.println(s.getSourceAsString());
//        }

        // 4.查询排序
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder()
//                .query(QueryBuilders
//                        .matchAllQuery());
//        builder.sort("age", SortOrder.DESC);
//
//        SearchResponse response = esClient.search(
//                request.source(builder),
//                RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit s : hits) {
//            System.out.println(s.getSourceAsString());
//        }

        // 5.过滤字段
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder()
//                .query(QueryBuilders
//                        .matchAllQuery());
//        String[] excludes = {"age"};// 排除
//        String[] includes = {};// 包含
//        builder.fetchSource(includes, excludes);
//
//        SearchResponse response = esClient.search(
//                request.source(builder),
//                RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit s : hits) {
//            System.out.println(s.getSourceAsString());
//        }

        // 6.组合查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//
//        // 等于
////        boolQueryBuilder.must(QueryBuilders.matchQuery("age", 15));
////        boolQueryBuilder.must(QueryBuilders.matchQuery("sex", "男"));
//        // 不等于
////        boolQueryBuilder.mustNot(QueryBuilders.matchQuery("sex", "男"));
//        // 或者
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age", 15));
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age", 17));
//
//        builder.query(boolQueryBuilder);
//
//        SearchResponse response = esClient.search(
//                request.source(builder),
//                RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit s : hits) {
//            System.out.println(s.getSourceAsString());
//        }

        // 7.范围查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("age");
//        rangeQuery.gte(12);
//        rangeQuery.lte(15);
//
//        builder.query(rangeQuery);
//
//        SearchResponse response = esClient.search(
//                request.source(builder),
//                RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit s : hits) {
//            System.out.println(s.getSourceAsString());
//        }

        // 8.模糊查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//
//        builder.query(QueryBuilders.fuzzyQuery("name", "张五").fuzziness(Fuzziness.ONE));
//
//        SearchResponse response = esClient.search(
//                request.source(builder),
//                RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit s : hits) {
//            System.out.println(s.getSourceAsString());
//        }

        // 9.高亮查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//
//        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "张");
//
//        HighlightBuilder highlightBuilder = new HighlightBuilder();
//        highlightBuilder.preTags("<font color='red'>");
//        highlightBuilder.postTags("</font>");
//        highlightBuilder.field("name");
//
//        builder.highlighter(highlightBuilder);
//        builder.query(termQueryBuilder);
//
//        SearchResponse response = esClient.search(
//                request.source(builder),
//                RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit s : hits) {
//            System.out.println(s.getSourceAsString());
//        }

        // 10.聚合查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        AggregationBuilder aggregationBuilder = AggregationBuilders.max("maxAge").field("age");
//        builder.aggregation(aggregationBuilder);
//
//        SearchResponse response = esClient.search(
//                request.source(builder),
//                RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit s : hits) {
//            System.out.println(s.getSourceAsString());
//        }

        // 11.分组查询
        SearchRequest request = new SearchRequest();
        request.indices("user");

        SearchSourceBuilder builder = new SearchSourceBuilder();
        AggregationBuilder aggregationBuilder = AggregationBuilders.terms("ageGroup").field("age");
        builder.aggregation(aggregationBuilder);

        SearchResponse response = esClient.search(
                request.source(builder),
                RequestOptions.DEFAULT);

        SearchHits hits = response.getHits();

        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());

        for (SearchHit s : hits) {
            System.out.println(s.getSourceAsString());
        }

        // 关闭 ElasticSearch客户端
        esClient.close();
    }

}
