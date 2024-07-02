package org.example

class Point(
    _x : Double,
    _y : Double
) {
    var x = _x
        private set(value) {
            field = if(!value.isNaN()) value else throw
            IllegalArgumentException("X value is NaN")
        }
    var y = _y
        private set(value) {
            field = if(!value.isNaN()) value else throw
            IllegalArgumentException("Y value is NaN")
        }

    override fun equals(other: Any?): Boolean {
        if (other is ArrayList<*>) {
            return this.x == (other as ArrayList<*>)[0] && this.y == (other as ArrayList<*>)[1]
        } else if (other is Point) {
            return this.x == (other as Point).x && this.y == (other as Point).y
        } else {
            return false
        }
    }

    fun shift(deltaX : Double, deltaY : Double) {
        this.x += deltaX
        this.y += deltaY
    }
}