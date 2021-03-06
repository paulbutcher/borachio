// Copyright (c) 2011 Paul Butcher
// 
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
// 
// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.
// 
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE.

package com.borachio

/**
 * Represents a single expectation
 */
class Expectation(target: MockFunction) extends Handler {
  
  def expects(arguments: Any*) = {
    argumentsString = "with arguments: "+ arguments.mkString("(", ", ", ")")
    argumentsMatcher = { args => arguments sameElements args }
    this
  }
  
  def withArguments(arguments: Any*) = expects(arguments: _*)
  
  def withArgs(arguments: Any*) = expects(arguments: _*)
  
  def expectsWhere[T1](matcher: T1 => Boolean) = {
    argumentsMatcher = new FunctionAdapter1(matcher)
    this
  }
  def expectsWhere[T1, T2](matcher: (T1, T2) => Boolean) = {
    argumentsMatcher = new FunctionAdapter2(matcher)
    this
  }
  def expectsWhere[T1, T2, T3](matcher: (T1, T2, T3) => Boolean) = {
    argumentsMatcher = new FunctionAdapter3(matcher)
    this
  }
  def expectsWhere[T1, T2, T3, T4](matcher: (T1, T2, T3, T4) => Boolean) = {
    argumentsMatcher = new FunctionAdapter4(matcher)
    this
  }
  def expectsWhere[T1, T2, T3, T4, T5](matcher: (T1, T2, T3, T4, T5) => Boolean) = {
    argumentsMatcher = new FunctionAdapter5(matcher)
    this
  }
  def expectsWhere[T1, T2, T3, T4, T5, T6](matcher: (T1, T2, T3, T4, T5, T6) => Boolean) = {
    argumentsMatcher = new FunctionAdapter6(matcher)
    this
  }
  def expectsWhere[T1, T2, T3, T4, T5, T6, T7](matcher: (T1, T2, T3, T4, T5, T6, T7) => Boolean) = {
    argumentsMatcher = new FunctionAdapter7(matcher)
    this
  }
  def expectsWhere[T1, T2, T3, T4, T5, T6, T7, T8](matcher: (T1, T2, T3, T4, T5, T6, T7, T8) => Boolean) = {
    argumentsMatcher = new FunctionAdapter8(matcher)
    this
  }
  def expectsWhere[T1, T2, T3, T4, T5, T6, T7, T8, T9](matcher: (T1, T2, T3, T4, T5, T6, T7, T8, T9) => Boolean) = {
    argumentsMatcher = new FunctionAdapter9(matcher)
    this
  }
  def expectsWhere[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10](matcher: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) => Boolean) = {
    argumentsMatcher = new FunctionAdapter10(matcher)
    this
  }
  
  def where[T1](matcher: T1 => Boolean) = expectsWhere(matcher)
  def where[T1, T2](matcher: (T1, T2) => Boolean) = expectsWhere(matcher)
  def where[T1, T2, T3](matcher: (T1, T2, T3) => Boolean) = expectsWhere(matcher)
  def where[T1, T2, T3, T4](matcher: (T1, T2, T3, T4) => Boolean) = expectsWhere(matcher)
  def where[T1, T2, T3, T4, T5](matcher: (T1, T2, T3, T4, T5) => Boolean) = expectsWhere(matcher)
  def where[T1, T2, T3, T4, T5, T6](matcher: (T1, T2, T3, T4, T5, T6) => Boolean) = expectsWhere(matcher)
  def where[T1, T2, T3, T4, T5, T6, T7](matcher: (T1, T2, T3, T4, T5, T6, T7) => Boolean) = expectsWhere(matcher)
  def where[T1, T2, T3, T4, T5, T6, T7, T8](matcher: (T1, T2, T3, T4, T5, T6, T7, T8) => Boolean) = expectsWhere(matcher)
  def where[T1, T2, T3, T4, T5, T6, T7, T8, T9](matcher: (T1, T2, T3, T4, T5, T6, T7, T8, T9) => Boolean) = expectsWhere(matcher)
  def where[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10](matcher: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) => Boolean) = expectsWhere(matcher)
  
  def onCall[T1, R](f: T1 => R) = {
    onCallHandler = new FunctionAdapter1(f)
    this
  }
  def onCall[T1, T2, R](f: (T1, T2) => R) = {
    onCallHandler = new FunctionAdapter2(f)
    this
  }
  def onCall[T1, T2, T3, R](f: (T1, T2, T3) => R) = {
    onCallHandler = new FunctionAdapter3(f)
    this
  }
  def onCall[T1, T2, T3, T4, R](f: (T1, T2, T3, T4) => R) = {
    onCallHandler = new FunctionAdapter4(f)
    this
  }
  def onCall[T1, T2, T3, T4, T5, R](f: (T1, T2, T3, T4, T5) => R) = {
    onCallHandler = new FunctionAdapter5(f)
    this
  }
  def onCall[T1, T2, T3, T4, T5, T6, R](f: (T1, T2, T3, T4, T5, T6) => R) = {
    onCallHandler = new FunctionAdapter6(f)
    this
  }
  def onCall[T1, T2, T3, T4, T5, T6, T7, R](f: (T1, T2, T3, T4, T5, T6, T7) => R) = {
    onCallHandler = new FunctionAdapter7(f)
    this
  }
  def onCall[T1, T2, T3, T4, T5, T6, T7, T8, R](f: (T1, T2, T3, T4, T5, T6, T7, T8) => R) = {
    onCallHandler = new FunctionAdapter8(f)
    this
  }
  def onCall[T1, T2, T3, T4, T5, T6, T7, T8, T9, R](f: (T1, T2, T3, T4, T5, T6, T7, T8, T9) => R) = {
    onCallHandler = new FunctionAdapter9(f)
    this
  }
  def onCall[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R](f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) => R) = {
    onCallHandler = new FunctionAdapter10(f)
    this
  }

  def returns(value: Any) = {
    returnString = "returning: "+ value
    onCallHandler = { _ => value }
    this
  }
  
  def returning(value: Any) = returns(value)
  
  def throws(e: Throwable) = {
    returnString = "throwing: "+ e
    onCallHandler = { _ => throw e }
    this
  }
  
  def throwing(e: Throwable) = throws(e)
  
  def repeat(range: Range) = {
    require(!expectedCalls.isDefined, "expected number of calls can only be set once")
    expectedCalls = Some(range)
    this
  }
  
  def repeat(count: Int): Expectation = repeat(count to count)
  
  def never() = repeat(0)
  def once() = repeat(1)
  def twice() = repeat(2)
  
  def anyNumberOfTimes() = repeat(0 to scala.Int.MaxValue - 1)
  def atLeastOnce() = repeat(1 to scala.Int.MaxValue - 1)
  def atLeastTwice() = repeat(2 to scala.Int.MaxValue - 1)

  def noMoreThanOnce() = repeat(0 to 1)
  def noMoreThanTwice() = repeat(0 to 2)
  
  def repeated(range: Range) = repeat(range)
  def repeated(count: Int) = repeat(count)
  def times() = this

  override def toString = 
    Seq(target.toString, argumentsString, returnString, expectedCallsString, actualCallsString).
      filter(_.length > 0).mkString(", ")
  
  private[borachio] def satisfied = expectedCalls match {
    case Some(r) => r contains actualCalls
    case None => actualCalls > 0
  }
  
  private[borachio] def unsatisfiedString = toString
  
  private[borachio] def exhausted = expectedCalls match {
    case Some(r) => r.last == actualCalls
    case None => false
  }
  
  private[borachio] def handle(mock: MockFunction, arguments: Array[Any]): Option[Any] = {
    if (mock == target && !exhausted && (!argumentsMatcher.isDefined || argumentsMatcher.get(arguments))) {
      actualCalls += 1
      Some(onCallHandler match {
        case Some(h) => h(arguments)
        case None => null
      })
    } else {
      None
    }
  }
  
  private def argumentsMatcher_=(matcher: Function1[Array[Any], Boolean]) {
    require(!argumentsMatcher.isDefined, "arguments matcher can only be set once")
    argumentsMatcher = Some(matcher)
  }
  
  private def onCallHandler_=(handler: Function1[Array[Any], Any]) {
    require(!onCallHandler.isDefined, "on call behaviour can only be set once")
    onCallHandler = Some(handler)
  }
  
  private def expectedCallsString = "expected calls: "+ (
    expectedCalls match {
      case Some(c) if c.start == c.last => c.start
      case Some(c) => c.start +" to "+ c.last
      case None => "1"
    }
  )
  
  private def actualCallsString = "actual calls: " + actualCalls

  private var argumentsMatcher: Option[Array[Any] => Boolean] = None
  private var onCallHandler: Option[Array[Any] => Any] = None
  private var expectedCalls: Option[Range] = None
  
  private var argumentsString = ""
  private var returnString = ""

  private var actualCalls = 0
}
