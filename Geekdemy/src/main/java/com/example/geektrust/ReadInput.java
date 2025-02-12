package com.example.geektrust;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;


public class ReadInput
{
    boolean MEMBERSHIP = false;
    HashSet<String> SELECTED_DISCOUNT_COUPON = new HashSet<>();
    Coupon coupon= new Coupon();

    public void AddTotal(String s)
    {
        coupon.SubTotal(s);
    }

    public void readInput()
    {
        CheckMembership();
        ApplyCoupon();
    }

    public void DisplayOutput()
    {
        coupon.Display();
    }

    private void CheckMembership()
    {
        if(MEMBERSHIP)
        {
            coupon.ProMembership();
            if (coupon.COURSE_COUNT >= Constants.MAX_PROGRAMME)
            {
                coupon.Apply_B4G1_CouponWithMembership();
            }
        }
        else
        {
            coupon.ProMembership();
            if (coupon.COURSE_COUNT >= Constants.MAX_PROGRAMME)
            {
                coupon.Apply_B4G1_CouponWithoutMembership();
            }
        }
    }

    private void ApplyCoupon()
    {
        if(SELECTED_DISCOUNT_COUPON.contains("DEAL_G20)"))
        {
            coupon.Apply_DEAL_G20_Coupon();
        }
        else if(SELECTED_DISCOUNT_COUPON.contains("DEAL_G5)"))
        {
            coupon.Apply_DEAL_G5_Coupon();
        }
    }
}
