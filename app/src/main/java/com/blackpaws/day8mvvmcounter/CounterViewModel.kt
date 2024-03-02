package com.blackpaws.day8mvvmcounter

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

//class CounterViewModel(private val repository: CounterRepository) : ViewModel() {
class CounterViewModel() : ViewModel() {
    private val _repository: CounterRepository = CounterRepository()
    private var _count = mutableIntStateOf(_repository.getCounter().count)
    val count: State<Int> = _count
    private var _rotationState = mutableFloatStateOf(0f)
    val rotationState: State<Float> = _rotationState

    fun increment() {
        _repository.incrementCounter()
        _count.intValue = _repository.getCounter().count
        _rotationState.floatValue = _repository.getCounter().rotationState
    }

    fun decrement() {
        _repository.decrementCounter()
        _count.intValue = _repository.getCounter().count
        _rotationState.floatValue = _repository.getCounter().rotationState
    }

//    // Пустой конструктор - только для примера с class CounterViewModel(private val repository: CounterRepository) : ViewModel()
//    constructor() : this(CounterRepository())
}