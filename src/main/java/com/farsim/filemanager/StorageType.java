package com.farsim.filemanager;

public enum StorageType {
    APPLICATION_SERVER_STORAGE("default"),
    LOCAL_STORAGE("local"),
    AWS_S3("aws"),
    AZURE_BLOB("azure");

    String value;
    StorageType(String s) {
        this.value = s;
    }

    String getValue(){
        return this.value;
    }
}
