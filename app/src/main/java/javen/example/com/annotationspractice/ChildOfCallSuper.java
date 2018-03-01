package javen.example.com.annotationspractice;

import android.graphics.Bitmap;

import java.io.IOException;

/**
 * Created by Javen on 01/03/2018.
 */

public class ChildOfCallSuper extends MainActivity {
    @Override
    public void setWallpaper(Bitmap bitmap) throws IOException {

    }

    @Override
    public void callSuper() { //如果重写的父类callSuper方法去掉 super.callSuper(); 方法名下会报红线提示需要super.callSuper()
        super.callSuper();
    }
}
