package com.islam.malek.E3jaz;


import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;




public class BalaghiFragment extends ListFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(
                inflater.getContext(),
                android.R.layout.simple_list_item_activated_1,
                getResources().getStringArray(R.array.balaghi)
        );
        setListAdapter(arrayAdapter);


        return super.onCreateView(inflater,container,savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent=new Intent(getActivity(),balaghiActivity.class);
        intent.putExtra("positionbalagh",position);
        startActivity(intent);}

}
