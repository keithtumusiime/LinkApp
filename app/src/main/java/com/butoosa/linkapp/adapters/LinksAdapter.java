package com.butoosa.linkapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.butoosa.linkapp.Details;
import com.butoosa.linkapp.R;
import com.butoosa.linkapp.models.Links;

import java.util.List;

public class LinksAdapter extends RecyclerView.Adapter<LinksAdapter.myViewHolder>{
    private Context mContext;
    private List<Links> mData;

    public LinksAdapter(Context context, List<Links> mData) {
        this.mContext = context;
        this.mData = mData;
    }


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {

        View view ;


        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.link,viewGroup,false) ;
        final myViewHolder viewHolder = new myViewHolder(view) ;
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext,"Item Clicked", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(mContext, Details.class);
                i.putExtra("id",mData.get(viewHolder.getAdapterPosition()).getId());
                i.putExtra("title",mData.get(viewHolder.getAdapterPosition()).getTitle());
                i.putExtra("link",mData.get(viewHolder.getAdapterPosition()).getLink());
                i.putExtra("description",mData.get(viewHolder.getAdapterPosition()).getDescription());

                mContext.startActivity(i);

            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder myViewHolder, int i) {
       myViewHolder.title.setText(mData.get(i).getTitle());
        /*
        //load image from the internet and set it.
        Glide.with(mContext).load(mData.get(i).getImg_url()).apply(option).into(myViewHolder.img_thumbnail);*/

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title;
        LinearLayout view_container;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            view_container = itemView.findViewById(R.id.link_layout);
            title = itemView.findViewById(R.id.link);
        }
        @Override
        public void onClick(View view) {

        }

    }
}
