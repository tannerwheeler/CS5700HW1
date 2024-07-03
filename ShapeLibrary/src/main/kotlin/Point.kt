package org.example

class Point(
    _x : Double,
    _y : Double
) {
    var x : Double = 0.0
        private set(value) {
            field = if(!value.isNaN()) value else throw
            IllegalArgumentException("X value is NaN")
        }
    var y : Double = 0.0
        private set(value) {
            field = if(!value.isNaN()) value else throw
            IllegalArgumentException("Y value is NaN")
        }

    init {
        x = _x
        y = _y
    }

    override fun equals(other: Any?): Boolean {
        return this.x == (other as Point).x && this.y == (other as Point).y
    }

    fun shift(deltaX : Double, deltaY : Double) {
        this.x += deltaX
        this.y += deltaY
    }

    fun clone() = Point(this.x, this.y)
}