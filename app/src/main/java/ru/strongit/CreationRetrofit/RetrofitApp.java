package ru.strongit.CreationRetrofit;

import android.app.Application;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by user on 01.06.17.
 */

public class RetrofitApp extends Application {
    private static CreationApi creationApi;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://demo3526062.mockable.io/") //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();
        creationApi = retrofit.create(CreationApi.class); //Создаем объект, при помощи которого будем выполнять запросы
    }

    public static CreationApi getApi() {
        return creationApi;
    }
}
