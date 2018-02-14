package example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class HelloWorldLambda implements RequestStreamHandler {

    private static final String IS_BASE_64_ENCODED = "isBase64Encoded";
    private static final String STATUS_CODE = "statusCode";
    private static final String HEADERS = "headers";
    private static final String BODY = "body";

    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {

        JSONObject jsonResponse = new JSONObject();

        JSONObject jsonResponseHeader = new JSONObject();
        jsonResponseHeader.put("myheader", "myvalue");

        jsonResponse.put(IS_BASE_64_ENCODED, false);
        jsonResponse.put(STATUS_CODE, 200);
        jsonResponse.put(HEADERS, jsonResponseHeader);
        jsonResponse.put(BODY, "Hello Pablo!!");

        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        writer.write(jsonResponse.toString());
        writer.close();
    }
}