package com.example.starlingbankchallenge.feature.transactionsroundup.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.ViewModel;

import com.example.starlingbankchallenge.BuildConfig;
import com.example.starlingbankchallenge.model.account.AccountsResponse;
import com.example.starlingbankchallenge.model.spaces.SpacesResponse;
import com.example.starlingbankchallenge.model.transactions.TransactionResponse;
import com.example.starlingbankchallenge.network.base.StateLiveData;
import com.example.starlingbankchallenge.repository.AccountRepository;
import com.example.starlingbankchallenge.repository.SavingsGoalRepository;
import com.example.starlingbankchallenge.repository.SpacesRepository;
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
    private static final String TAG = "AccountViewModel";
    private AccountRepository accountRepository;
    private TransfersRepository transfersRepository;
    private SavingsGoalRepository savingsGoalRepository;
    private SpacesRepository spacesRepository;
    public StateLiveData<TransactionResponse> stateLiveData = new StateLiveData<>();

    @Inject
    public AccountViewModel(AccountRepository accountRepository, TransfersRepository transfersRepository,SpacesRepository spacesRepository,SavingsGoalRepository savingsGoalRepository) {
        this.accountRepository = accountRepository;
        this.transfersRepository = transfersRepository;
        this.spacesRepository = spacesRepository;
        this.savingsGoalRepository = savingsGoalRepository;
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

    public LiveData<SpacesResponse> loadSpaces(String accountUid) {
        return LiveDataReactiveStreams.fromPublisher(getSpacesFlowable(accountUid));
    }
    // convert single to flowable and subscribe it on io thread and observeOn main thread, and getting result/error
    private Flowable<SpacesResponse> getSpacesFlowable(String accountUid) {
        return spacesRepository.getSpaces(BuildConfig.API_SECRET_TOKEN, accountUid)
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

//    public void calculateRoundUp(Double minorUnit){
//            double amountWithDecimal = (double) (minorUnits / 100.00);
//            double roundedAmount = Math.ceil(amountWithDecimal);
//            double availableAmountToRoundUp = roundedAmount - amountWithDecimal;
//    }

//    public LiveData<SavingsGoalResponse> loadSavingGoals(String accountUid, SavingsGoalRequest request) {
//        return LiveDataReactiveStreams.fromPublisher(getSavingsGoalFlowable(accountUid, request));
//    }
//    // convert single to flowable and subscribe it on io thread and observeOn main thread, and getting result/error
//    private Flowable<SavingsGoalResponse> getSavingsGoalFlowable(String accountUid, SavingsGoalRequest request) {
//        return savingsGoalRepository.getSavingGoal(BuildConfig.API_SECRET_TOKEN, accountUid, request)
//                .toFlowable()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnNext(result ->{
//                    stateLiveData.postComplete();
//                    Timber.tag(TAG).i(result.toString());
//                })
//                .doOnError(result -> {
//                    stateLiveData.postError(result);
//                    Timber.tag(TAG).e(result);
//                });
//    }

//    public LiveData<RoundUpResponse> loadRoundUps(String accountUid, RoundUpRequest request) {
//        return LiveDataReactiveStreams.fromPublisher(getRoundUpFlowable(accountUid, request));
//    }
//    private Flowable<RoundUpResponse> getRoundUpFlowable(String accountUid, RoundUpRequest request) {
//        return roundUpRepository.getRoundsUps(BuildConfig.API_SECRET_TOKEN, accountUid, request)
//                .toFlowable()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnNext(result -> Timber.tag(TAG).i(result.toString()))
//                .doOnError(result -> {
//                    Timber.tag(TAG).e(result);
//                });
//    }
}
