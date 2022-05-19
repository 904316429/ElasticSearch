package com.es.elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

/**
 * 说明：
 * Created by jiang on 2022/5/17 17:36
 */
public class ESTest_Index_Search {

    public static void main(String[] args) throws Exception {

        // 创建 ElasticSearch客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder( new HttpHost("127.0.0.1",9200,"http"))
        );

        // 查询索引
        GetIndexRequest request = new GetIndexRequest("user");
        GetIndexResponse getIndexResponse = esClient.indices().get(request, RequestOptions.DEFAULT);

        // 响应状态
        System.out.println("索引操作：" + getIndexResponse.getAliases());
        System.out.println("索引操作：" + getIndexResponse.getMappings());
        System.out.println("索引操作：" + getIndexResponse.getSettings());

        // 关闭 ElasticSearch客户端
        esClient.close();
    }

}
