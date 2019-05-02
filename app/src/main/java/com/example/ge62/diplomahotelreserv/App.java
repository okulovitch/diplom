//package com.example.ge62.diplomahotelreserv;
//
//import android.app.Application;
//
//import com.nostra13.universalimageloader.core.DisplayImageOptions;
//import com.nostra13.universalimageloader.core.ImageLoader;
//import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
//
//public class App extends Application {
//
//
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//
//        initUniversalImageLoader();
//    }
//
//    private void initUniversalImageLoader() {
//        ImageLoaderConfiguration.Builder configBuilder = new ImageLoaderConfiguration.Builder(this);
//        DisplayImageOptions option = new DisplayImageOptions.Builder().build();
//
//        configBuilder.defaultDisplayImageOptions(option);
//        configBuilder.threadPoolSize(3);
//
//        ImageLoader.getInstance().init(configBuilder.build());
//
//
//    }
//}
