package com.es.elasticsearch;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
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
public class ESTest_Doc_Insert {

    public static void main(String[] args) throws Exception {

        // 创建 ElasticSearch客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder( new HttpHost("127.0.0.1",9200,"http"))
        );

        // 插入数据
        IndexRequest request = new IndexRequest();
        request.index("user").id("12");

        User user = new User();
        user.setName("张三");
        user.setAge(30);
        user.setSex("男");

        // 向 Es插入数据, 必须将数据转换为JSON格式
        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(user);
        request.source(userJson, XContentType.JSON);
        IndexResponse response = esClient.index(request, RequestOptions.DEFAULT);

        System.out.println(response.getResult());


        // 关闭 ElasticSearch客户端
        esClient.close();
    }

}
