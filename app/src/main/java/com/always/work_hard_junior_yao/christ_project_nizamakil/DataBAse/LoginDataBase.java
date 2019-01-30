package com.always.work_hard_junior_yao.christ_project_nizamakil.DataBAse;

import android.provider.BaseColumns;

public final class LoginDataBase {

    private LoginDataBase(){
        }


        // inner class that define table content
        public static class FeedEntry_login implements BaseColumns {
            public static final String TABLE_NAME = "Login";
            public static final String COLUMN_USERID = "UserID";
            public static final String COLUMN_PASSWORD = "Password";
        }



     }
