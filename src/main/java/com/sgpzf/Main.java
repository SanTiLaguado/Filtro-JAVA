package com.sgpzf;

import java.sql.SQLException;

import com.sgpzf.view.MainView;

public class Main {
    public static void main(String[] args) throws SQLException {
        MainView mainView = new MainView();
        mainView.Start();
    }
}