package de.nordakademie.ui;

import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

import org.testng.annotations.Test;

import de.nordakademie.business.message.MessageService;

public class HomePageTest {

    @Test
    public void shouldRenderHomePage() {
        // given
        final NakWicketSeminarWicketTester wicketTester = NakWicketSeminarWicketTester.builder()
                .withMock(mock(MessageService.class)).build();

        // when
        wicketTester.startPage(HomePage.class);

        // then
        assertThat((HomePage) wicketTester.getLastRenderedPage(), isA(HomePage.class));
    }
}
