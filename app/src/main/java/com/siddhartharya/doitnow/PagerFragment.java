package com.siddhartharya.doitnow;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Siddharth Arya on 07-Nov-16.
 */
public class PagerFragment extends Fragment {
    public int position;

    public static PagerFragment newInstance(int position) {

        Bundle args = new Bundle();

        PagerFragment fragment = new PagerFragment();
        fragment.position = position;
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.from(getContext())
                .inflate(R.layout.fragment_description, container, false);
        TextView title = (TextView) view.findViewById(R.id.titleText);
        TextView description = (TextView) view.findViewById(R.id.titleText);
        Task task = DataSupplier.tasks.get(position);
        title.setText(task.title);
        description.setText(task.description);
        return view;
    }
}
