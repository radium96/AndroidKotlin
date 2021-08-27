package com.naca.loafavor.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.naca.loafavor.BR;
import com.naca.loafavor.data.NPC;
import com.naca.loafavor.databinding.NpcElementBinding;

import java.util.LinkedList;

public class NPCAdapter extends RecyclerView.Adapter<NPCAdapter.BindingViewHolder> {

    private LinkedList<NPC> NPCList;

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    public static OnItemClickListener mListener = null;

    public NPCAdapter(LinkedList<NPC> NPCList) {
        this.NPCList = NPCList;
    }

    @NonNull
    @Override
    public BindingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        NpcElementBinding binding = NpcElementBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new BindingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BindingViewHolder holder, int position) {
        holder.bind(NPCList.get(position));
    }

    @Override
    public int getItemCount() {
        return NPCList.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    public class BindingViewHolder extends RecyclerView.ViewHolder {
        NpcElementBinding binding;

        public BindingViewHolder(@NonNull NpcElementBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getBindingAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        if(NPCAdapter.mListener != null) {
                            NPCAdapter.mListener.onItemClick(v, position);
                        }
                    }
                }
            });
        }

        public void bind(NPC npc) {
            binding.setVariable(BR.name, npc.getName());
            binding.setVariable(BR.location, npc.getLocation());
        }
    }
}
