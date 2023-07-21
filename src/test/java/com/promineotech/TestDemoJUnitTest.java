package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {
	
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}
	
	/*The first test, assertThatTwoPositiveNumbersAreAddedCorrectly, is a 
	 * parameterized test that takes three arguments: the first two arguments are the 
	 * two numbers to be added, and the third argument is the expected result.
	 * The test asserts that the result of the addPositive method is equal to the expected result.
	 */
	@ParameterizedTest
    @MethodSource("argumentsForAddPositive")
    void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
        if (!expectException) {
            assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
        } else {
            assertThatThrownBy(() -> testDemo.addPositive(a, b))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Both parameters must be positive!");
        }
    }
	
	/* The test assertThatPairsOfPositiveNumbersAreAddedCorrectly is a 
	 * regular test that calls the addPositive method with three different pairs 
	 * of positive numbers. The test asserts that the result of the 
	 * addPositive method is equal to the expected result for each pair 
	 * of positive numbers.
	 */
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
	    assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
	    assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
	    assertThat(testDemo.addPositive(10, 10)).isEqualTo(20);
	}
	
	/*The test, argumentsForAddPositive, is a static method that returns a Stream 
	 * of Arguments objects. Each Arguments object contains three values: the first value 
	 * is the first number to be added, the second value is the second number to be added, 
	 * and the third value is the expected result.
	 */
	
	static Stream<Arguments> argumentsForAddPositive() {
        return Stream.of(
            Arguments.of(1, 2, 3, false),
            Arguments.of(3, 4, 7, false),
            Arguments.of(-2, 3, 0, true),
            Arguments.of(-2, -3, 0, true),
            Arguments.of(10, 5, 15, false),
            Arguments.of(8, 0, 0, true),
            Arguments.of(0, 3, 0, true)
            
        );
    }
	
	/*The test, assertThatStringIsReversedCorrectly, is a parameterized test that takes 
	 * two arguments: the first argument is the string to be reversed, and the second argument 
	 * is the expected reversed string. The test asserts that the result of the reverseString method 
	 * is equal to the expected reversed string
	 */
	
	@ParameterizedTest
	@MethodSource("argumentsForReverseString")
	void assertThatStringIsReversedCorrectly(String str, String expected) {
		assertThat(testDemo.reverseString(str)).isEqualTo(expected);
	}
	
	/*argumentsForReverseString, is a static method that returns a Stream of Arguments objects. 
	 * Each Arguments object contains two values: the first value is the string to be reversed, 
	 * and the second value is the expected reversed string.
	 */
	static Stream<Arguments> argumentsForReverseString() {
        return Stream.of(
            Arguments.of("hello", "olleh"),
            Arguments.of("tacocat", "tacocat"),
            Arguments.of("spine", "enips"),
            Arguments.of("world", "dlrow"),
            Arguments.of("", "")
            );
	}
	
	/*The test, assertThatNumberSquaredIsCorrect, tests the randomNumberSquared method. The 
	 * test first creates a mock object of the TestDemo class and then tells the mock object to 
	 * return the value 5 when the getRandomInt method is called. The test then calls the 
	 * randomNumberSquared method on the mock object and asserts that the result is equal to 25.
	 */
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}

}