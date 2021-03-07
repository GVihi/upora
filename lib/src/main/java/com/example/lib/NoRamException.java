package com.example.lib;

public class NoRamException extends Exception {
    private String systemIntegratorName;

    public NoRamException(String systemIntegratorName){
        super();
        this.systemIntegratorName = systemIntegratorName;
    }
}
