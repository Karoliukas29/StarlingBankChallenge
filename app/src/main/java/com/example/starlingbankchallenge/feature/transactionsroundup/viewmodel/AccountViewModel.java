package com.example.starlingbankchallenge.feature.transactionsroundup.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.ViewModel;

import com.example.starlingbankchallenge.BuildConfig;
import com.example.starlingbankchallenge.model.account.AccountsResponse;
import com.example.starlingbankchallenge.model.transactions.TransactionResponse;
import com.example.starlingbankchallenge.network.base.StateLiveData;
import com.example.starlingbankchallenge.repository.AccountRepository;
import com.example.starlingbankchallenge.repository.TransfersRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;
// using hilt for dependency injection
@HiltViewModel
public class AccountViewModel extends ViewModel {
    private static final String TAG = "AccountviewModel";
    private AccountRepository accountRepository;
    private TransfersRepository transfersRepository;
    public StateLiveData<TransactionResponse> stateLiveData = new StateLiveData<>();



    @Inject
    public AccountViewModel(AccountRepository accountRepository, TransfersRepository transfersRepository) {
        this.accountRepository = accountRepository;
        this.transfersRepository = transfersRepository;
    }
    //Creating live date from the flowable function, using LiveDataReactiveStreams
    public LiveData<AccountsResponse> loadAccounts() {
        return LiveDataReactiveStreams.fromPublisher(getAccountsFlowable());
    }
    // convert single to flowable and subscribe it on io thread and observeOn main thread, and getting result/error
    private Flowable<AccountsResponse> getAccountsFlowable() {
        return accountRepository.getAccounts(BuildConfig.API_SECRET_TOKEN)
                .toFlowable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(result -> Timber.tag(TAG).i(result.toString()))
                .doOnError(result -> {
                    Timber.tag(TAG).e(result);
                });
    }

    public LiveData<TransactionResponse> loadTransactions(String accountUid, String categoryUid, String changesSince) {
        return LiveDataReactiveStreams.fromPublisher(getTransactionsFlowable(accountUid, categoryUid, changesSince));
    }
    // convert single to flowable and subscribe it on io thread and observeOn main thread, and getting result/error
    private Flowable<TransactionResponse> getTransactionsFlowable(String accountUid, String categoryUid, String changesSince) {
        return transfersRepository.getTransactions(BuildConfig.API_SECRET_TOKEN, accountUid, categoryUid, changesSince)
                .toFlowable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(result ->{
                    stateLiveData.postComplete();
                    Timber.tag(TAG).i(result.toString());
                })
                .doOnError(result -> {
                    stateLiveData.postError(result);
                    Timber.tag(TAG).e(result);
                });
    }




}
