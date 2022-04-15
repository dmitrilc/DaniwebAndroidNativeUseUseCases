package com.example.daniwebandroidnativeuseusecases

import kotlin.random.Random

class GetNextFakeBusinessDataUseCase {
    operator fun invoke(): FakeBusinessData{
        return FakeBusinessData (
            item1 = "${Random.nextInt()}",
            item2 = "${Random.nextInt()}",
            item3 = "${Random.nextInt()}"
        )
    }
}

/*
class GetNextFakeBusinessDataUseCase {
    fun getNextFakeBusinessData(): FakeBusinessData {
        return FakeBusinessData(
            item1 = "${Random.nextInt()}",
            item2 = "${Random.nextInt()}",
            item3 = "${Random.nextInt()}"
        )
    }
}*/
