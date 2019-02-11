package com.always.work_hard_junior_yao.christ_project_nizamakil;

public class cart_items {

    private int imageRa;
    private  String text11;
    private String text22;
    private String text33;
    private int btn1, btn2;

    public cart_items(int imageResource , String Text1, String Text2, String Text3, int Button , int Button2)
    {
        imageRa= imageResource;
        text11= Text1;
        text22= Text2;
        text33= Text3;
        btn1= Button;
        btn2= Button2;
    }


    public  int getImageResources()
    {
        return imageRa;
    }

    public String getText1()
    {
        return text11;
    }

    public  String getText2()
    {
        return text22;
    }

    public  String getText3()
    {
        return text33;
    }

    public  int getButton()
    {
        return btn1;
    }

    public  int getButton2()
    {
        return btn2;
    }

}

