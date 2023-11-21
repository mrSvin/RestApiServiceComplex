package SpringServiseComlexApplication.service;

import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;

@Service
public class ServiceBitrix {

    @Value("${token}")
    private String token;

    private String info = "Произведено сервисное обслуживание оборудования ";
    private String chatId = "chat193256";   //chat193256 - тестовый чат, chat214336 -рабочий /getDialogId - получить id чата


    public void messageBitrix(String complexName, String worksInfo, String username) throws IOException {
        System.out.println(complexName);
        String link_page = "LINK: \"http://iot.sespel.com"  + "\"";
        System.out.println("token " + token);
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("DIALOG_ID", chatId)
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

    public void messageBitrixElapsedTime (String complexName, Timestamp time) throws IOException {
        System.out.println(complexName);
        String link_page = "LINK: \"http://iot.sespel.com" + "\"";
        System.out.println("token " + token);
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("DIALOG_ID", chatId)
                .addFormDataPart("ATTACH", "[ {LINK: { DESC: \"" + "Истек срок проведения сервисного обслуживания " + time + " ,необходимо провести обслуживание оборудования " + complexName + "\", NAME: \"" + complexName + " \", " + link_page + "}} ]")
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
