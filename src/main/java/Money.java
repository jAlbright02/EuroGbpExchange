import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Money {

    public String exchangeRate() {
        HttpResponse<String> response
                = null;
        try {
            response = Unirest.get("http://data.fixer.io/api/latest")
            .queryString("access_key", "468a37c7599e0f704e8e93d34024e5cf")
            .queryString("symbols", "GBP")
            .asString();
            JSONObject jsonObject = new JSONObject(response.getBody());

            double exRate = jsonObject.getJSONObject("rates").getDouble("GBP");

            BigDecimal bdRate = new BigDecimal(exRate);

            DecimalFormat df = new DecimalFormat("#.######");

            String formattedRate = df.format(bdRate);

            return formattedRate;


        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }
}
