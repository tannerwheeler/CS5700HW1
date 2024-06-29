package org.example

class Point(
    _x : Double, //TODO: Verify how the private set is done.
    _y : Double
) {
    var x = _x
        private set
    var y = _y
        private set

    override fun equals(other: Any?): Boolean {
        return this.x == (other as Point).x && this.y == (other as Point).y
    }

    fun shift(deltaX : Double, deltaY : Double) {
        this.x += deltaX
        this.y += deltaY
    }
}