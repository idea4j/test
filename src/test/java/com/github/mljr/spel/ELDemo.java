package com.github.mljr.spel;

import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class ELDemo {

    /**
     * Spel表达式的测试
     *
     * @throws Exception
     */
    @Test
    public void testHelloWorld() throws Exception {
        // 1）创建解析器：SpEL使用ExpressionParser接口表示解析器，提供SpelExpressionParser默认实现；
        // 2）解析表达式：使用ExpressionParser的parseExpression来解析相应的表达式为Expression对象。
        // 3）构造上下文：准备比如变量定义等等表达式需要的上下文数据。
        // 4）求值：通过Expression接口的getValue方法根据上下文获得表达式值。
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("('Hello' + ' World').concat(#end)");
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("end", "!");
        String value = (String) expression.getValue(context);
        System.out.println(value);
    }

    @Test
    public void testParserContext() throws Exception {
        ExpressionParser parser = new SpelExpressionParser();
        ParserContext context = new ParserContext() {
            @Override
            public boolean isTemplate() {
                return true;
            }

            @Override
            public String getExpressionPrefix() {
                return "#{";
            }

            @Override
            public String getExpressionSuffix() {
                return "}";
            }
        };
        Expression expression = parser.parseExpression("#{'Hello '}#{'World!'}",context);
        System.out.println(expression.getValue());
    }

    @Test
    public void testVariable() throws Exception {
        ExpressionParser parser = new SpelExpressionParser();
        Float value = parser.parseExpression("1.1").getValue(Float.class);
        System.out.println(value);
    }

}
