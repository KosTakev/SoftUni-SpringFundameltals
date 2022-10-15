package softuni.thymeleaf;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.StringWriter;

public class Test {

    public static void main(String[] args) {

        TemplateEngine engine = createEngine();
        Context context = new Context();
        context.setVariable("name", "Pesho");
        StringWriter stringWriter = new StringWriter();

        engine.process("test.html",context, stringWriter);

        System.out.println(stringWriter.toString());
    }

    private static TemplateEngine createEngine() {
        TemplateEngine engine = new TemplateEngine();
        engine.setTemplateResolver(new ClassLoaderTemplateResolver());
        return engine;
    }
}


