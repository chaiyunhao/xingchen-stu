package cn.xingchen;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jfinal.weixin.sdk.api.*;
import com.jfinal.weixin.sdk.utils.JsonUtils;
import net.minidev.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StuWxApplicationTests {

    @Test
    public void contextLoads() {

        String string = AccessTokenApi.getAccessTokenStr();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());

        String json = TemplateData.New()
                .setTouser("oows50qBqO8b4hJLIfhSLXy4sfDQ")
                .setUrl("www.uat.art2print.cn")
                .setTemplate_id("dpkyd0BjoDqsudK_hfXt_q-elNNKDkVBdHZ1j3ltKEg")
                .add("first","111","#000FF")
                .add("keyword1","222","#000FF")
                .add("keyword2","333","#000FF")
                .add("keyword3","111","#000FF")
                .add("keyword4","111","#000FF")
                .add("remark","111","#000FF")
                .build();

        System.out.println(json);

        ApiResult apiResult = TemplateMsgApi.send(json);

        System.out.println(apiResult.getJson());

    }

    @Test
    public void getUserInfo() {

        String string = AccessTokenApi.getAccessTokenStr();

        ApiResult apiResult = UserApi.getFollows();

        //创建json解析器
        JsonParser parse =new JsonParser();
        //创建jsonObject对象
        JsonObject jsonObj=(JsonObject) parse.parse(apiResult.getJson());

        String dataStr =jsonObj.get("data").toString();

        JsonObject dataObj=(JsonObject) parse.parse(dataStr);

        JsonArray jsonArray =dataObj.get("openid").getAsJsonArray();

        for(JsonElement jsonElement:jsonArray){
            ApiResult userResult  = UserApi.getUserInfo(jsonElement.getAsString());
//            System.out.println(userResult.getJson());
            //创建jsonObject对象
            JsonObject UserObj=(JsonObject) parse.parse(userResult.getJson());

            System.out.println(UserObj.get("openid").toString()+"   "+UserObj.get("nickname").toString());
        }

    }

}
