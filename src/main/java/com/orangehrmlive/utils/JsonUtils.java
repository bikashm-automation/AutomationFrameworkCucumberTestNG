package com.orangehrmlive.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orangehrmlive.constants.FrameworkConstants;
import com.orangehrmlive.helpers.SystemHelpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * To construct the map by the reading the config values from JSON. Not used in this framework but can be leveraged
 * instead of property file based on the requirements
 */
public class JsonUtils {

    private static Map<String, String> CONFIGMAP;

    //Được sử dụng để khởi tạo thành viên dữ liệu static. (CONFIGMAP)
    //Nó được thực thi trước phương thức main tại lúc tải lớp.
    static {
        try {
            CONFIGMAP = new ObjectMapper().readValue(new File(SystemHelpers.getCurrentDir() + FrameworkConstants.JSON_DATA_FILE_PATH),
                    new TypeReference<HashMap<String, String>>() {
                    });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private JsonUtils() {
        super();
    }

    public static String get(String key) {
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.toLowerCase()))) {
            try {
                throw new Exception("Key name " + key + " is not found. Please check config.json");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return CONFIGMAP.get(key.toLowerCase());
    }

}
