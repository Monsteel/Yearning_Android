package appjam.hackathon.project.isaac.momentstory.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetRetrofit {
    private static NetRetrofit ourInstance = new NetRetrofit();
    public static NetRetrofit getInstance() {
        return ourInstance;
    }

    private NetRetrofit() {

    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("ServerIP")
            .addConverterFactory(GsonConverterFactory.create()) // 파싱등록
            .build();

//    LoginService login = retrofit.create(LoginService.class);
//    public LoginService getLogin() {
//        return login;
//    }
}

