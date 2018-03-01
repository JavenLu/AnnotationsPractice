package javen.example.com.annotationspractice;

import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @NonNull
    private String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        string = null;  //这里会被as提示，这个变量已经被设定为非空
        getCurColor(R.id.textView);  //这个地方会被编译器用红色下划线标注，提示 Expected resource of type color
        getCurColor(R.color.colorAccent);  //这个方法正确
    }

    void getCurColor(@ColorRes int color) {
        Toast.makeText(this, "Color: " + getString(color), Toast.LENGTH_LONG).show();
    }
}
