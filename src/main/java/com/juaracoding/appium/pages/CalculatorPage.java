package com.juaracoding.appium.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage {

    public AndroidDriver<MobileElement> driver;

    public CalculatorPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //Locator
//	By btnSatu = By.id("com.android.calculator2:id/digit_1");
//	By btnDua = By.id("com.android.calculator2:id/digit_2");
//	By btnTambah = By.id("com.android.calculator2:id/op_add");
//	By btnSamaDengan = By.id("com.android.calculator2:id/eq");
//	By hasil = By.id("com.android.calculator2:id/result");
//	/* web: xpath = //taghtml[contains(@attr, value)] */


    @AndroidFindBy(id = "com.google.android.calculator:id/digit_1")
    private MobileElement btnSatu;
    @AndroidFindBy(id = "com.google.android.calculator:id/digit_2")
    private MobileElement btnDua;
    @AndroidFindBy(id = "com.google.android.calculator:id/op_add")
    private MobileElement btnTambah;
    @AndroidFindBy(id = "com.google.android.calculator:id/eq")
    private MobileElement btnSamaDengan;

    @AndroidFindBy(id = "com.google.android.calculator:id/clr")
    private MobileElement btnClear;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_3")
    private MobileElement btnTiga;
    @AndroidFindBy(id = "com.google.android.calculator:id/op_mul")
    private MobileElement btnPerkalian;
    @AndroidFindBy(id = "com.google.android.calculator:id/digit_4")
    private MobileElement btnEmpat;



    @AndroidFindBy(id = "com.google.android.calculator:id/result_final")
    private MobileElement hasil;

    //Method
    public void calcTambah() {
        btnSatu.click();
        btnTambah.click();
        btnDua.click();
        btnSamaDengan.click();
    }

    public void calcKali(){
        btnClear.click();
        btnTiga.click();
        btnPerkalian.click();
        btnEmpat.click();
        btnSamaDengan.click();
    }

    //
    public String getTxtResult() {
        return hasil.getText();
    }

}