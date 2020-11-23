package fail_Fast_Safe;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname DeleteListDemo
 * @Description TODO
 * @Date 2020/10/18 13:52
 * @Created by nihongyu
 */

public class DeleteListDemo {
    public static void main(String[] args) {

        String jsonStr = "[{\"a\":123, \"b\":\"hello\", \"x\":[{\"inner\":\"Inner JSONObject\"}]}]";

        //        String txt = "[{\"name\": \"qwer\",\"age\": \"12\",\"area\": \"cq\"},{\"name\": \"df\",\"age\": \"13\",\"area\": \"sh\"},{\"name\": \"hh\",\"age\": \"14\",\"area\": \"bj\"}]";
        //三个相同的 json 串
//        String txt = "[{\"PARENTNODEID\":\"A0002\",\"DIMCODE\":\"IS_AL\",\"ACCOUNTTYPE\":\"1\",\"VALUETYPE\":\"11\",\"DICTYPE\":\"IS_ALL\",\"ATTRNAME\":\"是否订购腾讯视频流量包(月)\",\"ATTRTYPE\":\"outtable\",\"ACCOUNT\":\"202009\",\"DIM_CODE\":\"16\",\"TWONODEID\":\"B0002003\",\"ONENODENAME\":\"产品特征\",\"KINDCODE\":\"B0002003\",\"LINKPERSON\":\"李雪慧\",\"TWOCHILDRENNUM\":\"33\",\"ONECHILDRENNUM\":\"4\",\"LINKPHONE\":\"18601720658\",\"PROVID\":\"031\",\"DIMNAME\":\"IS_AL_DESC\",\"ATTRCODE\":\"D100000219\",\"SOURCESYSTEM\":\"采集整合\",\"BUSINESSCALIBER\":\"是否订购腾讯视频流量包\",\"SUPPORTTIME\":\"2019-01-01 00:00:00.0\",\"ONENODEID\":\"A0002\",\"TWONODENAME\":\"增值业务\",\"SHOW_LIMIT_SQL\":\"SELECT IS_AL AS CODE_ID, IS_AL_DESC AS CODE_DESC FROM BONCUSER.DIM_IS_ALL ORDER BY IS_AL\",\"DIMTYPE\":\"DIM_IS_ALL\"},{\"PARENTNODEID\":\"A0002\",\"DIMCODE\":\"IS_AL\",\"ACCOUNTTYPE\":\"1\",\"VALUETYPE\":\"11\",\"DICTYPE\":\"IS_ALL\",\"ATTRNAME\":\"是否开通语音国际长途功能(月)\",\"ATTRTYPE\":\"outtable\",\"ACCOUNT\":\"202009\",\"DIM_CODE\":\"16\",\"TWONODEID\":\"B0002003\",\"ONENODENAME\":\"产品特征\",\"KINDCODE\":\"B0002003\",\"LINKPERSON\":\"李雪慧\",\"TWOCHILDRENNUM\":\"33\",\"ONECHILDRENNUM\":\"4\",\"LINKPHONE\":\"18601720658\",\"PROVID\":\"031\",\"DIMNAME\":\"IS_AL_DESC\",\"ATTRCODE\":\"D100000215\",\"SOURCESYSTEM\":\"采集整合\",\"BUSINESSCALIBER\":\"是否开通语音国际长途功能\",\"SUPPORTTIME\":\"2019-01-01 00:00:00.0\",\"ONENODEID\":\"A0002\",\"TWONODENAME\":\"增值业务\",\"SHOW_LIMIT_SQL\":\"SELECT IS_AL AS CODE_ID, IS_AL_DESC AS CODE_DESC FROM BONCUSER.DIM_IS_ALL ORDER BY IS_AL\",\"DIMTYPE\":\"DIM_IS_ALL\"},{\"PARENTNODEID\":\"A0002\",\"DIMCODE\":\"IS_AL\",\"ACCOUNTTYPE\":\"1\",\"VALUETYPE\":\"11\",\"DICTYPE\":\"IS_ALL\",\"ATTRNAME\":\"是否开通数据国际漫游功能(月)\",\"ATTRTYPE\":\"outtable\",\"ACCOUNT\":\"202009\",\"DIM_CODE\":\"16\",\"TWONODEID\":\"B0002003\",\"ONENODENAME\":\"产品特征\",\"KINDCODE\":\"B0002003\",\"LINKPERSON\":\"李雪慧\",\"TWOCHILDRENNUM\":\"33\",\"ONECHILDRENNUM\":\"4\",\"LINKPHONE\":\"18601720658\",\"PROVID\":\"031\",\"DIMNAME\":\"IS_AL_DESC\",\"ATTRCODE\":\"D100000214\",\"SOURCESYSTEM\":\"采集整合\",\"BUSINESSCALIBER\":\"是否开通数据国际漫游功能\",\"SUPPORTTIME\":\"2019-01-01 00:00:00.0\",\"ONENODEID\":\"A0002\",\"TWONODENAME\":\"增值业务\",\"SHOW_LIMIT_SQL\":\"SELECT IS_AL AS CODE_ID, IS_AL_DESC AS CODE_DESC FROM BONCUSER.DIM_IS_ALL ORDER BY IS_AL\",\"DIMTYPE\":\"DIM_IS_ALL\"}]";
        //四个中，三个相同，一个不同
        String txt = "[{\"PARENTNODEID\":\"A0002\",\"DIMCODE\":\"IS_AL\",\"ACCOUNTTYPE\":\"1\",\"VALUETYPE\":\"11\",\"DICTYPE\":\"IS_ALL\",\"ATTRNAME\":\"是否订购腾讯视频流量包(月)\",\"ATTRTYPE\":\"outtable\",\"ACCOUNT\":\"202009\",\"DIM_CODE\":\"16\",\"TWONODEID\":\"B0002003\",\"ONENODENAME\":\"产品特征\",\"KINDCODE\":\"B0002003\",\"LINKPERSON\":\"李雪慧\",\"TWOCHILDRENNUM\":\"33\",\"ONECHILDRENNUM\":\"4\",\"LINKPHONE\":\"18601720658\",\"PROVID\":\"031\",\"DIMNAME\":\"IS_AL_DESC\",\"ATTRCODE\":\"D100000219\",\"SOURCESYSTEM\":\"采集整合\",\"BUSINESSCALIBER\":\"是否订购腾讯视频流量包\",\"SUPPORTTIME\":\"2019-01-01 00:00:00.0\",\"ONENODEID\":\"A0002\",\"TWONODENAME\":\"增值业务\",\"SHOW_LIMIT_SQL\":\"SELECT IS_AL AS CODE_ID, IS_AL_DESC AS CODE_DESC FROM BONCUSER.DIM_IS_ALL ORDER BY IS_AL\",\"DIMTYPE\":\"DIM_IS_ALL\"},{\"PARENTNODEID\":\"A0002\",\"DIMCODE\":\"IS_AL\",\"ACCOUNTTYPE\":\"1\",\"VALUETYPE\":\"11\",\"DICTYPE\":\"IS_ALL\",\"ATTRNAME\":\"是否开通语音国际长途功能(月)\",\"ATTRTYPE\":\"outtable\",\"ACCOUNT\":\"202009\",\"DIM_CODE\":\"16\",\"TWONODEID\":\"B0002003\",\"ONENODENAME\":\"产品特征\",\"KINDCODE\":\"B0002003\",\"LINKPERSON\":\"李雪慧\",\"TWOCHILDRENNUM\":\"33\",\"ONECHILDRENNUM\":\"4\",\"LINKPHONE\":\"18601720658\",\"PROVID\":\"031\",\"DIMNAME\":\"IS_AL_DESC\",\"ATTRCODE\":\"D100000215\",\"SOURCESYSTEM\":\"采集整合\",\"BUSINESSCALIBER\":\"是否开通语音国际长途功能\",\"SUPPORTTIME\":\"2019-01-01 00:00:00.0\",\"ONENODEID\":\"A0002\",\"TWONODENAME\":\"增值业务\",\"SHOW_LIMIT_SQL\":\"SELECT IS_AL AS CODE_ID, IS_AL_DESC AS CODE_DESC FROM BONCUSER.DIM_IS_ALL ORDER BY IS_AL\",\"DIMTYPE\":\"DIM_IS_ALL\"},{\"PARENTNODEID\":\"A0002\",\"DIMCODE\":\"IS_AL\",\"ACCOUNTTYPE\":\"1\",\"VALUETYPE\":\"11\",\"DICTYPE\":\"IS_ALL\",\"ATTRNAME\":\"是否开通数据国际漫游功能(月)\",\"ATTRTYPE\":\"outtable\",\"ACCOUNT\":\"202009\",\"DIM_CODE\":\"16\",\"TWONODEID\":\"B0002003\",\"ONENODENAME\":\"产品特征\",\"KINDCODE\":\"B0002003\",\"LINKPERSON\":\"李雪慧\",\"TWOCHILDRENNUM\":\"33\",\"ONECHILDRENNUM\":\"4\",\"LINKPHONE\":\"18601720658\",\"PROVID\":\"031\",\"DIMNAME\":\"IS_AL_DESC\",\"ATTRCODE\":\"D100000214\",\"SOURCESYSTEM\":\"采集整合\",\"BUSINESSCALIBER\":\"是否开通数据国际漫游功能\",\"SUPPORTTIME\":\"2019-01-01 00:00:00.0\",\"ONENODEID\":\"A0002\",\"TWONODENAME\":\"增值业务\",\"SHOW_LIMIT_SQL\":\"SELECT IS_AL AS CODE_ID, IS_AL_DESC AS CODE_DESC FROM BONCUSER.DIM_IS_ALL ORDER BY IS_AL\",\"DIMTYPE\":\"DIM_IS_ALL\"},{\"PARENTNODEID\": \"B0004\",\"DIMCODE\": \"IS_AL\",\"ACCOUNTTYPE\": \"1\",\"VALUETYPE\": \"11\",\"DICTYPE\": \"IS_ALL\",\"ATTRNAME\": \"是否有短信用户(月)\",\"ATTRTYPE\": \"outtable\",\"ACCOUNT\": \"202009\",\"DIM_CODE\": \"17\",\"TWONODEID\": \"B0004002\",\"ONENODENAME\": \"业务特征\",\"KINDCODE\": \"B0004002\",\"LINKPERSON\": \"李雪慧\",\"TWOCHILDRENNUM\": \"1\",\"ONECHILDRENNUM\": \"4\",\"LINKPHONE\": \"18601720658\",\"ATTRCODE\": \"D100000246\",\"SOURCESYSTEM\": \"采集整合\",\"BUSINESSCALIBER\": \"是否有短信用户\",\"SUPPORTTIME\": \"2019-01-01 00:00:00.0\",\"ONENODEID\": \"B0004\",\"TWONODENAME\": \"短信\",\"SHOW_LIMIT_SQL\": \"SELECT IS_AL AS CODE_ID, IS_AL_DESC AS CODE_DESC FROM BONCUSER.DIM_IS_ALL ORDER BY IS_AL\",\"DIMTYPE\": \"DIM_IS_ALL\"}]";
        JSONArray jsonArray = new JSONArray();
        jsonArray = JSONObject.parseArray(txt);


        JSONArray parentArray = new JSONArray();
        JSONArray childrenArray = new JSONArray();
        JSONObject parentObject = new JSONObject();
        JSONObject childrenObject = new JSONObject();
        JSONObject labelObject = new JSONObject();
        JSONArray labelArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();


        Map<String, JSONArray> xinyunMap = new HashMap();
        JSONArray xingyunArray = new JSONArray();
        JSONObject xingyunObject = new JSONObject();

        for (int i = 0; i < jsonArray.size(); i++) {

            jsonObject = jsonArray.getJSONObject(i);
            parentObject = new JSONObject();
            childrenArray = new JSONArray();
            childrenObject = new JSONObject();
            labelObject = new JSONObject();
            labelArray = new JSONArray();

            xingyunArray = new JSONArray();
            xingyunObject = new JSONObject();


            labelObject.put("linkPhone", jsonObject.getString("LINKPHONE"));
            labelObject.put("kindCode", jsonObject.getString("KINDCODE"));
            labelObject.put("businessCaliber", jsonObject.getString("BUSINESSCALIBER"));
            labelObject.put("provId", jsonObject.getString("PROVID"));
            labelObject.put("dim_code", jsonObject.getString("DIM_CODE"));

////获取行云返参
//            String dimCode = jsonObject.getString("DIM_CODE");
//            if (xinyunMap.get(dimCode) != null) {
//
//            } else {
//                String sql = "行云 SQL" + dimCode;
//                xingyunObject.put(dimCode, jsonObject.getString("ONENODENAME"));
//                xingyunArray.add(xingyunObject);
//                xinyunMap.put(dimCode, xingyunArray);
//            }
//            labelObject.put("dictList", xinyunMap.get(dimCode));
//
////            labelObject.put("dictList", xingyunArray);
//            labelArray.add(labelObject);


            childrenObject.put("nodeName", jsonObject.getString("TWONODENAME"));
            childrenObject.put("parentNodeId", jsonObject.getString("PARENTNODEID"));
            childrenObject.put("nodeId", jsonObject.getString("TWONODEID"));
            childrenObject.put("labelList", labelArray);
            childrenArray.add(childrenObject);


            parentObject.put("nodeName", jsonObject.getString("ONENODENAME"));
            parentObject.put("nodeId", jsonObject.getString("ONENODEID"));
            parentObject.put("children", childrenArray);
            parentArray.add(parentObject);
        }
        System.out.println(parentArray);

        String jj = JSON.toJSONString(parentArray, SerializerFeature.DisableCircularReferenceDetect);
        // parentArray 是符合返参格式的
        System.out.println(jj);

    }
}
