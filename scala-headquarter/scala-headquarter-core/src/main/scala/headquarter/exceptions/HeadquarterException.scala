package headquarter.exceptions

/**
 * Base headquarter exception.
 * 
 * @param message The exception message.
 * @param throwable The inner throwable.
 */
class HeadquarterException(message: String, throwable: Throwable) extends Exception(message, throwable) {
  
  /**
   * Base headquarter exception.
   * 
   * @param message The exception message.
   */
  def this(message: String) = {
    this(message, null)
  }

  /**
   * Base headquarter exception.
   * 
   * @param throwable The inner throwable.
   */
  def this(throwable: Throwable) = {
    this("Headquarter exception", throwable)
  }

  /**
   * Base headquarter exception.
   */
  def this() = {
    this("Headquarter exception", null)
  }
}