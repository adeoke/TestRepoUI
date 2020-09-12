# Selenium Spring Testing project

# Motivation
I decided to create a selenium webdriver project using spring as a DI approach.

# Demo

TODO

# Tools/Libraries Used.

Selenium-WebDriver
Junit Jupiter
Spring
WebDriverManager

# Profile specific drivers
To switch between mobile and desktop views pass in the correct profile.
For example, to run the desktop view do the following:

```console
$ mvn test -Dspring.profiles.active=desktop
```

To run the mobile view do the following:

```console
$ mvn test -Dspring.profiles.active=mobile
```

WIP...

