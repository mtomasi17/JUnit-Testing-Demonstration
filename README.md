"# week12JUnitTestingAssignment" 

Project Description:
The JUnit Testing Assignment was built in order to allow the demonstration of how to perform JUnit Testing
by following a given set of instructions provided by Promineo Tech.  In addition to that I was told to imoplement my own
method and test also. 

Technologies Used:  
Java
Maven

Highlights:
Within the project one of the highlights of the project was being able to create my own set of code and JUnit Test.  
I had a lot of fun creating a method that would take a written word such as "sail" and then would reverse the ordering of 
the letters to look like "lias"   

Code Snippets:
(TestDemo.java)
public String reverseString(String str) {
		return new StringBuilder(str).reverse().toString();
	}

(TestDemoJUnitTest.java)
 static Stream<Arguments> argumentsForReverseString() {
        return Stream.of(
            Arguments.of("hello", "olleh"),
            Arguments.of("tacocat", "tacocat"),
            Arguments.of("spine", "enips"),
            Arguments.of("world", "dlrow"),
            Arguments.of("", "")
            );
	}

