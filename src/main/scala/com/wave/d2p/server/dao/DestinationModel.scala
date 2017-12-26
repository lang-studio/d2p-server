package com.wave.d2p.server.dao

import com.outworkers.phantom.finagle._
import com.twitter.util.Future
import com.wave.d2p.common.model.Destination




/**
  * Create the Cassandra representation of the Destination table
  */
abstract class DestinationModel extends Table[DestinationModel, Destination] {

  override def tableName: String = "destination"

  object parentId extends IntColumn with PartitionKey
  object id extends IntColumn with PartitionKey
  object popularity extends DoubleColumn with ClusteringOrder with Descending
  object name extends StringColumn
  object description extends StringColumn
  object parentName extends StringColumn
  object longitude extends DoubleColumn
  object latitude extends DoubleColumn
  object isDefault extends BooleanColumn
  object duration extends FloatColumn

  def getByParentId(parentId: Int): Future[List[Destination]] = {
    select
      .where(_.parentId eqs parentId)
      .consistencyLevel_=(ConsistencyLevel.ONE)
      .fetch()
  }

  /*def deleteById(id: UUID): Future[ResultSet] = {
    delete
      .where(_.id eqs id)
      .consistencyLevel_=(ConsistencyLevel.ONE)
      .future()
  }*/
}