package com.wave.d2p.server.dao

import com.wave.d2p.server.dao.CassandraConnector._
import com.outworkers.phantom.connectors.CassandraConnection
import com.outworkers.phantom.dsl._


/**
  * This is our Database object that wraps our two existing tables,
  * giving the ability to receive different connectors
  * for example: One for production and other for testing
  */
class CassandraDatabase(override val connector: CassandraConnection) extends Database[CassandraDatabase](connector) {
  object DestinationModel extends DestinationModel with connector.Connector

  /**
    * Save a song in both tables
    *
    * @param songs
    * @return
    */
  /*def saveOrUpdate(songs: Song): Future[ResultSet] = {
    Batch.logged
      .add(DestinationModel$.store(songs))
      .future()
  }*/

  /**
    * Delete a song in both table
    *
    * @param song
    * @return
    */
  /*def delete(song: Song): Future[ResultSet] = {
    Batch.logged
      .add(DestinationModel$.delete.where(_.id eqs song.id))
      .future()
  }*/
}

/**
  * This is the database, it connects to a cluster with multiple contact points
  */
object MyRefDatabase extends CassandraDatabase(connector)