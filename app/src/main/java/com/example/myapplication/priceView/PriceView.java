package com.example.myapplication.priceView;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.myapplication.R;

import java.text.DecimalFormat;


public class PriceView extends LinearLayout {

    Context context;
    boolean isStrike;
    public int price;
    public float size;
    TextView tvPrice;
    TextView rupeeBtm;
    Integer text_color;
    TextView rupeeCenter;
    Boolean isBold;
    View viewStrike;
    boolean btmTypeIconPrice;
    boolean empty;

    public PriceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setOrientation(LinearLayout.VERTICAL);
        LayoutInflater.from(context).inflate(R.layout.priceview, this, true);
        tvPrice = (TextView) findViewById(R.id.tvPrice);
        rupeeCenter = findViewById(R.id.rupeeCenter);
        rupeeBtm = findViewById(R.id.rupeeBtm);


        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.PriceView, 0, 0);
        try {
            price = attributes.getInt(R.styleable.PriceView_price, 0);
        } catch (Exception e) {

        }

        try {
            isStrike = attributes.getBoolean(R.styleable.PriceView_strike, false);

            viewStrike = (View) findViewById(R.id.viewStrike);
            tvPrice.setText(priceFormat(price));
            if (isStrike) {
                viewStrike.setVisibility(View.VISIBLE);
                rupeeCenter.setAlpha(0.5f);
                rupeeBtm.setAlpha(0.5f);
                tvPrice.setAlpha(0.5f);
            } else {
                viewStrike.setVisibility(View.GONE);
            }
        } catch (
                Exception e) {

        }


        try {
            empty = attributes.getBoolean(R.styleable.PriceView_empty, false);
            if (empty) {
                tvPrice.setVisibility(View.INVISIBLE);
                rupeeCenter.setVisibility(View.INVISIBLE);
                rupeeBtm.setVisibility(View.INVISIBLE);
            } else {
                tvPrice.setVisibility(View.VISIBLE);
                rupeeCenter.setVisibility(View.VISIBLE);
                rupeeBtm.setVisibility(View.VISIBLE);
            }
        } catch (Exception e) {

        }

        try {
            btmTypeIconPrice = attributes.getBoolean(R.styleable.PriceView_priceIconTypeBtm, false);
            if (btmTypeIconPrice) {
                if (empty) {
                } else {
                    rupeeBtm.setVisibility(View.VISIBLE);
                    rupeeCenter.setVisibility(View.GONE);
                }
            } else {
                if (empty) {
                } else {
                    rupeeBtm.setVisibility(View.GONE);
                    rupeeCenter.setVisibility(View.VISIBLE);
                }
            }
        } catch (Exception e) {

        }


        try {
            text_color = attributes.getColor(R.styleable.PriceView_text_color, Color.BLACK);
            rupeeCenter.setTextColor(text_color);
            rupeeBtm.setTextColor(text_color);
            tvPrice.setTextColor(text_color);
        } catch (Exception exception) {

        }


        try {
            isBold = attributes.getBoolean(R.styleable.PriceView_boldItem, false);
            if (isBold) {
                tvPrice.setTypeface(null, Typeface.BOLD);
            }
        } catch (Exception exception) {

        }

        try {
            size = attributes.getDimension(R.styleable.PriceView_size, context.getResources().getDimension(R.dimen._14ssp));
            size = size - context.getResources().getDimension(R.dimen._1ssp);
            rupeeCenter.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
            tvPrice.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
        } catch (
                Exception e) {

        }

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        try {
            this.price = price;
            tvPrice.setText(priceFormat(price));
        } catch (Exception e) {
        }
    }

    public boolean isStrike() {
        return isStrike;
    }

    public void setStrike(boolean strike) {
        isStrike = strike;
        if (isStrike) {
            viewStrike.setVisibility(View.VISIBLE);
            rupeeCenter.setAlpha(0.5f);
            tvPrice.setAlpha(0.5f);
        } else {
            viewStrike.setVisibility(View.GONE);
        }
    }

    public String priceFormat(Integer price) {
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        return formatter.format(price);
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
        if (this.empty) {
            tvPrice.setVisibility(View.INVISIBLE);
            rupeeCenter.setVisibility(View.INVISIBLE);
        } else {
            tvPrice.setVisibility(View.VISIBLE);
            rupeeCenter.setVisibility(View.VISIBLE);
        }
    }

    public Integer getText_color() {
        return text_color;
    }

    public void setText_color(Integer text_color) {
        rupeeCenter.setTextColor(text_color);
        rupeeBtm.setTextColor(text_color);
        tvPrice.setTextColor(text_color);
    }
}