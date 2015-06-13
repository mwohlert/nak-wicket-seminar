package de.nordakademie.ui;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

import org.testng.annotations.Test;

import de.nordakademie.business.message.ProductService;

public class HomePageTest {

    @Test
    public void shouldRenderHomePage() {
        // given
        final NakWicketSeminarWicketTester wicketTester = NakWicketSeminarWicketTester.builder()
                .withMock(mock(ProductService.class)).build();

        // when
        wicketTester.startPage(HomePage.class);

        // then
        assertThat(wicketTester.getLastRenderedPage(), instanceOf(HomePage.class));
    }
}
