package top.xinsin.utils;

import lombok.Data;
import top.xinsin.enums.HttpCodes;

/**
 * @author xinsin
 * @version 1.0
 * Created On 2022/5/14
 * @param <T> 返回值类型
 */
@Data
public class ResultData<T> {
    private int status;
    private String message;
    private T data;
    private long timestamp;

    public ResultData() {
        this.timestamp = System.currentTimeMillis();
    }
    public static<T> ResultData<T> success(T data){
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(HttpCodes.HTTP_CODES200.getCode());
        resultData.setMessage(HttpCodes.HTTP_CODES200.getMessage());
        resultData.setData(data);
        return resultData;
    }
    public static<T> ResultData<T> failed(HttpCodes httpCodes,T data){
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(httpCodes.getCode());
        resultData.setMessage(httpCodes.getMessage());
        resultData.setData(data);
        return resultData;
    }
}
