package com.naca.loafavor.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.naca.loafavor.R;
import com.naca.loafavor.data.NPC;
import com.naca.loafavor.data.NPCViewModel;
import com.naca.loafavor.databinding.FragmentTortoykBinding;
import com.naca.loafavor.data.NPCAdapter;

import java.util.ArrayList;

public class TortoykFragment extends Fragment {

    private NPCViewModel viewModel;
    private FragmentTortoykBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        int layoutId = R.layout.fragment_tortoyk;
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false);
        binding.setLifecycleOwner(this);

        View view = binding.getRoot();
        viewModel = new ViewModelProvider(this).get(NPCViewModel.class);
        viewModel.setList(14, 16);

        binding.tortoykRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.tortoykRecy.setHasFixedSize(true);

        NPCAdapter mAdapter = new NPCAdapter(viewModel.getNPCList().getValue());
        binding.tortoykRecy.setAdapter(mAdapter);

        viewModel.getNPCList().observe(getViewLifecycleOwner(), new Observer<ArrayList<NPC>>() {
            @Override
            public void onChanged(ArrayList<NPC> npcList) {
                mAdapter.setNPCList(npcList);
            }
        });


        return view;
    }
}
