package com.example.mebdatabase10;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;


import com.example.mebdatabase10.databinding.FragmentFirstBinding;

import java.util.List;
import java.util.Objects;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    //private UpgradeRepository repository;

    //private final List<Upgrade> mAllUpgrades;

    Spinner topTextView, midTextView, bottomTextView;

    TextView costView;

    public void onStart()
    {
        super.onStart();
        ViewModel upgradeViewModel = new ViewModelProvider(getActivity()).get(UpgradeViewModel.class);
    }

    /*@Override
    public FirstFragment (Application application)
    {
        repository = new UpgradeRepository(application);
        mAllUpgrades = repository.getAllUpgrades();
    }*/

    /*@Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_first);
        mViewModel = ViewModelProviders.of(this).get(UpgradeViewModel.class);
    }*/

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        //binding = FragmentFirstBinding.inflate(inflater, container, false);
        //return binding.getRoot();

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        View fragmentFirstLayout = inflater.inflate(R.layout.fragment_first, container, false);

        //topTextView = fragmentFirstLayout.findViewById(R.id.top_path);
        //midTextView = fragmentFirstLayout.findViewById(R.id.middle_path);
        //bottomTextView = fragmentFirstLayout.findViewById(R.id.bottom_path);

        costView = fragmentFirstLayout.findViewById(R.id.costView);

        /*repository = new UpgradeRepository(getActivity().getApplication());

        UpgradeRoomDatabase.databaseWriteExecutor.execute(() ->
        {
            mAllUpgrades = repository.getAllUpgrades();
        });*/

        return fragmentFirstLayout;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewModel upgradeViewModel = new ViewModelProvider(getActivity()).get(UpgradeViewModel.class);

        /*binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });*/

        /*view.findViewById(R.id.enter_button).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                giveCost(view);
            }
        });*/

        Button enterButton = (Button) view.findViewById(R.id.enter_button);
        enterButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view, ViewModel upgradeViewModel) {
                giveCost(view);
            }
        });
    }

    public void giveCost(View view, ViewModel upgradeViewModel)
    {
        Upgrade upgrade = upgradeViewModel.getUpgrades().get(0);

        int cost = upgrade.getUpgradeCost();

        String finalCost = "$" + cost + " ";

        costView.setText(finalCost);
    }
    //UpgradeRepository repository = new UpgradeRepository(getActivity().getApplication());

    //Upgrade upgrade = repository.getUpgrade(0);

    //int cost = upgrade.getUpgradeCost();

    //String finalCost = "$" + cost + " ";

    //costView.setText(finalCost);

        /*UpgradeRepository repository = new UpgradeRepository(getActivity().getApplication());;
        int cost = 0;

        Spinner topSpin = view.findViewById(R.id.top_path);
        String topText = (String) topSpin.getSelectedItem();

        Spinner midSpin = view.findViewById(R.id.middle_path);
        String midText = (String) midSpin.getSelectedItem();

        Spinner lowSpin = view.findViewById(R.id.middle_path);
        String lowText = (String) lowSpin.getSelectedItem();

        if(Objects.equals(topText, "0") && Objects.equals(midText, "0") && Objects.equals(lowText, "0"))
        {
            cost = repository.getUpgradeCost(0);
        }
        else
        {
            if(Objects.equals(topText, "5") && Objects.equals(midText, "5") && Objects.equals(lowText, "5"))
            {
                cost = repository.getUpgradeCost(6);
            }
            else
            {
                int topUpgradeID = Integer.parseInt("1" + topText);
                int midUpgradeID = Integer.parseInt("1" + midText);
                int lowUpgradeID = Integer.parseInt("1" + lowText);

                cost += repository.getUpgradeCost(topUpgradeID);
                cost += repository.getUpgradeCost(midUpgradeID);
                cost += repository.getUpgradeCost(lowUpgradeID);
            }
        }

        //cost += repository.getUpgradeCost(upgradeID);

        Spinner midSpin = view.findViewById(R.id.middle_path);
        itemText = (String) midSpin.getSelectedItem();
        upgradeID = Integer.parseInt("2" + itemText);

        //cost += repository.getUpgradeCost(upgradeID);

        Spinner lowSpin = view.findViewById(R.id.bottom_path);
        itemText = (String) lowSpin.getSelectedItem();
        upgradeID = Integer.parseInt(itemText);

        //cost += repository.getUpgradeCost(upgradeID);

        String finalCost = cost + " ";

        Toast showResult = Toast.makeText(getActivity(),"The final cost is: $" + finalCost, Toast.LENGTH_LONG);

        showResult.show();*/

    //    UpgradeRoomDatabase.databaseWriteExecutor.execute(this::run);
    //}

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    /*private void run() {

        UpgradeRepository repository = new UpgradeRepository(getActivity().getApplication());

        Upgrade upgrade = repository.getUpgrade(0);

        int cost = upgrade.getUpgradeCost();

        String finalCost = "$" + cost + " ";

        costView.setText(finalCost);

        //Toast showResult = Toast.makeText(getActivity(), finalCost, Toast.LENGTH_LONG);
        //showResult.show();
    }*/
}