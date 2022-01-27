package com.example.easycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class medicine extends AppCompatActivity {

    LinearLayout linearLayoutShop, linearLayoutProduct;
    ImageView imageItemShop;
    TextView tvItemNameShop;

    int[]imagesShop = {R.drawable.med1,R.drawable.med2, R.drawable.med3,R.drawable.med5,R.drawable.med4};
    String[] namesItemShop = {"Medicines", "Lab Tests", "Health", "Omega 3", "Vitamins"};

    int[] imagesProduct = {R.drawable.med1, R.drawable.med2, R.drawable.med3, R.drawable.med4, R.drawable.med5, R.drawable.antibiotics};
    String[] namesItemsProduct = {"Multi Vitamis", "Thayrosafe", "Omega 3", "Sore Capsuls"};
    String[] pillsItemsProduct = {"90 pills", "180 pills", "132 pills", "60 pills"};
    String[] finalPriceProduct = {"Tk. 225", "Tk. 355", "Tk. 180", "Tk. 165"};
    String[] priceProduct = {"Tk. 250", "Tk. 385", "Tk. 200", "Tk. 165"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);
        linearLayoutShop = findViewById(R.id.linear_layout_shop);
        linearLayoutProduct = findViewById(R.id.linear_layout_products);

        loadShop();
    }

    public void loadProduct(){
        LayoutInflater inflater = LayoutInflater.from(this);
        int i;
        for(i=0;i<imagesProduct.length;i++) {
            View view = inflater.inflate(R.layout.item_product,linearLayoutProduct, false);
            ImageView imageProduct = view.findViewById(R.id.image_product);
            TextView tvName = view.findViewById(R.id.tv_name_product);
            TextView tvPills = view.findViewById(R.id.tv_pills_product);
            TextView tvFinalPrice = view.findViewById(R.id.tv_final_price_product);
            TextView tvPrice = view.findViewById(R.id.tv_price_product);
            imageProduct.setImageResource(imagesProduct[i]);
            tvName.setText(namesItemsProduct[i]);
            tvPills.setText(pillsItemsProduct[i]);
            tvFinalPrice.setText(finalPriceProduct[i]);
            tvPrice.setText(priceProduct[i]);

            linearLayoutProduct.addView(view);
        }
    }
    public void loadShop(){
        LayoutInflater inflater = LayoutInflater.from(this);
        int i;
        for(i=0;i<imagesShop.length;i++){
            View view = inflater.inflate(R.layout.item_shop,linearLayoutShop, false);
            imageItemShop = view.findViewById(R.id.image_item_shop);
            tvItemNameShop = view.findViewById(R.id.item_name_shop);
            imageItemShop.setImageResource(imagesShop[i]);
            tvItemNameShop.setText(namesItemShop[i]);

            final int aux = i;
            imageItemShop.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    String itemSeleccionado = namesItemShop[aux];
                    Toast.makeText(getApplicationContext(), "Item "+itemSeleccionado,Toast.LENGTH_SHORT).show();
                    Intent shop = new Intent(getApplicationContext(),Shop.class);
                    startActivity(shop);
                }
            });

            linearLayoutShop.addView(view);
        }

    }
}