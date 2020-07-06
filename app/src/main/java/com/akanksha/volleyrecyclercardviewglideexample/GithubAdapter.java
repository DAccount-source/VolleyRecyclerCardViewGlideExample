package com.akanksha.volleyrecyclercardviewglideexample;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.GithubViewHolder>{

    private Context context;
    private User[] data;
    public GithubAdapter(Context context, User[] data){
        this.context=context;
        this.data=data;
    }
    @NonNull
    @Override
    public GithubViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        View view=inflater.inflate(R.layout.item_user_layout,viewGroup,false);
        return new GithubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GithubViewHolder githubViewHolder, int position) {
            final User user=data[position];
            githubViewHolder.txtUser.setText(user.getLogin());
            Glide.with(githubViewHolder.imgUser.getContext()).load(user.getAvatarUrl()).into(githubViewHolder.imgUser);
            githubViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, user.getLogin()+" was clicked!!", Toast.LENGTH_SHORT).show();
                    
                }
            });
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class GithubViewHolder extends RecyclerView.ViewHolder{
        ImageView imgUser;
        TextView txtUser;
        public GithubViewHolder(@NonNull View itemView) {
            super(itemView);
            imgUser= (ImageView) itemView.findViewById(R.id.imgUser);
            txtUser= (TextView) itemView.findViewById(R.id.txtUser);
        }
    }
}
