package com.islam.malek.E3jaz;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;



/**
 * A simple {@link Fragment} subclass.
 */
public class EarthFragment extends ListFragment  {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                inflater.getContext(),
              android.R.layout.simple_list_item_activated_1,
                getResources().getStringArray(R.array.earth)
        );
        setListAdapter(arrayAdapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
@Override
    public void onListItemClick(ListView listView,View view,int position,long id){

        Intent intent=new Intent(getActivity(),earthActivity.class);
        intent.putExtra("position",position);
        getActivity().startActivity(intent);

}




}





