package com.mojito.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringEscapeUtils;
import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.ext.heading.anchor.HeadingAnchorExtension;
import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.NodeRenderer;
import org.commonmark.renderer.html.AttributeProvider;
import org.commonmark.renderer.html.HtmlNodeRendererContext;
import org.commonmark.renderer.html.HtmlRenderer;
import org.commonmark.renderer.html.HtmlWriter;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author liufengqiang
 * @date 2020-10-25 10:37:41
 */
@Slf4j
public class MarkdownUtils {

    /**
     * markdown格式转换成HTML格式
     *
     * @param markdown
     * @return
     */
    public static String markdownToHtml(String markdown) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().nodeRendererFactory(IndentedCodeBlockNodeRenderer::new).build();
        return renderer.render(document);
    }

    /**
     * 增加扩展[标题锚点，表格生成]
     * Markdown转换成HTML
     *
     * @param markdown
     * @return
     */
    public static String markdownToHtmlExtensions(String markdown) {
        //h标题生成id
        Set<Extension> headingAnchorExtensions = Collections.singleton(HeadingAnchorExtension.create());
        //转换table的HTML
        List<Extension> tableExtension = Collections.singletonList(TablesExtension.create());
        Parser parser = Parser.builder()
                .extensions(tableExtension)
                .build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder()
                .extensions(headingAnchorExtensions)
                .extensions(tableExtension)
                .attributeProviderFactory(context -> new CustomAttributeProvider())
                .build();
        return StringEscapeUtils.unescapeHtml4(renderer.render(document));
    }

    private static class IndentedCodeBlockNodeRenderer implements NodeRenderer {

        private final HtmlWriter html;

        IndentedCodeBlockNodeRenderer(HtmlNodeRendererContext context) {
            this.html = context.getWriter();
        }


        @Override
        public Set<Class<? extends Node>> getNodeTypes() {
            return Collections.singleton(IndentedCodeBlock.class);
        }

        @Override
        public void render(Node node) {
            IndentedCodeBlock codeBlock = (IndentedCodeBlock) node;
            html.line();
            html.tag("pre222");
            html.text(codeBlock.getLiteral());
            html.tag("/pre222");
            html.line();
        }
    }

    /**
     * 处理标签的属性
     */
    static class CustomAttributeProvider implements AttributeProvider {
        @Override
        public void setAttributes(Node node, String tagName, Map<String, String> attributes) {
            // 改变a标签的target属性为_blank
            if (node instanceof Link) {
                attributes.put("target", "_blank");
            }
            if (node instanceof TableBlock) {
                attributes.put("class", "ui celled table");
            }
            if (node instanceof ListItem) {
                try {
                    Text firstChild = (Text) node.getFirstChild().getFirstChild();
                    Text lastChild = (Text) node.getLastChild().getLastChild();
                    firstChild.setLiteral("<section>" + firstChild.getLiteral());
                    lastChild.setLiteral(lastChild.getLiteral() + "</section>");
                } catch (Exception e) {
                    log.error("增加section异常");
                }
            }
            try {
                if (node instanceof Heading) {
                    attributes.put("class", "ui celled table");
                    Text lastChild = (Text) node.getLastChild();
                    if (lastChild != null) {
                        lastChild.setLiteral("<span class=\"content\">" + lastChild.getLiteral() + "</span>");
                    }
                }
            } catch (Exception e) {
                log.error("解析Heading异常");
            }
            if ("pre".equals(tagName)) {
                attributes.put("class", "custom");
            }
            if ("code".equals(tagName)) {
                attributes.put("class", "hljs");
            }
        }
    }

    public static void main(String[] args) {
        String str = "```\n" +
                "你好\n" +
                "```";
        System.out.println(markdownToHtmlExtensions(str));
    }
}
