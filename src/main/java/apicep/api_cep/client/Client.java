package apicep.api_cep.client;

import apicep.api_cep.model.Endereco;
import com.google.gson.Gson;
import org.apache.http.client.fluent.Request;
import org.springframework.stereotype.Component;

@Component
public class Client {

    public Endereco buscarCep(String cep) throws Exception {
        String url = "https://viacep.com.br/ws/" + cep + "/json";

        String jsonResponse = Request.Get(url)
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnContent()
                .asString();

        Gson gson = new Gson();
        return gson.fromJson(jsonResponse, Endereco.class);
    }
}
