package headquarter.beans

/**
 * Identification object used to mark a subscription on a topic.
 * 
 * @param topic The target topic of the subscription.
 * @param sn The serial number of the subscription inside the topic.
 */
case class SubscriptionId(topic: Topic, sn: Long)