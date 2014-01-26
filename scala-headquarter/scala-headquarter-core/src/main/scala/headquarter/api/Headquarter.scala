package headquarter.api

import scala.concurrent.Future

import akka.actor.ActorRef
import headquarter.beans.SubscriptionId
import headquarter.beans.Topic

trait Headquarter {
  /**
   * Publishes a message on a topic.
   *
   * @param topic The target topic.
   * @param message The message to publish.
   */
  def publish(topic: Topic, message: Any): Unit

  /**
   * Subscribes an actor to a topic.
   * Note that if an actor subscribe twice (without unsubscribing) to the same topic, it will count for only one susbcription,
   * and hence this method will return the same id for both calls.
   *
   * @param topic The target topic.
   * @param ref The [[akka.actor.ActorRef]] to subscribe to the topic.
   * @return a future subscription id to use later for unsubscribtion.
   */
  def subscribe(topic: Topic, ref: ActorRef): Future[SubscriptionId]

  /**
   * Unsubscribe an actor from a topic.
   *
   * @param subscriptionId The subscription id returned by the [subscribe] method.
   * @return The [[akka.actor.ActorRef]] that has been unsubscribed.
   */
  def unsubscribe(subscriptionId: SubscriptionId): Future[ActorRef]

  /**
   * Unsubscribe an actor from a topic.
   *
   * @param topic The target topic.
   * @param ref The [[akka.actor.ActorRef]] to unsubscribe from the topic.
   * @return A subscription id related to the actor that has been unsubscribed.
   */
  def unsubscribe(topic: Topic, ref: ActorRef): Future[SubscriptionId]

  /**
   * Unsubscribe all subscribers from a topic.
   *
   * @param topic The target topic.
   * @return a list of couples (subscription id, subscriber actor) of the unsubscribed actors.
   */
  def unsubscribeAll(topic: Topic): Future[Seq[(SubscriptionId, ActorRef)]]

  /**
   * Unsubscribe an actor from all topics.
   * @param ref The actor to unsubscribe.
   */
  def unsubscribeFromAll(ref: ActorRef): Unit

  /**
   * Lists all subscribers registred on a topic.
   *
   * @param topic The target topic.
   * @return a list of couples (subscription id, subscriber actor) currently subscribed.
   */
  def listSubscriptions(topic: Topic): Future[Seq[(SubscriptionId, ActorRef)]]
}