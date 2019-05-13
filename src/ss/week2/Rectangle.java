package ss.week2;

public class Rectangle {
	// @private invariant length >= 0 && width >= 0
    private int length;
    private int width;

    /**
     * Create a new Rectangle with the specified length and width.
     * @requires length >= 0 && width >= 0
     * @ensures this.length == length && this.width == width
     */
    public Rectangle(int length, int width) {
    	assert length >= 0 && width >= 0;  
    	this.length = length;
    	this.width = width;
    	assert this.length >= 0 && this.width >= 0;
    	assert length() == length && width() == width;
    }
    
    /**
     * The length of this Rectangle.
     * @pure 
     * @ensures \result >= 0
     */
    public int length() {
    	assert length >= 0;
	return length;
    }

    /**
     * The width of this Rectangle.
     * @pure
     * @ensures \result >=0
     */
    public int width() {
    	assert width >= 0;
    	return width;
    }

    /**
     * The area of this Rectangle.
     * @pure
     * @requires area = this.length*this.width
     *@ensures \result > 0 && \result <= this.length*this.width
     */
    public int area() {
    	assert this.length*this.width == length()*width();
    	return (this.length*this.width);
    }

    /**
     * The perimeter of this Rectangle.
     * @pure
     * @requires perimeter = 2*length + 2*width
     * @ensures \result >= 0
     */
    public int perimeter() {
    	assert 2*this.length + 2*this.width == 2*length() + 2*width();
    	return ((2*this.length)+ (2*this.width));
    }
}
