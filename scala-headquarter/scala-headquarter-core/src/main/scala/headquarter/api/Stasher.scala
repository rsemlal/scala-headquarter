package headquarter.api

import scala.concurrent.Future

import headquarter.beans.Topic

trait Stasher {
  /**
   * Stash a message.
   * @param topic The original topic of a message.
   * @param message The message.
   */
  def stash[T](topic: Topic, message: T): Unit

  /**
   * Unstashes all messages related to a topic.
   *
   * @param topic The original topic of messages to unstash.
   * @return The messages unstashed.
   */
  def unstash(topic: Topic): Future[Seq[Future[Any]]]

  /**
   * List stashed messages on a topic without consuming them.
   *
   * @param topic The original topic of messages to unstash.
   * @return The stashed messages.
   */
  def listStashed(topic: Topic): Future[Seq[Future[Any]]]
}