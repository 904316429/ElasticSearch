package com.es.elasticsearch;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

/**
 * 说明：
 * Created by jiang on 2022/5/17 17:36
 */
public class ESTest_Doc_Update {

    public static void main(String[] args) throws Exception {

        // 创建 ElasticSearch客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder( new HttpHost("127.0.0.1",9200,"http"))
        );

        // 更新数据
        UpdateRequest request = new UpdateRequest();
        request.index("user").id("12");
        request.doc(XContentType.JSON, "sex", "女");
        UpdateResponse response = esClient.update(request, RequestOptions.DEFAULT);

        System.out.println(response.getResult());


        // 关闭 ElasticSearch客户端
        esClient.close();
    }

}
