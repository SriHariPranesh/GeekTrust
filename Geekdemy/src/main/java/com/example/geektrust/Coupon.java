package com.example.geektrust;

import com.example.geektrust.Constants;

import java.util.*;

public class Coupon
{
    double SUB_TOTAL= Constants.NULL;
    int COURSE_COUNT= Constants.NULL;
    int CERTIFICATE_COUNT= Constants.NULL;
    int DEGREE_COUNT= Constants.NULL;
    int DIPLOMA_COUNT= Constants.NULL;
    String COUPON_DISCOUNT_NAME = "NONE";
    double COUPON_DISCOUNT= Constants.NULL;
    double PRO_DISCOUNT= Constants.NULL;
    double PRO_FEE= Constants.NULL;
    double ENROLLMENT_FEE= Constants.NULL;
    double TOTAL= Constants.NULL;

    public void SubTotal(String s)
    {
        String[] input= s.split("\\s+");
        switch (input[Constants.ONE])
        {
            case Constants.INPUT_CERTIFICATE:
                CERTIFICATE_COUNT = Integer.parseInt(input[Constants.TWO]);
                SUB_TOTAL += CERTIFICATE_COUNT * Constants.CERTIFICATE_PRICE;
                COURSE_COUNT+= CERTIFICATE_COUNT;
                break;
            case Constants.INPUT_DEGREE:
                DEGREE_COUNT = Integer.parseInt(input[Constants.TWO]);
                SUB_TOTAL += DEGREE_COUNT * Constants.DEGREE_PRICE;
                COURSE_COUNT+= DEGREE_COUNT;
                break;
            case Constants.INPUT_DIPLOMA:
                DIPLOMA_COUNT = Integer.parseInt(input[Constants.TWO]);
                SUB_TOTAL += DIPLOMA_COUNT * Constants.DIPLOMA_PRICE;
                COURSE_COUNT+= DIPLOMA_COUNT;
                break;
        }
        TOTAL= SUB_TOTAL;
    }

    public void ProMembership()
    {
        PRO_FEE= Constants.PRO_MEMBERSHIP_FEE;
        double PRO_CERTIFICATE_DIS= Constants.PRO_CERTIFICATE_DISCOUNT * CERTIFICATE_COUNT * Constants.CERTIFICATE_PRICE;
        double PRO_DEGREE_DIS= Constants.PRO_DEGREE_DISCOUNT * DEGREE_COUNT * Constants.DEGREE_PRICE;
        double PRO_DIPLOMA_DIS= Constants.PRO_DIPLOMA_DISCOUNT * DIPLOMA_COUNT * Constants.DIPLOMA_PRICE;
        PRO_DISCOUNT= PRO_CERTIFICATE_DIS + PRO_DEGREE_DIS + PRO_DIPLOMA_DIS;
        TOTAL= TOTAL - PRO_DISCOUNT + PRO_FEE;
        SUB_TOTAL= TOTAL;
    }

    public void EnrollmentFee()
    {
        if(TOTAL < Constants.MIN_PROGRAMME_VALUE && TOTAL != Constants.NULL)
        {
            TOTAL+= Constants.ENROLLMENT_FEE;
            ENROLLMENT_FEE= Constants.ENROLLMENT_FEE;
        }
    }

    public void Display()
    {
        System.out.println("SUB_TOTAL " + String.format("%.2f", SUB_TOTAL));
        System.out.println("COUPON_DISCOUNT " + COUPON_DISCOUNT_NAME + " " + String.format("%.2f", COUPON_DISCOUNT));
        System.out.println("TOTAL_PRO_DISCOUNT " + String.format("%.2f", PRO_DISCOUNT));
        System.out.println("PRO_MEMBERSHIP_FEE " + String.format("%.2f", PRO_FEE));
        EnrollmentFee();
        System.out.println("ENROLLMENT_FEE " + String.format("%.2f", ENROLLMENT_FEE));
        System.out.println("TOTAL " + String.format("%.2f", TOTAL));
    }

    public void Apply_B4G1_CouponWithMembership()
    {
        COUPON_DISCOUNT_NAME= "B4G1";
        if(DIPLOMA_COUNT > Constants.NO_COURSE)
        {
            COUPON_DISCOUNT = Constants.DIPLOMA_PRICE * (Constants.ONE - Constants.PRO_DIPLOMA_DISCOUNT);
        }
        else if(CERTIFICATE_COUNT > Constants.NO_COURSE)
        {
            COUPON_DISCOUNT = Constants.CERTIFICATE_PRICE * (Constants.ONE - Constants.PRO_CERTIFICATE_DISCOUNT);
        }
        else if(DEGREE_COUNT > Constants.NO_COURSE)
        {
            COUPON_DISCOUNT = Constants.DEGREE_PRICE * (Constants.ONE - Constants.PRO_DEGREE_DISCOUNT);
        }
        TOTAL-= COUPON_DISCOUNT;
    }

    public void Apply_B4G1_CouponWithoutMembership()
    {
        COUPON_DISCOUNT_NAME= "B4G1";
        if (DIPLOMA_COUNT > Constants.NO_COURSE)
        {
            COUPON_DISCOUNT = Constants.DIPLOMA_PRICE;
        }
        else if(CERTIFICATE_COUNT > Constants.NO_COURSE)
        {
            COUPON_DISCOUNT = Constants.CERTIFICATE_PRICE;
        }
        else if(DEGREE_COUNT > Constants.NO_COURSE)
        {
            COUPON_DISCOUNT = Constants.DEGREE_PRICE;
        }
        TOTAL-= COUPON_DISCOUNT;
    }

    public void Apply_DEAL_G20_Coupon()
    {
        if(SUB_TOTAL >= Constants.PROGRAMME_VALUE && !COUPON_DISCOUNT_NAME.equals("B4G1"))
        {
            COUPON_DISCOUNT = TOTAL * Constants.G20_DISCOUNT;
            TOTAL -= TOTAL * Constants.G20_DISCOUNT;
            COUPON_DISCOUNT_NAME = "DEAL_G20";
        }
    }

    public void Apply_DEAL_G5_Coupon()
    {
        if(COURSE_COUNT >= Constants.MIN_PROGRAMME && !COUPON_DISCOUNT_NAME.equals("B4G1") && !COUPON_DISCOUNT_NAME.equals("DEAL_G20"))
        {
            COUPON_DISCOUNT= TOTAL * Constants.G5_DISCOUNT;
            TOTAL-= TOTAL * Constants.G5_DISCOUNT;
            COUPON_DISCOUNT_NAME= "DEAL_G5";
        }
    }
}
