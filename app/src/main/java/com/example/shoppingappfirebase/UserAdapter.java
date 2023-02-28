package com.example.shoppingappfirebase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    Context context;
    ArrayList<ItemModel> itemModelArrayList;

    public UserAdapter(Context context, ArrayList<ItemModel> itemModelArrayList) {
        this.context = context;
        this.itemModelArrayList = itemModelArrayList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        ItemModel user = itemModelArrayList.get(position);
        holder.username.setText(user.getUsername());
        holder.phoneNumber.setText(user.getPhoneNumber());
        holder.group.setText(user.getGroup());
    }

    @Override
    public int getItemCount() {
        return itemModelArrayList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        TextView username,phoneNumber,group;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.textView2);
            phoneNumber = itemView.findViewById(R.id.textView);
            group = itemView.findViewById(R.id.textView3);
        }
    }
}
