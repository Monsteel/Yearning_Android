package appjam.hackathon.project.isaac.momentstory.viewmodel;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import appjam.hackathon.project.isaac.momentstory.network.Data;
import appjam.hackathon.project.isaac.momentstory.network.NetRetrofit;
import appjam.hackathon.project.isaac.momentstory.network.Response;
import retrofit2.Call;
import retrofit2.Callback;

public class Fragment1ViewModel extends ViewModel {
    MutableLiveData<String> withTihm_H ;

    public void getWithTihm_H(){
//        Call<Response<Data>> res  = NetRetrofit.getInstance().;
//        res.enqueue(new Callback<Response<Data>>() {
//            @Override
//            public void onResponse(Call<Response<Data>> call, retrofit2.Response<Response<Data>> response) {
//                withTihm_H =
//            }
//            @Override
//            public void onFailure(Call<Response<Data>> call, Throwable t) {
//                Log.e("PartMain","ERROR");
//            }
//        });
    }
}
