/**
 * 太阳系行星
 * @author admin
 * @date 2019-10-30
 */
public enum Planet {
	/**
	 * 水星
	 */
	MERCURY(3.302e+23, 2.439e6),
	/**
	 * 金星
	 */
	VENUS(4.869E+24, 6.052E6),
	/**
	 * 地球
	 */
	EARTH(5.975E+24, 6.378E6),
	/**
	 * 火星
	 */
	MARS(6.419E+23, 3.393e6),
	/**
	 * 木星
	 */
	JUPITER(1.899E+27, 7.149E7),
	/**
	 * 土星
	 */
	SATURN(5.685E+26, 6.027E7),
	/**
	 * 天王星
	 */
	URANUS(8.683E+25, 2.556E7),
	/**
	 * 海王星
	 */
	NEPTUNE(1.024E+26, 2.477E4);

	/**
	 * In kilograms
	 */
	private final double mass;

	/**
	 * In meters
	 */
	private final double radius;

	/**
	 * In m / s^2
	 */
	private final double surfaceGravity;

	/**
	 * Universal gravitational constant in m^3/kg s^2
	 */
	private static final double G = 6.67300e-11;

	Planet(double mass, double radius) {
		this.mass = mass;
		this.radius = radius;
		this.surfaceGravity = G * mass / (radius * radius);
	}

	public double getMass() {
		return mass;
	}

	public double getRadius() {
		return radius;
	}

	public double getSurfaceGravity() {
		return surfaceGravity;
	}

	public double surfaceWeight(double mass) {
		//F=ma
		return mass * surfaceGravity;
	}
}
