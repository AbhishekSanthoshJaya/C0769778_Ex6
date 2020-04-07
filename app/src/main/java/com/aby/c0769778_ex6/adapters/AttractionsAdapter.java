package com.aby.c0769778_ex6.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aby.c0769778_ex6.R;
import com.aby.c0769778_ex6.model.CanadaAttractions;

import java.util.ArrayList;

public class AttractionsAdapter extends RecyclerView.Adapter<AttractionsAdapter.AttractionsViewHolder> {

    private ArrayList<CanadaAttractions> attractionArrayList;

    public AttractionsAdapter(ArrayList<CanadaAttractions> attractionArrayList)
    {
        this.attractionArrayList = attractionArrayList;
    }

    @NonNull
    @Override
    public AttractionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_attractions
                        , parent
                        , false);
        AttractionsViewHolder mAttractionsViewHolder = new AttractionsViewHolder(mView);
        return mAttractionsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final AttractionsViewHolder holder, final int position) {
        CanadaAttractions mCanadaAttractions = this.attractionArrayList.get(position);
        holder.txtAttractions.setText(mCanadaAttractions.getName());
        holder.imgAttractions.setImageResource(mCanadaAttractions.getAttractionImg());

        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                CanadaAttractions atr = attractionArrayList.get(position);
                Toast.makeText(holder.itemView.getContext(), "C : " + atr.getDescription(), Toast.LENGTH_SHORT).show();
                Log.d("CLICK", "hello");

                //Intent mIntent = new Intent(holder.itemView.getContext(), MainActivity.class);
                //Add Parameter - Parcalble or serializable
                //holder.itemView.getContext().startActivity(mIntent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return this.attractionArrayList.size();
    }

    public class AttractionsViewHolder extends RecyclerView.ViewHolder {
        TextView txtAttractions;
        ImageView imgAttractions;

        public AttractionsViewHolder(@NonNull View itemView)
        {
            super(itemView);
            txtAttractions = itemView.findViewById(R.id.txtAttraction);
            imgAttractions = itemView.findViewById(R.id.imgAttraction);
        }
    }
}
