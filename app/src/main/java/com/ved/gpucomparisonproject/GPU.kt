package com.ved.gpucomparisonproject
data class GPU(
    val image: Int,
    val manufacturer: String,
    val name: String,
    val price: Int,
    val memory: Int,
    val vram: String,
    val bandwidth: Int,
    val baseClock: Double,
    val boostClock: Double,
    val tdp: Int,
    val architecture: String,
    val review: String){
}