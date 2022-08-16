package com.theappland.restapiapp.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.theappland.restapiapp.view.model.PostModel
import com.theappland.restapiapp.view.service.PostAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ViewModel : ViewModel() {
    val posts = MutableLiveData<List<PostModel>>()
    private val postAPIService = PostAPIService()
    private val disposable = CompositeDisposable()

    fun refreshData() {
        disposable.add(
            postAPIService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<PostModel>>() {
                    override fun onSuccess(t: List<PostModel>) {
                        posts.value = t
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                })
        )
    }
}