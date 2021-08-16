package com.example.pcolombia;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductFragment extends Fragment {

    private String name;
    private String tradeMark;
    private String price;
    private String state;
    private String visibility;
    private View rootView;
    private TextView nameTextView;
    private TextView tradeMarkTextView;
    private TextView priceTextView;
    private TextView stateTextView;
    private TextView visibilityTextView;

    public ProductFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ProductFragment newInstance(String name, String tradeMark, String price,
                                              String state, String visibility) {
        ProductFragment fragment = new ProductFragment();
        fragment.setName(name);
        fragment.setTradeMark(tradeMark);
        fragment.setPrice(price);
        fragment.setState(state);
        fragment.setVisibility(visibility);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_product,container,false);
        nameTextView = rootView.findViewById(R.id.nameTextView_productFragment);
        tradeMarkTextView = rootView.findViewById(R.id.tradeMarkTextView_productFragment);
        priceTextView = rootView.findViewById(R.id.priceTextView_productFragment);
        stateTextView = rootView.findViewById(R.id.stateTextView_productFragment);
        visibilityTextView = rootView.findViewById(R.id.visibilityTextView_productFragment);
        nameTextView.setText(name);
        tradeMarkTextView.setText(tradeMark);
        priceTextView.setText(price);
        stateTextView.setText(state);
        visibilityTextView.setText(visibility);
        return rootView;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTradeMark() {
        return tradeMark;
    }

    public void setTradeMark(String tradeMark) {
        this.tradeMark = tradeMark;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }
}