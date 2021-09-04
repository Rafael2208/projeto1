package br.com.mvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private final MutableLiveData<Boolean> mIniciar = new MutableLiveData<>();

    public LiveData<Boolean> Login = mIniciar;

    public void doLogin(String email) {

           this.mIniciar.setValue(email.equals(""));

    }
}
