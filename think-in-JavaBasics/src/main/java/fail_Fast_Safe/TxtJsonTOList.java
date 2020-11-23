package fail_Fast_Safe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @Classname TxtJsonTOList
 * @Description TODO
 * @Date 2020/10/25 15:49
 * @Created by nihongyu
 */
public class TxtJsonTOList {
    public static void main(String[] args) throws IOException {
        System.out.println(getData());
    }

    public static List<DataDTO> getData() throws IOException {
        String txtFilePath = "C:\\Users\\17323\\Desktop\\oracle.txt";
        Path path = Paths.get(txtFilePath);
        byte[] jsonData = Files.readAllBytes(Paths.get(String.valueOf(path)));
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<DataDTO> orderInfoBatchList;
        orderInfoBatchList = mapper.readValue(jsonData,new TypeReference<List<DataDTO>>() { });
/**返回entity,上一行改为：
 * OrderInfoBatch orderInfoBatch = objectMapper.readValue(jsonData, OrderInfoBatch.class);
 */
        return orderInfoBatchList;
    }
}
