package SpringServiseComlexApplication.service;

import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ServiceBitrix {

    @Value("${token}")
    private String token;

    private static String info = "Произведено сервисное обслуживание оборудования ";


    public void messageBitrix(String complexName, String worksInfo, String username) throws IOException {
        System.out.println(complexName);
        String link_page = "LINK: \"http://192.168.3.152:8080/service/" + complexName + "\"";
        System.out.println("token " + token);
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("DIALOG_ID", "chat214336")        //chat193256 - тестовый чат, chat214336 -рабочий /getDialogId - получить id чата
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
