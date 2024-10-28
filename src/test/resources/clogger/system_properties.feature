Feature: Exclusive resources

   @reads-and-writes-system-properties
   Scenario: first example
      Given this reads and writes system properties
      When it is executed
      Then it will not be executed concurrently with the "second" example

   @reads-system-properties
   Scenario: second example
      Given this reads system properties
      When it is executed
      Then it will not be executed concurrently with the "first" example