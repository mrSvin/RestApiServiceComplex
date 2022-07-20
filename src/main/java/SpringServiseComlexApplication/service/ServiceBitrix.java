package SpringServiseComlexApplication.service;

import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ServiceBitrix {

    private static String token = "njub74k0f4u8g661";

    private static String link_page = "LINK: \"http://192.168.3.152:8080/service/%D0%9D%D0%B0%D0%B2%D0%B8%D0%B3%D0%B0%D1%82%D0%BE%D1%80%201\"";
    private static String info = "Произведено сервисное обслуживание оборудования ";


    public void messageBitrix(String complexName, String worksInfo, String username) throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("DIALOG_ID", "chat214336")        //chat193256 - тестовый чат /getDialogId - получить id чата
                .addFormDataPart("ATTACH", "[ {LINK: { DESC: \"" + username + ". Проведенные работы: " + worksInfo + "\", NAME: \"" + info + complexName + " \", " + link_page + "}} ]")
                .build();
        Request request = new Request.Builder()
                .url("https://sespel-auto.bitrix24.ru/rest/1004/" + token + "/im.message.add.json")
                .method("POST", body)
                .addHeader("Cookie", "qmb=.; BITRIX_SM_SALE_UID=0")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }

}
