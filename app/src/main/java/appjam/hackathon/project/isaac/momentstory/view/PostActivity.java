package appjam.hackathon.project.isaac.momentstory.view;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
        import androidx.databinding.DataBindingUtil;
        import androidx.lifecycle.ViewModel;
        import androidx.lifecycle.ViewModelProviders;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.File;
import java.util.ArrayList;

import appjam.hackathon.project.isaac.momentstory.R;
        import appjam.hackathon.project.isaac.momentstory.databinding.ActivityPostBinding;
        import appjam.hackathon.project.isaac.momentstory.viewmodel.PostViewModel;

public class PostActivity extends AppCompatActivity {

    ActivityPostBinding binding;
    PostViewModel postViewmodel;

    // startActivityForResult Answer
    private static final int PICK_FROM_ALBUM = 1;
    private File tempFile;

    // View
    ArrayList<String> imageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_post);
        postViewmodel = ViewModelProviders.of(this).get(PostViewModel.class);

        binding.setLifecycleOwner(this);
        binding.setViewModel(postViewmodel);
    }

    // 권한 체크 매서드
    public void tedPermission(View view){
        PermissionListener permissionListener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                goToAlbum();
            }
            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
            }
        };

        TedPermission.with(this)
                .setPermissionListener(permissionListener)
                .setRationaleMessage(R.string.rationale)
                .setDeniedMessage(R.string.denied)
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
                .check();
    }

    // 갤러리 접근 호출
    public void goToAlbum(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
        startActivityForResult(intent, PICK_FROM_ALBUM);
    }

    // 갤러리 접근 실행
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_FROM_ALBUM){

                Uri photoUri;
                int column_index;
                Cursor cursor = null;

                try {
                    // 갤러리에서 선택된 이미지의 Uri 값을 저장한다.
                    photoUri = data.getData();
                } catch (NullPointerException e) {
                    photoUri = null;
                }

                Log.e("TAG", "PICK_FROM_ALBUM photoUri : " + photoUri);

                // ArrayList 배열에 이미지 주소의 값을 저장한다.
                imageList.add(String.valueOf(photoUri));

                try {
                    String[] proj = {MediaStore.Images.Media.DATA};

                    // assert 예약어는 boolean 예약어와 같다.
                    assert photoUri != null;
                    cursor = PostActivity.this.getContentResolver().query(photoUri, proj, null, null, null);

                    // assert 예약어는 boolean 예약어와 같다.
                    assert cursor != null;
                    column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

                    cursor.moveToFirst();
                    tempFile = new File(cursor.getString(column_index));
                } catch (NullPointerException e) {

                } finally {
                    if(cursor != null){
                        cursor.close();
                    }
                }
                try {
                    setImage();
                } catch (NullPointerException e) {

                }
        }
    }

    // 이미지 설정
    public void setImage(){
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap originalBm = BitmapFactory.decodeFile(tempFile.getAbsolutePath(), options);

        binding.imageView.setImageBitmap(originalBm);
        Toast.makeText(this, imageList.get(0), Toast.LENGTH_SHORT).show();
    }
}
