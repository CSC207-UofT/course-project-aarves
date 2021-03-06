package com.aarves.bluepages.adapter.presenters;

public class AccountViewMockup implements AccountView{
    private String popUpDisplay;

    private boolean finishActivity;
    private boolean startActivity;
    private boolean returnedToAccessMenu;

    @Override
    public void displayPopUp(String message) {
        this.popUpDisplay = message;
    }

    @Override
    public void startMainMenu() {
        this.startActivity = true;
    }

    @Override
    public void returnToAccessMenu() {
        this.returnedToAccessMenu = true;

    }

    @Override
    public void finishActivity() {
        this.finishActivity = true;
    }

    public String getPopUpDisplay(){
        return this.popUpDisplay;
    }

    public boolean isFinishActivity() {
        return this.finishActivity;
    }

    public boolean isStartActivity() {
        return this.startActivity;
    }

    public boolean isReturnedToAccessMenu(){
        return this.returnedToAccessMenu;
    }
}
