package com.always.work_hard_junior_yao.christ_project_nizamakil;

public class ContentItems {

    private int imageR;
    private  String text1;
    private String text2;

    public ContentItems(int imageResource , String Text1, String Text2)
    {
        imageR= imageResource;
        text1= Text1;
        text2= Text2;
    }


    public  int getImageResources()
    {
        return imageR;
    }

    public String getText1()
    {
        return text1;
    }

    public  String getText2()
    {
        return text2;
    }
}


