package com.es.elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

/**
 * 说明：
 * Created by jiang on 2022/5/17 17:36
 */
public class ESTest_Doc_Delete_Batch {

    public static void main(String[] args) throws Exception {

        // 创建 ElasticSearch客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder( new HttpHost("127.0.0.1",9200,"http"))
        );

        // 批量删除数据
        BulkRequest request = new BulkRequest();
        request.add(new DeleteRequest().index("user").id("12"));
        request.add(new DeleteRequest().index("user").id("13"));
        request.add(new DeleteRequest().index("user").id("14"));

        // 向 Es插入数据, 必须将数据转换为JSON格式
        BulkResponse response = esClient.bulk(request, RequestOptions.DEFAULT);

        System.out.println(response.getTook());
        System.out.println(response.getIngestTook());

        // 关闭 ElasticSearch客户端
        esClient.close();
    }

}
