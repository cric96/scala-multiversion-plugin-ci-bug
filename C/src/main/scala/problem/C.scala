package problem
case class C() {
  def foo: String = A().foo + B().foo
}
