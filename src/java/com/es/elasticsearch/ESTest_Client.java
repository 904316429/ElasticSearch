package com.es.elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * 说明：
 * Created by jiang on 2022/5/17 17:36
 */
public class ESTest_Client {

    public static void main(String[] args) throws Exception {

        // 创建 ElasticSearch客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder( new HttpHost("127.0.0.1",9200,"http"))
        );


        // 关闭 ElasticSearch客户端
        esClient.close();
    }

}
