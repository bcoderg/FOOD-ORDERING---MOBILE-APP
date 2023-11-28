package com.example.sip.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sip.R;
import com.example.sip.adapters.HomeHorAdapter;
import com.example.sip.adapters.HomeVerAdapter;
import com.example.sip.adapters.UpdateVerticalRec;
import com.example.sip.databinding.FragmentHomeBinding;
import com.example.sip.models.HomeHorModel;
import com.example.sip.models.HomeVerModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements UpdateVerticalRec {

    RecyclerView homeHorizontalRec,homeVerticalRec;
    ArrayList<HomeHorModel> homeHorModelList;
    HomeHorAdapter homeHorAdapter;

    ArrayList<HomeVerModel> homeVerModelList;
    HomeVerAdapter homeVerAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_home,container,false);

        homeHorizontalRec=root.findViewById(R.id.home_hor_rec);
        homeVerticalRec=root.findViewById(R.id.home_ver_rec);

        homeHorModelList=new ArrayList<>();

        homeHorModelList.add(new HomeHorModel(R.drawable.bf,"Breakfast"));
        homeHorModelList.add(new HomeHorModel(R.drawable.lunch,"Lunch"));
        homeHorModelList.add(new HomeHorModel(R.drawable.snacks,"Snacks"));
        homeHorModelList.add(new HomeHorModel(R.drawable.chinese,"Chinese"));
        homeHorModelList.add(new HomeHorModel(R.drawable.drinks,"Drinks"));

        homeHorAdapter= new HomeHorAdapter(this ,getActivity(),homeHorModelList);
        homeHorizontalRec.setAdapter(homeHorAdapter);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        homeHorizontalRec.setHasFixedSize(true);
        homeHorizontalRec.setNestedScrollingEnabled(false);


////////vertical list

        homeVerModelList= new ArrayList<>();



        homeVerAdapter= new HomeVerAdapter(getActivity(),homeVerModelList);
        homeVerticalRec.setAdapter(homeVerAdapter);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        homeVerticalRec.setHasFixedSize(true);
        homeVerticalRec.setNestedScrollingEnabled(false);

        return root;
    }

    @Override
    public void callBack(int position, ArrayList<HomeVerModel> list) {

        homeVerAdapter=new HomeVerAdapter(getContext(),list);
        homeVerAdapter.notifyDataSetChanged();
        homeVerticalRec.setAdapter(homeVerAdapter);

    }
}