package appjam.hackathon.project.isaac.momentstory.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import appjam.hackathon.project.isaac.momentstory.R;
import appjam.hackathon.project.isaac.momentstory.databinding.ActivityMainBinding;
import appjam.hackathon.project.isaac.momentstory.view.fragment.fragment1;
import appjam.hackathon.project.isaac.momentstory.view.fragment.fragment2;
import appjam.hackathon.project.isaac.momentstory.view.fragment.fragment3;
import appjam.hackathon.project.isaac.momentstory.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;
    ActivityMainBinding binding;

    private FragmentManager fragmentManager = getSupportFragmentManager();
    // 4개의 메뉴에 들어갈 Fragment들

    private fragment1 menu1Fragment = new fragment1();
    private fragment2 menu2Fragment = new fragment2();
    private fragment3 menu3Fragment = new fragment3();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setViewModel(mainViewModel);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView_main_menu);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_one:
                        return true;
                    case R.id.action_two:
                        return true;
                    case R.id.action_three:
                        return true;
                }
                return false;
            }
        });
    }
}
