package com.aarves.bluepages.usecase.interactors.account;

public enum RegisterResult {
    SUCCESS,
    USERNAME_ALREADY_EXISTS,
    PASSWORD_MISMATCH,
    BAD_USERNAME_FORMAT
}
