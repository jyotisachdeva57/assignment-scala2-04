package edu.knoldus

import scala.reflect.runtime.universe._

abstract class Commission(val value: Int)

case class ClientSideCommission(override val value: Int) extends Commission(value: Int)

case class StreetSideCommission(override val value: Int) extends Commission(value: Int)

private sealed trait CommissionDisplay[A <: Commission] {
  def totalDisplayCommission: String
}

object Run {

   implicit class TotalDisplayCommission[A <: Commission](xs: List[A]) {

    def getTotalCommission[B <: Commission: TypeTag]: String = typeOf[A] match {
      case t if t =:= typeOf[Commission] => "Commission".totalDisplayCommission + xs.map(_.value).sum
      case t if t <:< typeOf[ClientSideCommission] => "Client Commission".totalDisplayCommission + xs.map(_.value).sum
      case t if t <:< typeOf[StreetSideCommission] => "Street Commission".totalDisplayCommission + xs.map(_.value).sum
    }

    private implicit class ClientImplicit(str: String) extends CommissionDisplay[A] {
      def totalDisplayCommission:String = s"The total $str is"
    }
  }
}
