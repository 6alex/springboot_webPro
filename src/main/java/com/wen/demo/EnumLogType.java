package com.wen.demo;

import java.util.HashMap;
import java.util.Map;

/**   
 * @Description:  枚举 收支记录状态        
 * @author: Alex.wen  
 * @date:   2019年8月16日 下午4:07:24
 */
public enum EnumLogType {
                         quanbu("", "全部"), PASS("1", "通过"), NO_PASS("2", "不通过");

    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    EnumLogType(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static Map<String, String> toMap() {
        Map<String, String> enumDataMap = new HashMap<String, String>();
        for (EnumLogType attrValType : values()) {
            enumDataMap.put(attrValType.getKey(), attrValType.getValue());
        }
        return enumDataMap;
    }

}
