package com.blackpaws.day8mvvmcounter

data class CounterModel(var count: Int, var rotationState: Float, var rotationMod: Float)

class CounterRepository{
    private var _counter = CounterModel(0, 0f, 1f)

    fun getCounter() = _counter

    fun incrementCounter(){
        _counter.count++
        _counter.rotationState += _counter.rotationMod
    }

    fun decrementCounter(){
        _counter.count--
        _counter.rotationState -= _counter.rotationMod
    }
}