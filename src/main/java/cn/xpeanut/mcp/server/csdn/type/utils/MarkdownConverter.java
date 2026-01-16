package cn.xpeanut.mcp.server.csdn.type.utils;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.MutableDataSet;

public class MarkdownConverter {

    private static final Parser parser;

    private static final HtmlRenderer renderer;

    static {
        MutableDataSet mutableDataSet = new MutableDataSet();
        parser = Parser.builder(mutableDataSet).build();
        renderer = HtmlRenderer.builder(mutableDataSet).build();
    }

    public static String convertToHtml(String markdown) {
        if (markdown == null || markdown.trim().isBlank()) {
            return "";
        }
        return renderer.render(parser.parse(markdown));
    }

}
