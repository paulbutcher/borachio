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

import org.scalatest.{BeforeAndAfterEach, Suite}

/** Trait that can be mixed into a [[http://www.scalatest.org/ ScalaTest]] suite to provide
  * mocking support.
  *
  * See [[com.borachio]] for overview documentation.
  */
trait MockFactory extends ProxyMockFactory with BeforeAndAfterEach { this: Suite =>
  
  override def beforeEach() {
    expectations.reset
    expectationContext = expectations
  }
  
  override def afterEach() {
    if (autoVerify)
      verifyExpectations
  }

  protected def verifyExpectations() {
    expectations.verify
  }
  
  protected def inSequence(what: => Unit) {
    require(expectationContext == expectations, "inSequence cannot be nested")
    val orderedExpectations = new OrderedExpectations
    expectations.add(orderedExpectations)
    expectationContext = orderedExpectations
    what
    expectationContext = expectations
  }

  protected implicit def MockFunctionToExpectation(m: MockFunction) = {
    val expectation = new Expectation(m)
    expectationContext.add(expectation)
    expectation
  }
  
  protected def mockFunction[R] = new MockFunction0[R](expectations)
  protected def mockFunction[T1, R] = new MockFunction1[T1, R](expectations)
  protected def mockFunction[T1, T2, R] = new MockFunction2[T1, T2, R](expectations)
  protected def mockFunction[T1, T2, T3, R] = new MockFunction3[T1, T2, T3, R](expectations)
  protected def mockFunction[T1, T2, T3, T4, R] = new MockFunction4[T1, T2, T3, T4, R](expectations)
  protected def mockFunction[T1, T2, T3, T4, T5, R] = new MockFunction5[T1, T2, T3, T4, T5, R](expectations)
  protected def mockFunction[T1, T2, T3, T4, T5, T6, R] = new MockFunction6[T1, T2, T3, T4, T5, T6, R](expectations)
  protected def mockFunction[T1, T2, T3, T4, T5, T6, T7, R] = new MockFunction7[T1, T2, T3, T4, T5, T6, T7, R](expectations)
  protected def mockFunction[T1, T2, T3, T4, T5, T6, T7, T8, R] = new MockFunction8[T1, T2, T3, T4, T5, T6, T7, T8, R](expectations)
  protected def mockFunction[T1, T2, T3, T4, T5, T6, T7, T8, T9, R] = new MockFunction9[T1, T2, T3, T4, T5, T6, T7, T8, T9, R](expectations)
  protected def mockFunction[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R] = new MockFunction10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R](expectations)
  
  protected var autoVerify = true

  private[borachio] val expectations = new UnorderedExpectations
  private var expectationContext: Expectations = _
}
