package edu.knoldus

import org.apache.log4j.Logger

object MenuLauncher {

  def main(args: Array[String]): Unit = {
    val log = Logger.getLogger(this.getClass)
    import Run._
    val firstValue=1
    val secondValue=2
    val thirdValue=4
    val answer= ClientSideCommission(firstValue).getTotalCommission(List(ClientSideCommission(firstValue), ClientSideCommission(secondValue)))
    log.info(answer.toString)
    log.info(StreetSideCommission(firstValue).getTotalCommission(List(StreetSideCommission(firstValue), StreetSideCommission(thirdValue))))
  }

}
