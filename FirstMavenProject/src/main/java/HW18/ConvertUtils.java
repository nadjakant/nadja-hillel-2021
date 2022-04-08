package HW18;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;


public class ConvertUtils {
    public static String jsonToYaml(String jsonString){
        try {
            JsonNode jsonNodeTree = new ObjectMapper().readTree(jsonString);

            return new YAMLMapper().writeValueAsString(jsonNodeTree);
        } catch (IOException e){
            return null;
        }
    }

    public static String yamlToJson(String yamlString){
        try {
            ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
            Object obj = yamlReader.readValue(yamlString, Object.class);
            ObjectMapper jsonWriter = new ObjectMapper();

            return jsonWriter.writeValueAsString(obj);


        } catch (IOException e){
            return null;
        }
    }
}
