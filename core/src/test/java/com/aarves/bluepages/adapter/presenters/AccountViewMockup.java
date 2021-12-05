package com.aarves.bluepages.adapter.presenters;

public class AccountViewMockup implements AccountView{
    boolean finishActivity;
    boolean startActivity;
    String popUpDisplay;

    public String getPopUpDisplay(){
        return this.popUpDisplay;
    }

    @Override
    public void displayPopUp(String message) {
        this.popUpDisplay = message;
    }

    @Override
    public void startMainMenu() {
        this.startActivity = true;
    }

    @Override
    public void finishActivity() {
        this.finishActivity = true;
    }
}
