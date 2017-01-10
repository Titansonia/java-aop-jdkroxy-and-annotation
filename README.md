### This is a JDKProxy and Java Annotation based Java AOP implementation.

`ProxyFactory` is where target object is bound with the specific handler according to the annotations.

`aspect.Aspect` inherits `AbstractHandler` and overwrites the `invoke()` method which is in this project further be annotated by `@Before`,` @Around` and `@After` to perform the related aspect actions.