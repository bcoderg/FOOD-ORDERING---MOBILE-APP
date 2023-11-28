package com.example.sip.adapters;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sip.R;
import com.example.sip.models.HomeHorModel;
import com.example.sip.models.HomeVerModel;

import java.util.ArrayList;
import java.util.List;

public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.Viewholder> {

   UpdateVerticalRec updateVerticalRec;
   Activity activity;
   ArrayList<HomeHorModel> list;

   boolean check=true;
   boolean select=true;
   int row_index=-1;

    public HomeHorAdapter(UpdateVerticalRec updateVerticalRec,Activity activity,ArrayList<HomeHorModel>list) {
        this.updateVerticalRec=updateVerticalRec;
        this.activity = activity;
        this.list=list;
    }



    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Viewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());

        if (check) {
            ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
            homeVerModels.add(new HomeVerModel(R.drawable.idly, "Idly", "8:00-10:30", "30/-"));
            homeVerModels.add(new HomeVerModel(R.drawable.vada, "Vada", "8:00-10:30", "30/-"));
            homeVerModels.add(new HomeVerModel(R.drawable.puri, "Puri", "8:00-10:30", "40/-"));
            homeVerModels.add(new HomeVerModel(R.drawable.dosa, "Dosa", "8:00-10:30", "35/-"));

            updateVerticalRec.callBack(position, homeVerModels);
            check = false;
        }
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    row_index=position;
                    notifyDataSetChanged();

                    if(position==0)
                    {

                        ArrayList<HomeVerModel> homeVerModels=new ArrayList<>();

                        homeVerModels.add(new HomeVerModel(R.drawable.idly,"Idly","8:00-10:30","30/-"));
                        homeVerModels.add(new HomeVerModel(R.drawable.vada,"Vada","8:00-10:30","30/-"));
                        homeVerModels.add(new HomeVerModel(R.drawable.puri,"Puri","8:00-10:30","40/-"));
                        homeVerModels.add(new HomeVerModel(R.drawable.dosa,"Dosa","8:00-10:30","35/-"));

                        updateVerticalRec.callBack(position,homeVerModels);

                    }
                    else if(position==1)
                    {

                        ArrayList<HomeVerModel> homeVerModels=new ArrayList<>();

                        homeVerModels.add(new HomeVerModel(R.drawable.biryani,"Chicken Biryani","12:00-2:00","120/-"));
                        homeVerModels.add(new HomeVerModel(R.drawable.pulav,"Veg Fried Rice","12:00-2:00","50/-"));
                        homeVerModels.add(new HomeVerModel(R.drawable.eggr,"Egg Fried Rice","12:00-2:00","60/-"));
                        homeVerModels.add(new HomeVerModel(R.drawable.chapatinv,"Chappati Chicken Curry","12:00-2:00","80/-"));

                        updateVerticalRec.callBack(position,homeVerModels);

                    }
                    else if(position==2)
                    {

                        ArrayList<HomeVerModel> homeVerModels=new ArrayList<>();

                        homeVerModels.add(new HomeVerModel(R.drawable.samosa,"Samosa","12:00-2:00","20/-"));
                        homeVerModels.add(new HomeVerModel(R.drawable.fries,"French Fries","12:00-2:00","60/-"));
                        homeVerModels.add(new HomeVerModel(R.drawable.puff,"Chicken Puff","12:00-2:00","35/-"));


                        updateVerticalRec.callBack(position,homeVerModels);

                    }
                    else if(position==3)
                    {

                        ArrayList<HomeVerModel> homeVerModels=new ArrayList<>();

                        homeVerModels.add(new HomeVerModel(R.drawable.manchuria,"Veg Manchurian","3:00-5:00","50/-"));
                        homeVerModels.add(new HomeVerModel(R.drawable.cnoodles,"Chicken Noodles","3:00-5:00","70/-"));
                        homeVerModels.add(new HomeVerModel(R.drawable.segg,"Shezwan Egg","3:00-5:00","70/-"));

                        updateVerticalRec.callBack(position,homeVerModels);

                    }
                    else if(position==4)
                    {

                        ArrayList<HomeVerModel> homeVerModels=new ArrayList<>();


                        homeVerModels.add(new HomeVerModel(R.drawable.lime,"Lime Spice","11:00-5:00","50/-"));
                        homeVerModels.add(new HomeVerModel(R.drawable.green,"Green Mint","11:00-5:00","60/-"));
                        homeVerModels.add(new HomeVerModel(R.drawable.virgin,"Virgin Mojito","11:00-5:00","60/-"));

                        updateVerticalRec.callBack(position,homeVerModels);

                    }

                }
            });
            if (select) {
                if(position==0)
                {
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);
                    select=false;
                }
            }
            else {
                if(row_index==position)
                {
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);
                }
                else
                {
                    holder.cardView.setBackgroundResource(R.drawable.default_bg);
                }

            }
        }




    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView name;
        CardView cardView;


        public Viewholder(@NonNull View itemView) {
            super(itemView);

            imageView= itemView.findViewById(R.id.hor_img);
            name=itemView.findViewById(R.id.hor_text);
            cardView=itemView.findViewById(R.id.cardView);
        }
    }

}
