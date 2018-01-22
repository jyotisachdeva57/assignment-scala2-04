package edu.knoldus

import org.apache.log4j.Logger

object MenuLauncher {

  def main(args: Array[String]): Unit = {
    val log = Logger.getLogger(this.getClass)
    import Run._
    val firstValue=1
    val secondValue=2
    val thirdValue=4
    log.info(List(ClientSideCommission(firstValue), ClientSideCommission(secondValue)).getTotalCommission)
    log.info(List(StreetSideCommission(firstValue), StreetSideCommission(secondValue)).getTotalCommission)
    log.info(List(ClientSideCommission(firstValue), StreetSideCommission(secondValue)).getTotalCommission)
  }

}
