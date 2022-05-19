package com.es.elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * 说明：
 * Created by jiang on 2022/5/17 17:36
 */
public class ESTest_Doc_Delete {

    public static void main(String[] args) throws Exception {

        // 创建 ElasticSearch客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder( new HttpHost("127.0.0.1",9200,"http"))
        );

        // 数据删除
        DeleteRequest request = new DeleteRequest();
        request.index("user").id("12");
        DeleteResponse response = esClient.delete(request, RequestOptions.DEFAULT);

        System.out.println(response.status());


        // 关闭 ElasticSearch客户端
        esClient.close();
    }

}
