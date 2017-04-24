package com.wiggins.logger;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.orhanobut.logger.Logger;
import com.wiggins.logger.base.BaseActivity;
import com.wiggins.logger.utils.Constant;
import com.wiggins.logger.utils.UIUtils;
import com.wiggins.logger.widget.TitleView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Description Log框架Logger的使用详解
 * @Author 一花一世界
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {

    private TitleView titleView;
    private Button btn_String;
    private Button btn_Json;
    private Button btn_Xml;
    private Button btn_List;
    private Button btn_Map;
    private Button btn_Set;
    private Button btn_Exception;
    private Button btn_Format;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setListener();
    }

    private void initView() {
        titleView = (TitleView) findViewById(R.id.titleView);
        titleView.setAppTitle(UIUtils.getString(R.string.title));
        titleView.setLeftImageVisibility(View.GONE);
        btn_String = (Button) findViewById(R.id.btn_String);
        btn_Json = (Button) findViewById(R.id.btn_Json);
        btn_Xml = (Button) findViewById(R.id.btn_Xml);
        btn_List = (Button) findViewById(R.id.btn_List);
        btn_Map = (Button) findViewById(R.id.btn_Map);
        btn_Set = (Button) findViewById(R.id.btn_Set);
        btn_Exception = (Button) findViewById(R.id.btn_Exception);
        btn_Format = (Button) findViewById(R.id.btn_Format);
    }

    private void setListener() {
        btn_String.setOnClickListener(this);
        btn_Json.setOnClickListener(this);
        btn_Xml.setOnClickListener(this);
        btn_List.setOnClickListener(this);
        btn_Map.setOnClickListener(this);
        btn_Set.setOnClickListener(this);
        btn_Exception.setOnClickListener(this);
        btn_Format.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_String:
                Logger.d("hello one");
                Logger.e("hello two");
                Logger.w("hello three");
                Logger.v("hello four");
                Logger.wtf("hello fives");
                break;
            case R.id.btn_Json:
                Logger.json(Constant.JSON);
                break;
            case R.id.btn_Xml:
                Logger.xml(Constant.XML);
                break;
            case R.id.btn_List:
                // List 类型数据
                List<String> list = new ArrayList<>();
                list.add("hello");
                list.add("world");
                Logger.d(list);
                break;
            case R.id.btn_Map:
                // Map 类型数据
                Map<String, String> map = new HashMap<>();
                map.put("key_hello", "hello");
                map.put("key_world", "world");
                Logger.d(map);
                break;
            case R.id.btn_Set:
                // Set 类型数据
                Set<String> set = new HashSet<>();
                set.add(new String("hello"));
                set.add(new String("world"));
                Logger.d(set);
                break;
            case R.id.btn_Exception:
                // 异常Exception
                int[] a = new int[3];
                try {
                    a[4] = 3;
                } catch (Exception e) {
                    Logger.e(e, "message");
                }
                break;
            case R.id.btn_Format:
                // 字符串格式化
                Logger.d("hello %s %d", "world", 5);
                break;
        }
    }
}
