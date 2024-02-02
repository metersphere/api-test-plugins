package io.metersphere.plugin.tcp;

import io.metersphere.plugin.sdk.util.PluginLogUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ObjectUtils;

import java.lang.reflect.Field;
import java.util.Map;

public class MsEnvironmentMapper {

    public static void parse(Map<String, Object> envConfig, MsTCPSampler element) {
        try {
            if (ObjectUtils.isNotEmpty(envConfig)) {
                MsEnvironment envElement = mapToModel(envConfig, MsEnvironment.class);
                BeanUtils.copyProperties(envElement, element);
            }
        } catch (Exception e) {
            PluginLogUtils.error("Failed to parse", e);
        }
    }

    public static <T> T mapToModel(Map<String, Object> map, Class<T> modelClass) {
        try {
            T model = modelClass.newInstance();

            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String fieldName = entry.getKey();
                Object value = entry.getValue();

                Field field = getField(modelClass, fieldName);
                if (field != null) {
                    field.setAccessible(true);
                    field.set(model, value);
                }
            }

            return model;
        } catch (Exception e) {
            PluginLogUtils.error("Failed to mapToModel", e);
            return null;
        }
    }

    private static Field getField(Class<?> clazz, String fieldName) {
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            PluginLogUtils.error("Failed to getField", e);
            return null;
        }
    }
}