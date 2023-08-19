package com.example.expandable_listviewadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class ExpandableviewAdapter extends BaseExpandableListAdapter {

    private List<GroupObject> mGroupObjects;
    private Map<GroupObject,List<ItemObject>> objectListMap;


    public ExpandableviewAdapter(List<GroupObject> mGroupObjects, Map<GroupObject, List<ItemObject>> objectListMap) {
        this.mGroupObjects = mGroupObjects;
        this.objectListMap = objectListMap;
    }

    @Override
    public int getGroupCount() {
        if(mGroupObjects!=null){
            return mGroupObjects.size();
        }
        return 0;
    }

    @Override
    public int getChildrenCount(int i) {
        if(mGroupObjects!=null&&objectListMap!=null){
            return objectListMap.get(mGroupObjects.get(i)).size();
        }
        return 0;
    }

    @Override
    public Object getGroup(int i) {
        return mGroupObjects.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return objectListMap.get(mGroupObjects.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        GroupObject groupObject=mGroupObjects.get(i);
        return groupObject.getId();
    }

    @Override
    public long getChildId(int i, int i1) {
        ItemObject itemObject=objectListMap.get(mGroupObjects.get(i)).get(i1);
        return itemObject.getId();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        if(view==null){
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.group_object,viewGroup,false);
        }
        TextView txtgroup=view.findViewById(R.id.txtgroup);
        GroupObject groupObject=mGroupObjects.get(i);
        txtgroup.setText(groupObject.getName());

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        if(view==null){
            view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_object,viewGroup,false);

        }
        TextView txtitem=view.findViewById(R.id.txtitem);
        ItemObject itemObject=objectListMap.get(mGroupObjects.get(i)).get(i1);
        txtitem.setText(itemObject.getName());
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
