package javen.example.com.annotationspractice;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.CheckResult;
import android.support.annotation.ColorRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.lang.reflect.Field;

import javen.example.com.processor.CustomAnnotation;
import javen.example.com.processor.generated.GeneratedClass;

import static javen.example.com.annotationspractice.StringDefInterface.STATUS_VALID;

@CustomAnnotation
public class MainActivity extends AppCompatActivity {

    @NonNull
    private String string;

    @Nullable
    private String nullable;

    private @StringDefInterface
    String stringDef;

    private @IdRes
    int resourceId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        string = null;  //这里会被as提示，这个变量已经被设定为非空
        nullable = null;   //这个变量由于添加了可以为空的注解 所以没有任何警告

        //getCurColor(R.id.textView);  //这个地方会被编译器用红色下划线标注，提示 Expected resource of type color
        // getCurColor(R.color.colorAccent);  //这个方法正确

        setStatus(STATUS_VALID);  //如果是其他字符串则编译器会报错

        setResourceId(123); //如果输入的是非id资源则会报错

        getSomething();

        showRuntimeAnnotation();

        showClassGeneratedWithAnnotation();
    }

    private void showClassGeneratedWithAnnotation() {
        String message = new GeneratedClass().getMessage();
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

//    void getCurColor(@ColorRes int color) {
//        Toast.makeText(this, "Color: " + getString(color), Toast.LENGTH_LONG).show();
//    }

//    @RequiresPermission(Manifest.permission.SET_WALLPAPER)
//    public abstract void setWallpaper(Bitmap bitmap) throws IOException;  //说明setWallpaper 有设置壁纸的权限

    /**
     * 该类子类重写该方法必须在方法内调用super.callSuper()
     * 与onCreate是一样的。
     */
    @CallSuper
    public void callSuper() {
    }

    /**
     * 设置枚举类型注解的方法
     *
     * @param stringDefInterface
     */
    public void setStatus(@StringDefInterface String stringDefInterface) {
        stringDef = stringDefInterface;
    }

    /**
     * 设置resourceId注解
     *
     * @param resourceId
     */
    public void setResourceId(@IdRes int resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * 用这个注解标记的方法，必须要求有返回值处理。
     *
     * @return
     */
    @CheckResult
    public String getSomething() {
        return "aa";
    }


    /**
     * @Size可以限制String或数组的长度
     */
    @Size
    public void setString(String string) {
        String aa = string;
    }

    /**
     * 通过反射解析注解拿到其中的值
     */
    public void showRuntimeAnnotation() {

        try {
            Class cls = Class.forName("javen.example.com.annotationspractice.RuntimeAnnotationClass");

            Field[] fields = cls.getDeclaredFields();

            for (Field field : fields) {
                RuntimeAnnotation runtimeAnnotation = field.getAnnotation(RuntimeAnnotation.class);

                if (runtimeAnnotation != null) {
                    String value = runtimeAnnotation.value();
                    System.out.println(value);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
