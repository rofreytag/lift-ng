package net.liftmodules.ng.test

trait Client2ServerBindingSpecs extends BaseSpec {
  def tests = {
    "The input text" should "be reflected in the output text" in {
      eventually { id("output").element.text should be ("") }
      textField("input").value = "a"
      eventually { id("output").element.text should be ("a") }
      textField("input").value = "ab"
      eventually { id("output").element.text should be ("ab") }
      textField("input").value = "abc"
      eventually { id("output").element.text should be ("abc") }
    }
  }
}

class Client2ServerSessionBindingSpecs extends Client2ServerBindingSpecs {
  "The Server To Client Binding Tests page" should "load" in {
    go to s"$index/client2ServerSessionBind"
    eventually { pageTitle should be ("App: Client 2 Server Session Binding") }
  }

  tests

  "The input" should "persist over a reload of the page" in {
    reloadPage()
    eventually { textField("input").value should be ("abc") }
  }
}
