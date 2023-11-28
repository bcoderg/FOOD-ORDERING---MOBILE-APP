package com.example.sip.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sip.R;
import com.example.sip.models.HomeHorModel;
import com.example.sip.models.HomeVerModel;

import java.util.ArrayList;
import java.util.List;

public class HomeVerAdapter extends RecyclerView.Adapter<HomeVerAdapter.Viewholder> {
    Context context;
    ArrayList<HomeVerModel> list;

    public HomeVerAdapter(Context context,ArrayList<HomeVerModel>list) {
        this.context = context;
        this.list=list;
    }

    @NonNull
    @Override
    public HomeVerAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeVerAdapter.Viewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_vertical,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

       holder.imageView.setImageResource(list.get(position).getImage());
       holder.name.setText(list.get(position).getName());
       holder.price.setText(list.get(position).getPrice());


    }

    @Override
    public int getItemCount() {
        
        return list.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView name,timing,price;


        public Viewholder(@NonNull View itemView) {
            super(itemView);

            imageView= itemView.findViewById(R.id.ver_img);
            name=itemView.findViewById(R.id.name);
            timing=itemView.findViewById(R.id.timing);
            price=itemView.findViewById(R.id.price);
        }
    }


}
