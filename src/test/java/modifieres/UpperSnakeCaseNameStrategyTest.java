package modifieres;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UpperSnakeCaseNameStrategyTest {
    UpperSnakeCaseNameStrategy upperSnakeCaseNameStrategy = new UpperSnakeCaseNameStrategy();

    @Test
    void testSnakeCase() throws Exception {
        String result = upperSnakeCaseNameStrategy.generateDeclaration("document_id");
        Assertions.assertEquals("public static final String DOCUMENT_ID = \"document_id\";", result);
    }

    @Test
    void testCamelCase() throws Exception {
        String result = upperSnakeCaseNameStrategy.generateDeclaration("documentId");
        Assertions.assertEquals("public static final String DOCUMENT_ID = \"documentId\";", result);
    }

    @Test
    void testPascalCase() throws Exception {
        String result = upperSnakeCaseNameStrategy.generateDeclaration("DocumentId");
        Assertions.assertEquals("public static final String DOCUMENT_ID = \"DocumentId\";", result);
    }

    @Test
    void testOneSpaceCase() throws Exception {
        String result = upperSnakeCaseNameStrategy.generateDeclaration("document id");
        Assertions.assertEquals("public static final String DOCUMENT_ID = \"document id\";", result);
    }

    @Test
    void testManySpaceCase() throws Exception {
        String result = upperSnakeCaseNameStrategy.generateDeclaration("document   id");
        Assertions.assertEquals("public static final String DOCUMENT_ID = \"document   id\";", result);
    }

    @Test
    void testDottedCase() throws Exception {
        String result = upperSnakeCaseNameStrategy.generateDeclaration("document.id");
        Assertions.assertEquals("public static final String DOCUMENT_ID = \"document.id\";", result);
    }

    @Test
    void testLongDottedCase() throws Exception {
        String result = upperSnakeCaseNameStrategy.generateDeclaration("example.source.document.id");
        Assertions.assertEquals("public static final String EXAMPLE_SOURCE_DOCUMENT_ID = \"example.source.document.id\";", result);
    }

    @Test
    void testKebabCase() throws Exception {
        String result = upperSnakeCaseNameStrategy.generateDeclaration("document-id");
        Assertions.assertEquals("public static final String DOCUMENT_ID = \"document-id\";", result);
    }
}
