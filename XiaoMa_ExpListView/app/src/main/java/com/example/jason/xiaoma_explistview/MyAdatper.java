package com.example.jason.xiaoma_explistview;

import java.util.ArrayList;
import java.util.HashMap;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class MyAdatper extends BaseExpandableListAdapter {

    private ArrayList<String> mGroupNames;
    private HashMap<String, ArrayList<String>> mChildNames;

    public MyAdatper(ArrayList<String> groupNames,
                     HashMap<String, ArrayList<String>> childNames) {
        mGroupNames=groupNames;
        mChildNames=childNames;
    }
//    设置组的数据
    @Override
    public int getGroupCount() {
        return mGroupNames.size();
    }
//    设置组的视图内容
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        //创建布局
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(android.R.layout.simple_list_item_1, null);
        TextView tv = (TextView) itemView.findViewById(android.R.id.text1);
        tv.setText(mGroupNames.get(groupPosition));
        return itemView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        //1.获取组名
        String groupName = mGroupNames.get(groupPosition);
        //2.根据组名 获取子列表
        ArrayList<String> childNames = mChildNames.get(groupName);
        return childNames.size();
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(android.R.layout.simple_list_item_1, null);
        //1.获取控件ui
        TextView tv = (TextView) itemView.findViewById(android.R.id.text1);
        //2.获取子视图
        //3.获取组
        String groupName = mGroupNames.get(groupPosition);
        //4.根据组名获取子列表
        ArrayList<String> childNames = mChildNames.get(groupName);
        //5.从子列表获取Item
        String text = childNames.get(childPosition);
        tv.setText(text);
        return itemView;
    }


    @Override
    public Object getGroup(int groupPosition) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return false;
    }

}
