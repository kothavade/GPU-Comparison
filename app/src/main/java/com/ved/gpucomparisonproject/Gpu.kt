package com.ved.gpucomparisonproject

data class Gpu(
    val image: Int,
    val manufacturer: String,
    val name: String,
    val price: Int,
    val memory: Int,
    val vram: String,
    val bus: String,
    val bandwidth: Int,
    val baseClock: Double,
    val boostClock: Double,
    val tdp: Int,
    val architecture: String,
    val rt: Boolean,
    val passmark: Int,
    val `3Dmark`: Int,
    val userbenchmark: Int){
}