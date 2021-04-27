package com.example

import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors

object CalculatorInteractive {
  def apply(): Behavior[Calculator.ExpressionResult] = {
    outputExpression()
  }

  private def outputExpression(): Behavior[Calculator.ExpressionResult] =
    Behaviors.receive { (context, message) =>
      println(s"Expression result: ${message.result} for ${message.expression}")
      Behaviors.stopped
    }
}


