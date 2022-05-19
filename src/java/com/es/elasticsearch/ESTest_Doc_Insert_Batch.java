package com.es.elasticsearch;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

/**
 * 说明：
 * Created by jiang on 2022/5/17 17:36
 */
public class ESTest_Doc_Insert_Batch {

    public static void main(String[] args) throws Exception {

        // 创建 ElasticSearch客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder( new HttpHost("127.0.0.1",9200,"http"))
        );

        // 批量插入数据
        BulkRequest request = new BulkRequest();
        request.add(new IndexRequest().index("user").id("12").source(XContentType.JSON, "name", "张三", "age", 12, "sex", "男"));
        request.add(new IndexRequest().index("user").id("13").source(XContentType.JSON, "name", "张四", "age", 13, "sex", "男"));
        request.add(new IndexRequest().index("user").id("14").source(XContentType.JSON, "name", "张五", "age", 14, "sex", "女"));
        request.add(new IndexRequest().index("user").id("15").source(XContentType.JSON, "name", "张六", "age", 15, "sex", "男"));
        request.add(new IndexRequest().index("user").id("16").source(XContentType.JSON, "name", "张七", "age", 16, "sex", "女"));
        request.add(new IndexRequest().index("user").id("17").source(XContentType.JSON, "name", "张八", "age", 17, "sex", "男"));

        // 向 Es插入数据, 必须将数据转换为JSON格式
        BulkResponse response = esClient.bulk(request, RequestOptions.DEFAULT);

        System.out.println(response.getTook());
        System.out.println(response.getIngestTook());

        // 关闭 ElasticSearch客户端
        esClient.close();
    }

}
