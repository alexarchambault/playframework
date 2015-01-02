import org.junit.*;

import play22.mvc.*;
import play22.test.*;
import play22.data.DynamicForm;
import play22.data.validation.ValidationError;
import play22.data.validation.Constraints.RequiredValidator;
import play22.i18n.Lang;
import play22.libs.F;
import play22.libs.F.*;

import static play22.test.Helpers.*;
import static org.fest.assertions.Assertions.*;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

    @Test
    public void simpleCheck() {
        int a = 1 + 1;
        assertThat(a).isEqualTo(2);
    }

    @Test
    public void renderTemplate() {
        Content html = views.html.index.render("Your new application is ready.");
        assertThat(contentType(html)).isEqualTo("text/html");
        assertThat(contentAsString(html)).contains("Your new application is ready.");
    }


}
