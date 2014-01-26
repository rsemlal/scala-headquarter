package headquarter.exceptions

/**
 * Stashing exception.
 * 
 * @param message The exception message.
 * @param throwable The inner throwable.
 */
class StashingException(message: String, throwable: Throwable) extends HeadquarterException(message, throwable) {
  
  /**
   * Constructor for StashingException.
   * 
   * @param message The exception message.
   */
  def this(message: String) = {
    this(message, null)
  }

  /**
   * Constructor for StashingException.
   * 
   * @param throwable The inner throwable.
   */
  def this(throwable: Throwable) = {
    this("Stashing exception", throwable)
  }

  /**
   * Constructor for StashingException.
   */
  def this() = {
    this("Stashing exception", null)
  }
}