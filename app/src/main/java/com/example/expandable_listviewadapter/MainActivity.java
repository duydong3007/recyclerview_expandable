package com.example.expandable_listviewadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ExpandableListView expand;
    private List<GroupObject> mGroupObjects;
    private Map<GroupObject,List<ItemObject>> objectListMap;
    private ExpandableviewAdapter mAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expand=(ExpandableListView) findViewById(R.id.exlist);
        objectListMap=getlistMap();
        mGroupObjects=new ArrayList<>(objectListMap.keySet());

        mAdapter=new ExpandableviewAdapter(mGroupObjects,objectListMap);
        expand.setAdapter(mAdapter);
    }

    public Map<GroupObject,List<ItemObject>> getlistMap(){
        Map<GroupObject,List<ItemObject>> listMap=new HashMap<>();
        GroupObject object1 =new GroupObject(1,"group 1");
        GroupObject object2 =new GroupObject(2,"group 2");
        GroupObject object3 =new GroupObject(3,"group 3");

       List<ItemObject> list1=new ArrayList<>();
       list1.add(new ItemObject(1,"item1"));
        list1.add(new ItemObject(2,"item2"));
        list1.add(new ItemObject(3,"item3"));

        List<ItemObject> list2=new ArrayList<>();
        list2.add(new ItemObject(1,"item4"));
        list2.add(new ItemObject(2,"item5"));
        list2.add(new ItemObject(3,"item6"));

        List<ItemObject> list3=new ArrayList<>();
        list3.add(new ItemObject(1,"item7"));
        list3.add(new ItemObject(2,"item8"));
        list3.add(new ItemObject(3,"item9"));

        listMap.put(object1,list1);
        listMap.put(object2,list2);
        listMap.put(object3,list3);


        return listMap;
    }
}