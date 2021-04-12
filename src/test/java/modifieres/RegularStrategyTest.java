package modifieres;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RegularStrategyTest {
    RegularStrategy regularStrategy = new RegularStrategy();

    @Test
    void testSnakeCase() throws Exception {
        String result = regularStrategy.generateDeclaration("document_id");
        Assertions.assertEquals("public static final String DOCUMENT_ID = \"document_id\";", result);
    }

    @Test
    void testCamelCase() throws Exception {
        String result = regularStrategy.generateDeclaration("documentId");
        Assertions.assertEquals("public static final String DOCUMENT_ID = \"documentId\";", result);
    }

    @Test
    void testPascalCase() throws Exception {
        String result = regularStrategy.generateDeclaration("DocumentId");
        Assertions.assertEquals("public static final String DOCUMENT_ID = \"DocumentId\";", result);
    }

    @Test
    void testOneSpaceCase() throws Exception {
        String result = regularStrategy.generateDeclaration("document id");
        Assertions.assertEquals("public static final String DOCUMENT_ID = \"document id\";", result);
    }

    @Test
    void testManySpaceCase() throws Exception {
        String result = regularStrategy.generateDeclaration("document   id");
        Assertions.assertEquals("public static final String DOCUMENT_ID = \"document   id\";", result);
    }

    @Test
    void testDottedCase() throws Exception {
        String result = regularStrategy.generateDeclaration("document.id");
        Assertions.assertEquals("public static final String DOCUMENT_ID = \"document.id\";", result);
    }

    @Test
    void testLongDottedCase() throws Exception {
        String result = regularStrategy.generateDeclaration("example.source.document.id");
        Assertions.assertEquals("public static final String EXAMPLE_SOURCE_DOCUMENT_ID = \"example.source.document.id\";", result);
    }

    @Test
    void testKebabCase() throws Exception {
        String result = regularStrategy.generateDeclaration("document-id");
        Assertions.assertEquals("public static final String DOCUMENT_ID = \"document-id\";", result);
    }

    @Test
    void testNewlines() {
        String result = regularStrategy.generateDeclaration("document-id\ndocument-name");
        Assertions.assertEquals("\tpublic static final String DOCUMENT_ID = \"document-id\";\n\tpublic static final String DOCUMENT_NAME = \"document-name\";\n", result);
    }
}
