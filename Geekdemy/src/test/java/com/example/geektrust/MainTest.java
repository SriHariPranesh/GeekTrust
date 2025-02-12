package com.example.geektrust;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    private Coupon coupon;

    @BeforeEach
    public void setup()
    {
        coupon = new Coupon();
    }

    @Test
    public void testSubTotalDegreeProgramme() {
        coupon.SubTotal("ADD_PROGRAMME DEGREE 3");
        assertEquals(15000, coupon.SUB_TOTAL);
        assertEquals(3, coupon.COURSE_COUNT);
        assertEquals(3, coupon.DEGREE_COUNT);
    }

    @Test
    public void testSubTotalCertificateProgramme() {
        coupon.SubTotal("ADD_PROGRAMME CERTIFICATION 1");
        assertEquals(3000, coupon.SUB_TOTAL);
        assertEquals(1, coupon.COURSE_COUNT);
        assertEquals(1, coupon.CERTIFICATE_COUNT);
    }

    @Test
    public void testProMembershipWithoutCourses()
    {
        coupon.ProMembership();
        assertEquals(200, coupon.PRO_FEE);
        assertEquals(0, coupon.PRO_DISCOUNT);
        assertEquals(200, coupon.TOTAL);
        assertEquals(200, coupon.SUB_TOTAL);
    }

    @Test
    public void testEnrollmentFeeBelow6666() {
        coupon.TOTAL= 5000;
        coupon.EnrollmentFee();

        assertEquals(500, coupon.ENROLLMENT_FEE);
        assertEquals(5500, coupon.TOTAL);
    }

    @Test
    public void testEnrollmentFeeAbove6666() {
        coupon.TOTAL= 7000;
        coupon.EnrollmentFee();

        assertEquals(0, coupon.ENROLLMENT_FEE);
        assertEquals(7000, coupon.TOTAL);
    }

    @Test
    public void testApply_G20_CouponWithoutMembership()
    {
        coupon.SubTotal("ADD_PROGRAMME DEGREE 3");
        coupon.ProMembership();
        coupon.Apply_DEAL_G20_Coupon();

        assertEquals(14750, coupon.SUB_TOTAL);
        assertEquals(11800, coupon.TOTAL);
        assertEquals(2950, coupon.COUPON_DISCOUNT);
    }

    @Test
    public void testApply_G20_CouponWithMembership() {
        coupon.SubTotal("ADD_PROGRAMME DEGREE 3");
        coupon.Apply_DEAL_G20_Coupon();

        assertEquals(3000, coupon.COUPON_DISCOUNT);
        assertEquals(12000, coupon.TOTAL);
        assertEquals("DEAL_G20", coupon.COUPON_DISCOUNT_NAME);
    }

    @Test
    public void testApply_B4G1_CouponWithMembership() {
        coupon.SubTotal("ADD_PROGRAMME DIPLOMA 4");
        coupon.ProMembership();
        coupon.Apply_B4G1_CouponWithMembership();
        coupon.Apply_DEAL_G20_Coupon();
        coupon.Apply_DEAL_G5_Coupon();
        coupon.EnrollmentFee();

        assertEquals(2475, coupon.COUPON_DISCOUNT);
        assertEquals(7625, coupon.TOTAL);
        assertEquals(0, coupon.ENROLLMENT_FEE);
        assertEquals("B4G1", coupon.COUPON_DISCOUNT_NAME);
    }

    @Test
    public void testApply_B4G1_CouponWithoutMembership() {
        coupon.SubTotal("ADD_PROGRAMME CERTIFICATION 1");
        coupon.SubTotal("ADD_PROGRAMME DEGREE 2");
        coupon.SubTotal("ADD_PROGRAMME DIPLOMA 2");
        coupon.Apply_B4G1_CouponWithoutMembership();
        coupon.Display();

        assertEquals(18000, coupon.SUB_TOTAL);
        assertEquals(2500, coupon.COUPON_DISCOUNT);
        assertEquals("B4G1", coupon.COUPON_DISCOUNT_NAME);
        assertEquals(0, coupon.PRO_DISCOUNT);
        assertEquals(15500, coupon.TOTAL);
        assertEquals(0, coupon.PRO_FEE);
    }

    @Test
    public void testApply_G5_CouponWithMembership()
    {
        coupon.SubTotal("ADD_PROGRAMME DIPLOMA 3");
        coupon.ProMembership();
        coupon.Apply_DEAL_G5_Coupon();
        assertEquals(75, coupon.PRO_DISCOUNT);
        assertEquals(7243.75, coupon.TOTAL);
        assertEquals(0, coupon.ENROLLMENT_FEE);
        assertEquals(7625, coupon.SUB_TOTAL);
        assertEquals(381.25, coupon.COUPON_DISCOUNT);
    }

    @Test
    public void testApply_G5_CouponWithoutMembership()
    {
        coupon.SubTotal("ADD_PROGRAMME DIPLOMA 3");
        coupon.Apply_DEAL_G5_Coupon();
        assertEquals(0, coupon.PRO_DISCOUNT);
        assertEquals(7125, coupon.TOTAL);
        assertEquals(0, coupon.ENROLLMENT_FEE);
        assertEquals(375, coupon.COUPON_DISCOUNT);
    }

    @Test
    public void testDisplayWithNoCourses()
    {
        coupon.Display();
        assertEquals(0, coupon.SUB_TOTAL);
        assertEquals(0, coupon.TOTAL);
        assertEquals("NONE", coupon.COUPON_DISCOUNT_NAME);
        assertEquals(0, coupon.ENROLLMENT_FEE);
    }
}