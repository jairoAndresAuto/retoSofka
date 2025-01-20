# Serenity BDD project using Cucumber and Screenplay 
16/08/2022

Serenity BDD is a library that makes it easier to write high quality automated acceptance tests, with powerful reporting and living documentation features. It has strong support for both web testing with Selenium, and API testing using RestAssured.

Serenity strongly encourages good test automation design, and supports several design patterns, including classic Page Objects, the newer Lean Page Objects/ Action Classes approach, and the more sophisticated and flexible Screenplay pattern.

### Prerequisites
* Java 17 installed
* Gradle  (Suggested version 7.5.1)
* IDE installed (Suggested IntelliJ IDEA 2022.2)
* Sourcetree
* Google Chrome installed

### Basic Commands

To run a specific Tag
`gradle clean test -Dcucumber.filter.tags=@smoketest`

To run a specific Runner
`gradle clean test --tests=Login`

<img src="https://blog.caplin.com/wp-content/uploads/2016/12/screenPlayWorkFlow-1024x511.png" alt="Screenplay Pattern" />

### Actor
Actors have some kind of **goals:** they want to achieve certain things, so let define our actor as Mauricio

Actors also have **abilities:** Mauricio might be able to browse the web, able to interact with the web interface.

Actors have **tasks** to achieve their **goals:** Mauricio can perform certain **tasks** 

### Tasks
Tasks are business level concepts, they are concerned with whether we are trying to interact with a UI, interacting with Web service or a with a RESTful service. Here Mauricio wants to search for the available tickets from the origin to destination.

Actors use their ability to **interact with the system** in order to perform the task. Here john will enter the source and destination station, select a given date and finally search for a ticket.

### Actions/InterActions
Actions/InterActions are classes which encapsulate interactions between the user and the system. We don’t think in terms of pages or fields rather we think in terms of the behaviour of how the user interacts with the system. The Actor will **Enter** something on a provided element and Click on an element, and where do we get it from, well we get it from a **PageObject** and its only role is to contain the locators for the field.

### Questions
Actors can ask **Questions** about the state of the system: Actors use these questions to test their assumptions or to check their expectations about what the results of the outcome should be.

Actors should get **answers** to questions he/she asked so that it can be decided whether it’s right or wrong.

## Reference:
* **[Screenplay Pattern](https://blog.caplin.com/2017/01/04/screenplay-pattern-a-solid-alternative-pattern-to-page-objects/)**
* **[Screenplay Pattern](https://medium.com/testvagrant/screenplay-pattern-3490c7f0c23c)**
* **[SOLID Principles](https://www.freecodecamp.org/news/solid-principles-explained-in-plain-english/#:~:text=The%20SOLID%20Principles%20are%20five,and%20software%20architecture%20in%20general.)**

## Want to learn more?
For more information about Serenity BDD, you can read the [**Serenity BDD Book**](https://serenity-bdd.github.io/theserenitybook/latest/index.html), the official online Serenity documentation source. Other sources include:
* **[Learn Serenity BDD Online](https://expansion.serenity-dojo.com/)** with online courses from the Serenity Dojo Training Library
* **[Byte-sized Serenity BDD](https://www.youtube.com/channel/UCav6-dPEUiLbnu-rgpy7_bw/featured)** - tips and tricks about Serenity BDD
* For regular posts on agile test automation best practices, join the **[Agile Test Automation Secrets](https://www.linkedin.com/groups/8961597/)** groups on [LinkedIn](https://www.linkedin.com/groups/8961597/) and [Facebook](https://www.facebook.com/groups/agiletestautomation/)
* [**Serenity BDD Blog**](https://johnfergusonsmart.com/category/serenity-bdd/) - regular articles about Serenity BDD
