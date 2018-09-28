package com.example.jason.onecode_servicebestpractice;

public interface DownloadListener {

    void onProgress(int progress);

    void onSuccess();

    void onFailed();
    void onPaused();
    void onCanceled();

}
