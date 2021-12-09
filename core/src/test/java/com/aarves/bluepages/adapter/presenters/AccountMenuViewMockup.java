package com.aarves.bluepages.adapter.presenters;

public class AccountMenuViewMockup implements AccountMenuView{

    boolean activityFinished;
    String popUpDisplay;
    String accountInfoDisplay;

    @Override
    public void displayAccountInformation(String userText) {
        this.accountInfoDisplay = userText;
    }

    @Override
    public void displayPopUp(String message) {
        this.popUpDisplay = message;
    }

    @Override
    public void finishActivity() {
        this.activityFinished = true;
    }
}
