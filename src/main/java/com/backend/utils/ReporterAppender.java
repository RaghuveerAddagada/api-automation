package com.backend.utils;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.testng.Reporter;

@Plugin(name = "ReporterAppender", category = "Core", elementType = Appender.ELEMENT_TYPE, printObject = true)
public class ReporterAppender extends AbstractAppender {

    protected ReporterAppender(String name, Layout<?> layout) {
        super(name, null, layout, false, Property.EMPTY_ARRAY);
    }

    @PluginFactory
    public static ReporterAppender createAppender(@PluginAttribute("name") String name,
                                                  @PluginAttribute("ignoreExceptions") boolean ignoreExceptions) {
        return new ReporterAppender(name, null);
    }

    @Override
    public void append(LogEvent event) {
        // Redirect the only INFO message to TestNG Reporter.log
        final String message = event.getMessage().getFormattedMessage();
        if (event.getLevel().toString().equals("INFO")) {
            Reporter.log(message);
        }
    }
}